# Arch Linux telepítése

Fontosabb linkek:

* [Arch Linux Wikipédia](https://wiki.archlinux.org/)
* [Arch Linux **Alap** Csomagok](https://www.archlinux.org/packages/)
* [Arch Linux **AUR** Csomagok](https://aur.archlinux.org/packages/)

Telepítés során alkalmazott billentyűzet beállítása

```shell
$ loadkeys hu
```

## Internet tesztelése

 ```bash
$ ping www.google.hu
```

## UEFI tesztelése

 ```bash
$ ls /sys/firmware/efivars
```

## Particiók létrehozása

`$ fdisk -l` parancsal megtekinthető, melyik vinyót szeretnénk módosítani

```bash
$ cfdisk /dev/sda
```

`swap` = **RAM** mennyisége * 1,5

**MBR** esetén

* `sda1` 8G Linux swap
* `sda2` 120G linux, root, bootable

**GPT** esetén

* `sda1` 512M EFI System (boot loader)
* `sda2` 8G Linux swap
* `sda3` 120G Linux filesystem

### EFI partició formázása

```bash
$ mkfs.fat -F32 /dev/sda1
```

### Swap létrehozása és bekapcsolása

```bash
$ mkswap /dev/sda2
$ swapon /dev/sda2
```

### Linux filesystem formázás

```bash
$ mkfs.ext4 /dev/sda3
```

## Telepítés

*Mount ahova telepítesz!*

```bash
$ mount /dev/sda3 /mnt
$ mkdir /mnt/home
$ mount /dev/sda3 /mnt/home

$ pacstrap -i /mnt base base-devel
$ genfstab -U -p /mnt >> /mnt/etc/fstab
$ arch-chroot /mnt /bin/bash
```

### Localizáció

```bash
$ nano /etc/locale.gen
```

Kikell venni a `#`-et az `en_GB.UTF-8` és `hu_HU.UTF-8` elöl, majd localizálás

```bash
$ locale-gen
```

### Helyi idő beállítása

```bash
$ rm /etc/localtime
$ ln -s /usr/share/zoneinfo/Europe/Budapest /etc/localtime
$ hwclock --systohc -utc
$ timedatectl set-local-rtc 1 --adjust-system-clock
```

### Számítógépnév beállítása

```bash
$ echo Xentinus-Development > /etc/hostname
```

### Internet beállítása

`$ nano /etc/hosts`paranccsal átkell írni

```bash
127.0.0.1 localhost.localdomain Xentinus-Development
```

#### NetworkManager telepítése

```bash
$ pacman -S networkmanager
$ systemctl enable NetworkManager
```

### Root jelszó beállítása

```bash
$ passwd
```

### Bootloader beállítása

```bash
$ pacman -S grub efibootmgr
$ mkdir /boot/efi
$ mount /dev/sda1 /boot/efi
$ grub-install --target=x86_64-efi --bootloader-id=GRUB --efi-directory=/boot/efi
$ grub-mkconfig -o /boot/grub/grub.cfg
$ mkdir /boot/efi/EFI/BOOT
$ cp /boot/efi/EFI/GRUB/grubx64.efi /boot/efi/EFI/BOOT/BOOTX64.EFI
```

`$ nano /boot/efi/startup.nsh` al startup leírása

```bash
bcf boot add 1 fs0:\EFI\GRUB\grubx64.efi "My GRUB bootloader"
exit
```

## Rendszer újraindítása

```bash
$ exit
$ unmount -R /mnt
$ reboot
```

Bejelentkezés után `root`-ba kell belépni az általunk megadott jelszóval

### Felhasználó hozzáadása

```bash
$ useradd -m -g users -G wheel,storage,power -s /bin/bash xentinus
$ passwd xentinus
```

### Sudo bekapcsolása

`$ EDITOR=nano visudo` parancs segítségével megkell keresni a `%wheel ALL=(ALL) ALL`-t és kivenni elöle a `#`-et

*Ezután kiléphetünk a root-ból és beléphetünk az általunk készített felhasználóba*

### Billentyűzet beállítása

`$ nano /etc/vconsole.conf` paranccsal beállíthatjuk a magyar billentyűzetünket

```bash
KEYMAP=hu
FONT=lat2-16
FONT_MAP=8859-2
```

## Alkalmazások és egyebek telepítése

### Bash telepítése

```bash
$ pacman -S bash-completion
```

### Videokártya telepítése

```bash
$ pacman -S xorg xorg-xinit xorg-server xorg-apps 
$ pacman -S nvidia nvidia-utils
```

### Display Manager telepítése

```bash
$ pacman -S xfce4 xfce4-goodies
$ echo "exec startxfce4" > ~/.xinitrc
```

### AUR programok eléréséhez

*Késöbb törölni kell a `yay` mappát a `HOME`-ból*

```bash
$ pacman -S git
$ git clone https://aur.archlinux.org/yay.git
$ cd yay
$ makepkg -si
```

### Login Manager telepítése

*Litarvan's LightDM Theme 3.0.0 [letöltése](https://github.com/Litarvan/lightdm-webkit-theme-litarvan)*

```bash
$ pacman -S lightdm
$ yay lightdm-webkit-theme-litarvan
$ systemctl enable lightdm
$ localectl set-x11-keymap hu
```

#### Login Manager beállítása

> A fájlok elérhetők az `src` mappában!

`$ nano /etc/lightdm/lightdm.conf` -al megkeresni és átírni:

```bash
greeter-session=lightdm-webkit2-greeter
display-setup-script=/usr/bin/dualmon.sh
```

`$ nano /etc/lightdm/lightdm-webkit2-greeter.conf` -al megkeresni és átírni

```bash
webkit_theme      = litarvan
logo              = /usr/share/pixmaps/xentinus.png
user_image        = /usr/share/pixmaps/xentinus.png
```

### Microcode telepítése

```bash
$ pacman -S intel-ucode
$ grub-mkconfig -o /boot/grub/grub.cfg
```

### Tűzfal telepítése

```bash
$ pacman -S ufw
$ ufw enable
$ systemctl enable ufw.service
```

### Hang telepítése

```bash
$ pacman -S alsa-utils pulseaudio pavucontrol
```

### NTFS partíció támogatása

*Ez csak akkor szükséges ha van egy közös partició a windows-al ami NTFS*

```bash
$ pacman -S ntfs-3g
```

### Egyéb particíók megjelenítésének beállítása

`$ nano /etc/fstab/` beállítása hasonlóra

*Attól függ mit kell megjeleníteni és mit nem*

```bash
# Static information about the filesystems.
# See fstab(5) for details.

# <file system> <dir> <type> <options> <dump> <pass>
# Arch Linux - Root
UUID=9fbfbc80-597e-4daf-af90-bbecfa26fb4b	/         	ext4      	rw,relatime	0 1

# Arch Linux - Swap
UUID=c95c1e39-ff82-43c5-8203-6a7dec0b70fb	none      	swap      	defaults  	0 0

# Global Storage
UUID=6CE6AD66E6AD316E /mnt/6CE6AD66E6AD316E ntfs-3g users,defaults,x-gvfs-show,x-gvfs-name=Global%20Storage 0 0

# Windows Storage
UUID=7E54F89654F8527F /mnt/7E54F89654F8527F auto nosuid,nodev,nofail,noauto 0 0
```

### Kuka és eltávolítható particiók telepítése

```bash
$ pacman -S gvfs
```

#### Alkalmazások telepítése

| Csomag neve | Csomag típusa |
| --- | --- |
| chromium | Alap |
| pkgstats | Alap |
| vlc | Alap |
| teamspeak3 | Alap |
| qbittorrent | Alap |
| discord | **AUR** |
| pamac-aur | **AUR** |
| spotify | **AUR** |
| spotify-adblock-git | **AUR** |

#### Developper alkalmazások telepítése

| Csomag neve | Csomag típusa |
| --- | --- |
| nodejs | Alap |
| npm | Alap |
| Docker | Alap |
| docker-compose | Alap |
| docker-machine | Alap |
| speedtest-cli | Alap |
| gnome-disk-utility | Alap |
| visual-studio-code-bin | **AUR** |
| postman-bin | **AUR** |
| github-desktop-bin | **AUR** |
| heroku-cli | **AUR** |
| code-server | **AUR** |
| font-manager | **AUR** |
| mongodb-bin | **AUR** |
| mongodb-tools-bin | **AUR** |
| mongodb-compass | **AUR** |

#### Egyebek programok telepítése

| Csomag neve | Csomag típusa |
| --- | --- |
| albert | Alap |
| arc-gtk-theme | Alap |
| papirus-icon-theme | Alap |
| powerline | Alap |
| Htop | Alap |
| Seahorse | Alap |
| adobe-source-code-pro-fonts | Alap |
| adobe-source-sans-pro-fonts | Alap |
| ttf-ubuntu-font-family | Alap |
| bibata-cursor-theme | **AUR** |
| nerd-fonts-complete | **AUR** |
| polybar | **AUR** |

### Service-k bekapcsolása

```bash
$ systemctl enable mongodb.service
```

## Beállítások

### Appearance

| Füll | Parancs | Érték |
| --- | --- | --- |
| Style | Stílus kiválasztása | Arc-Darker |
| Icons | Ikon kiválasztása | Papirus-Dark |
| Fonts | Alap betűtípus beállítása | Source Sans Pro 10 |
| Fonts | Alap Monospace betűtípus beállítása | Source Code Pro 10 |
| Fonts | Custom DPI bekapcsolása | 96-os értékkel |
| Settings | Event hangok bekapcsolása | Mindegyik bekapcsolva |

### Dekstop

| Füll | Parancs | Érték |
| --- | --- | --- |
| Background | Háttérkép beállítása | Kép kiválasztása |
| Menus | Középső gombos menűlista | Kikapcsolva |
| Icons | Tooltip ikon mérete | 32 |
| Icons | Kuka ikonja | Kikapcsolva |

### File Manager Preferences

| Füll | Parancs | Érték |
| --- | --- | --- |
| Display | Megtekintés típusa új mappáknál | Részletes lista |
| Behaviour | Instant törlés megjelenítése | Bekapcsolva |

### Notifications

| Füll | Parancs | Érték |
| --- | --- | --- |
| General | Notificationök helyei | Elsődleges képernyő |
| General | Notificationök eltünése | 3 másodperc után |

### Window Manager

| Füll | Parancs | Érték |
| --- | --- | --- |
| Style | Téma kiválasztása | Arc-Darker |
| Style | Betűtípus kiválasztása | Source Sans Pro Bold 11 |
| Style | Shade levétele | Rejtett |

### Windows Manager Tweaks

| Füll | Parancs | Érték |
| --- | --- | --- |
| Accessibility | Görgözésnél feltekeredík az ablak | Kikapcsolva |
| Workspaces | Minden kikapcsolva |
| Placesment | Minimum érték | Large |

### Workspaces

| Füll | Parancs | Érték |
| --- | --- | --- |
| General | Workspacek mennyisége | 1 |

### Terminal Preferences

## Terminal Present beállítása

`/usr/share/xfce4/terminal/colorschemes/` <- `onedark.theme` fájl bemásolása az `src` mappából

| Füll | Parancs | Érték |
| --- | --- | --- |
| General | Dinamikus fejléc | Kikapcsolva |
| General | Scrollbar megjelenítése | Kikapcsolva |
| General | Végtelen visszatekerhetőség | Bekapcsolva |
| General | Kurzos beállítása | Block - villogva |
| Appearance | Betűtípus beállítása | Rendszer betűtípus bekapcsolva |
| Appearance | Háttér beállítása | Átlátszó 0.95 |
| Appearance | Oszlopok mennyisége | 120 |
| Appearance | Sorok mennyisége | 30 |
| Colours | Presets beállítása | One Dark |
| Advanced | Középső gombal tabok bezárása | Kikapcsolva |

### Mouse and Touchpad

| Füll | Parancs | Érték |
| --- | --- | --- |
| Theme | Egér témája | Bibata Ice |

### Power Manager

| Füll | Parancs | Érték |
| --- | --- | --- |
| General | Notificaiton-ök megjelenítése | Bekapcsolva |
| Display | Display Manager megjelenítése | Kikapcsolva |
| Display | Képernyő kikapcsolása | 60 perc |

### Removable Drives and Media

| Füll | Parancs | Érték |
| --- | --- | --- |
| Storage | Hot-plug eszköz csatlakoztatása | Bekapcsolva |
| Storage | Media eszköz csatlakoztatása | Bekapcsolva |
| Storage | Media eszköz megnyítása csatlakozáskor | Bekapcsolva |

## Albert beállítása

| Füll | Parancs | Érték |
| --- | --- | --- |
| General | Hotkey | Menu |
| General | Tálca ikon | Kikapcsolva |
| General | Terminal | XFCE-Terminal |
| General | Sorrendbe rakás | Bekapcsolva |
| General | Indítás a rendszerrel | Bekapcsolva |
| General | Téma | Arc Dark Blue |
| General | Eredmények mennyisége | 10 |
| General | Eltünés bezáráskor | Kikapcsolva |
| General | Eltünés fokusz választáskor | Kikapcsolva |
| General | Tisztítás eltünéskor | Bekapcsolva |
| Extensions | Kellendő kiegészítők | Applications, Chrome bookmarks, System, Terminal |

## Keyring kikapcsolása

```bash
$ pacman -S seahorse
```

Majd `Deafult keyring`-nél jobb katt és megkell változtatni a jelszót **üresre**

## Polybar beállítása

`$HOME/.config/` <- polybar mappa bemásolása az `src` mappából

## Git beállítása

`$HOME/` <- `.gitconfig` fájl bemásolása az `src` mappából

## Bashrc beállítása

`$HOME/` <- `.bashrc` fájl bemásolása az `src` mappából
