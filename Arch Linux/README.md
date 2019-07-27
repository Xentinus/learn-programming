# Arch Linux telepítése

Fontosabb linkek:

* [Arch Linux Wikipédia](https://wiki.archlinux.org/)
* [Arch Linux **Alap** Csomagok](https://www.archlinux.org/packages/)
* [Arch Linux **AUR** Csomagok](https://aur.archlinux.org/packages/)

Telepítés során alkalmazott billentyűzet beállítása

```shell
$ loadkeys hu
```

## Particiók létrehozása

```bash
$ cfdisk /dev/sda
```

`swap` = **RAM** mennyisége * 1,5

**MBR** esetén

* `sda1` 160G linux, root, bootable
* `sda2` 12G linux-swap

**GPT** esetén

* `sda1` 1G boot
* `sda2` 40G linux, root (legalább 20G)
* `sda3` 120G home
* `sda4` 12G linux-swap

### Fájlrendszeradás a rootnak

```bash
$ mkfs.ext4 /dev/sda1
```

### Swap létrehozása és bekapcsolása

```bash
$ mkswap /dev/sda2
$ swapon /dev/sd2
```

## Telepítés

*Mount ahova telepítesz!*

```bash
$ mount /dev/sda1 /mnt
$ pacstrap -i /mnt base base-devel
$ genfstab -U /mnt >> /mnt/etc/fstab
$ arch-chroot /mnt /bin/bash
```

### Localizáció

Kikell venni a `#`-et az `en_GB.UTF-8` és `hu_HU.UTF-8` elöl

```bash
$ nano /etc/locale.gen
```

Megkell várni míg localizál

```bash
$ locale-gen
```

Majd beállítani a default-ot

```bash
$ echo LANG=en_GB.UTF-8 > /etc/locale.conf
$ export LANG=en_GB.UTF8
```

### Billentyűzet beállítása

```bash
$ nano /etc/vconsole.conf
```

Bele kell írni a magyar billentyűzet beállításait

```bash
KEYMAP=hu
FONT=lat2-16
FONT_MAP=8859-2
```

### Idő beállítása

```bash
$ rm /etc/localtime
$ ln -s /usr/share/zoneinfo/Europe/Budapest /etc/localtime
$ hwclock --systohc
$ timedatectl set-local-rtc 1 --adjust-system-clock
```

### Számítógépnév beállítása

```bash
$ echo Xentinus-Development > /etc/hostname
```

### Internet beállítása

```bash
$ nano /etc/hosts
```

Majd ezt kell beleírni

```bash
127.0.0.1 localhost.localdomain localhost Xentinus-Development
::1       localhost.localdomain localhost Xentinus-Development
```

#### NetworkManager telepítése

```bash
$ pacman -S networkmanager
$ systemctl enable NetworkManager
```

## Rendszer indítása

```bash
$ mkinitcpio -p linux
```

### Root jelszó beállítása

```bash
$ passwd
```

### Bootloader beállítása

*Ezután újraindul és kérni fogja a root-ot és annak jelszavát*

```bash
$ pacman -S grub os-prober
$ grub-install --target=i386-pc --recheck /dev/sda
$ grub-mkconfig -o /boot/grub/grub.cfg
$ unmount /dev/sda1
$ reboot
```

### Felhasználó hozzáadása és jelszóadás

```bash
$ useradd -m -g users -G wheel,storage,power -s /bin/bash xentinus
$ passwd xentinus
```

### Sudo bekapcsolása

Megkell keresni a `%wheel ALL=(ALL) ALL`-t és kivenni elöle a `#`-et

```bash
$ EDITOR=nano visudo
```

*Ezután újraindul és kérni fogja a root-ot és annak jelszavát*

```bash
$ pacman -S bash-completion
$ reboot
```

## Alkalmazások és egyebek telepítése

### Videokártya telepítése

```bash
$ pacman -S xorg-server xorg-apps xorg-xinit
$ pacman -S nvidia nvidia-utils
```

### Display Manager telepítése

```bash
$ pacman -S xfce4 xfce4-goodies
```

### Login Manager telepítése

```bash
$ pacman -S lightdm lightdm-webkit-theme-litarvan
$ systemctl enable lightdm
$ localectl set-x11-keymap hu
```

`nano /etc/lightdm/lightdm.conf` -al megkeresni és átírni:

```bash
greeter-session=lightdm-webkit2-greeter
```

`nano /etc/lightdm/lightdm-webkit2-greeter.conf` -al megkeresni és átírni

```bash
webkit-theme=litarvan
```

Késöbb érdemes letölteni a legfrissebb verziót [innen](https://github.com/Litarvan/lightdm-webkit-theme-litarvan).

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

### AUR programok eléréséhez

*Késöbb törölni kell a `yay` mappát a `HOME`-ból*

```bash
$ pacman -S git
$ git clone https://aur.archlinux.org/yay.git
$ cd yay
$ makepkg -si
```

### Mongo adatbázis beállítása

```bash
$ systemctl enable mongodb.service
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

### Grub beállítása

`nano /etc/default/grub/` parancs után át kell írni ezeket

```bash
GRUB_TIMEOUT="0"
GRUB_HIDDEN_TIMEOUT="0"
GRUB_FORCE_HIDDEN_MENU="true"
```

Mentés, majd `$ grub-mkconfig -o /boot/grub/grub.cfg` futtatása

### Telepítésre váró programok

Érdemes az elején letölteni `yay`-el a `pamac-aur`-t és azzal egyszerre telepíteni mindent (elötte beállítani hogy egyszerre csak 1-et töltsön le)

#### Alkalmazások

| Csomag neve | Csomag típusa |
| --- | --- |
| chromium | Alap |
| pkgstats | Alap |
| vlc | Alap |
| teamspeak3 | Alap |
| qbittorrent | Alap |
| p7zip | Alap |
| unrar | Alap |
| unzip | Alap |
| xarchiver | Alap |
| discord | **AUR** |
| pamac-aur | **AUR** |
| spotify | **AUR** |
| p7zip-gui | **AUR** |

#### Developper alkalmazások

| Csomag neve | Csomag típusa |
| --- | --- |
| intellij-idea-community-edition | Alap |
| nodejs | Alap |
| npm | Alap |
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

#### UI-hoz szükséges alkalmazások

| Csomag neve | Csomag típusa |
| --- | --- |
| albert | Alap |
| arc-gtk-theme | Alap |
| papirus-icon-theme | Alap |
| powerline | Alap |
| adobe-source-code-pro-fonts | Alap |
| adobe-source-sans-pro-fonts | Alap |
| ttf-ubuntu-font-family | Alap |
| bibata-cursor-theme | **AUR** |
| nerd-fonts-complete | **AUR** |
| polybar | **AUR** |

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
