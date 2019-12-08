<center>

![Arch-Linux](./arch_linux_banner.png)

</center>

# UEFI Arch Linux Setup

* [Arch Linux Wikipedia](https://wiki.archlinux.org/)
* [Arch Linux **Core, Community, Extra** Packages](https://www.archlinux.org/packages/)
* [Arch Linux **AUR** Packages](https://aur.archlinux.org/packages/)

First, setup your keyboard

```shell
$ loadkeys hu
```

## Test internet connection

 ```bash
$ ifconfig
$ ping -c2 google.com
```

If you don't have DHCP server then

 ```bash
$ ifconfig eno16777736 192.168.1.52 netmask 255.255.255.0
$ route add default gw 192.168.1.1
$ echo “nameserver 8.8.8.8” >> /etc/resolv.conf
```

## Partitioning

With `fdisk -l` check your disks

```bash
$ cfdisk /dev/sda
```

Set your disk to **GPT** Type, then create these partitions

* `sda1` 512M EFI System
* `sda2` 4G Linux swap
* `sda3` 120G Linux filesystem

### Format EFI partition

```bash
$ mkfs.fat -F32 /dev/sda1
```

### Create SWAP and turn on

```bash
$ mkswap /dev/sda2
$ swapon /dev/sda2
```

### Format Linux Filesystem

```bash
$ mkfs.ext4 /dev/sda3
```

## Arch-Linux Install

*Mount your **root** partition!*

```bash
$ mount /dev/sda3 /mnt
$ pacstrap -i /mnt base base-devel linux linux-firmware nano sudo
$ genfstab -U -p /mnt >> /mnt/etc/fstab
$ arch-chroot /mnt /bin/bash
```

### Localization

Edit `/etc/locale.gen` file, then remove hashs before `en_GB.UTF-8` and `hu_HU.UTF-8`

After you saved the file run `# locale-gen` command

If the process is finished you have to export LANG

```bash
$ echo LANG=en_GB.UTF-8 > /etc/locale.conf
$ export LANG=en_GB.UTF-8
```

### Set Keyboard

Edit your keyboard settings in `/etc/vconsole.conf` file

> It's a new file!

```bash
KEYMAP=hu
FONT=lat2-16
FONT_MAP=8859-2
```

### Set Local Time

```bash
$ rm /etc/localtime
$ ln -s /usr/share/zoneinfo/Europe/Budapest /etc/localtime
$ hwclock -w --u
$ timedatectl set-local-rtc 1 --adjust-system-clock
```

### Set Computer Name

```bash
$ echo Xentinus-Development > /etc/hostname
```

### Set HOSTS File

You can edit your HOSTS file with `/etc/hosts` file

```bash
127.0.0.1 localhost.localdomain Xentinus-Development
```

#### Install Network Manager

```bash
$ pacman -S networkmanager
$ systemctl enable NetworkManager
```

### Set Root Password

You can set your Root password with `passwd` command

### Install Bootloader

```bash
$ pacman -S grub efibootmgr dosfstools os-prober mtools
$ mkdir /boot/EFI
$ mount /dev/sda1 /boot/EFI
$ grub-install --target=x86_64-efi  --bootloader-id=Arch-Linux --recheck
$ grub-mkconfig -o /boot/grub/grub.cfg
```

#### Hide Bootloader (Optional)

You have to edit `/etc/default/grub/` file

```bash
GRUB_TIMEOUT="0"

# Insert this two in the end of the file
GRUB_HIDDEN_TIMEOUT="0"
GRUB_FORCE_HIDDEN_MENU="true"
```

After you saved the file, you have to run `grub-mkconfig -o /boot/grub/grub.cfg` command

## Reboot system

After the system is successfully rebooted, you can login to **root** with your root password

### Add user

```bash
$ useradd -mg users -G wheel,storage,power -s /bin/bash xentinus
$ passwd xentinus
```

### Set SUDO

You can set SUDO with `EDITOR=nano visudo` command

You only have to do to remote hash before `%wheel ALL=(ALL) ALL` line

## Install required applications

### Access AUR

*After you installed yay, you have to delete the `yay` folder!*

```bash
$ sudo pacman -S git
$ git clone https://aur.archlinux.org/yay.git
$ cd yay
$ makepkg -si
```

### Install Graphic Card

```bash
$ sudo pacman -S xorg xorg-xinit xorg-server xorg-apps
$ sudo pacman -S nvidia nvidia-utils
```

### Install Display Manager

```bash
$ sudo pacman -S xfce4 xfce4-goodies
$ sudo echo "exec startxfce4" > ~/.xinitrc
```

### Install Login Manager

```bash
$ sudo pacman -S lightdm
$ yay lightdm-webkit-theme-litarvan-git
$ sudo systemctl enable lightdm
$ sudo localectl set-x11-keymap hu
```

#### Setup your Login Manager

You have to edit `/etc/lightdm/lightdm.conf` file

```bash
greeter-session=lightdm-webkit2-greeter
```

And the second file is `/etc/lightdm/lightdm-webkit2-greeter.conf`

```bash
webkit_theme      = litarvan
```

### Install Microcode

```bash
$ sudo pacman -S intel-ucode
$ sudo grub-mkconfig -o /boot/grub/grub.cfg
```

### Install Firewall

```bash
$ sudo pacman -S ufw
$ sudo ufw enable
$ sudo systemctl enable ufw.service
```

### Install Sound

```bash
$ sudo pacman -S alsa-utils pulseaudio pavucontrol
```

### Optitional applications

| Package name | What is this? |
| --- | --- |
| ntfs-3g |  Support NTFS partitions (optitional) |
| gvfs |  Need for delete instant files |
