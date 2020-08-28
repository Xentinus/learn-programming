<center>

![Arch-Linux](./arch_linux_banner.png)

</center>

# Arch Linux ARM Setup

* [Arch Linux ARM Website](https://archlinuxarm.org/)
* [Arch Linux ARM Packages](https://archlinuxarm.org/packages)
* [Arch Linux ARM Forum](http://archlinuxarm.org/forum)

## List and create particions

```bash
$ lsblk
$ sudo cfdisk /dev/sdX
```

Then create 2 particions

* First one is 150M with C W95 FAT32 (LBA) type.
* The second one is Linux type with the rest size.

After setting this, you can write than quit from cfdisk.

```bash
$ mkdir boot
$ sudo mkfs.vfat /dev/sdX1
$ sudo mount /dev/sdX1 /home/xentinus/Desktop/boot/

$ mkdir root
$ sudo mkfs.ext4 /dev/sdX2
$ sudo mount /dev/sdX2 /home/xentinus/Desktop/root/
```

## Downloading the latest Arch Linux ARM

You must do the next steps as root!

Now download and copy everything to root folder.

```bash
$ wget http://os.archlinuxarm.org/os/ArchLinuxARM-rpi-4-latest.tar.gz
$ bsdtar -xpf ArchLinuxARM-rpi-4-latest.tar.gz -C /home/xentinus/Desktop/root/
$ sync
```

Move boot files to boot partition

```bash
$ mv root/boot/* /home/xentinus/Desktop/root/boot /home/xentinus/Desktop/boot/
```

After evertything is copied, you can unmount particions.

```bash
$ umount /dev/sdd1
$ umount /dev/sdd2
```

## Connecting to Raspberry Pi, first steps

After inserting the sd card to Raspberry sd slot, you can finally connect to it. First you must know what ip address your pi have. Check it in your router dhcp settings. After you get the informations you can open the terminal and connect to it with SSH.

```bash
$ ssh alarm@IP_ADRESS
```

The default user is `alarm` with `alarm` password, and the default `root` password is `root`.

After you sucessfully login you must initialize the pacman keyring and populate the Arch Linux ARM package signing keys as root.

```bash
$ su
$ pacman-key --init
$ pacman-key --populate archlinuxarm
```

### Add Personal user, set passwords then delete default user

```bash
$ useradd -mg users -G wheel,storage,power -s /bin/bash xentinus
$ passwd xentinus
$ passwd root
$ userdel -f -r alarm
```

### Set Hostname

```bash
$ echo Xentinus-Pi > /etc/hostname
```

## Download, update packages then start services

First you need to update the core packages as root

```bash
$ pacman -Syu
```

Then download core programming packages

```bash
$ pacman -S htop nodejs git npm speedtest-cli python sudo pkgstats pm2 docker docker-compose docker-machine nano networkmanager vsftpd zsh
```

Start services

```bash
$ systemctl enable NetworkManager
$ systemctl start NetworkManager
$ systemctl enable vsftpd.service
```

## Setup your Raspberry Pi

### Set SUDO

You can set SUDO with `EDITOR=nano visudo` command.

You only have to do to remove hash before `%wheel ALL=(ALL) NOPASSWD:ALL` line

### Localization

Edit `/etc/locale.gen/` file with nano, then remove hashs before `en_GB.UTF-8` and `hu_HU.UTF-8`

After you saved the file run `$ sudo locale-gen` command

If the process is finished you have to export LANG

```bash
$ echo LANG=en_GB.UTF-8 > /etc/locale.conf
$ export LANG=en_GB.UTF-8
```

### Set keyboard layout

Edit your keyboard settings in `/etc/vconsole.conf` file.

> It's a new file!

```bash
KEYMAP=hu
FONT=lat2-16
FONT_MAP=8859-2
```

### Set Local time

```bash
$ ln -s /usr/share/zoneinfo/Europe/Budapest /etc/localtime
```

### Set HOSTS file

You can edit your HOSTS file with `/etc/hosts` file

```bash
127.0.0.1 localhost.localdomain Xentinus-Pi
```

### Setup SFTP Server

Edit your FTP Server settings in `/etc/vsftpd.conf` file

```bash
write_enable=YES
local_enable=YES
idle_session_timeout=300
data_connection_timeout=300
ftpd_banner=Welcome to Xentinus-Pi FTP service.
```

Then you have to restart vsftpd service.

```bash
$ sudo systemctl restart vsftpd
```

### Setup zsh shell

```bash
chsh -s $(which zsh)
ZSH_THEME="miloshadzic"
ENABLE_CORRECTION="true"
HIST_STAMPS="dd/mm/yyy"
plugins=(git archlinux docker-compose docker-machine docker github gitignore node npm pip pylint python sudo)
```
