<center>

![Arch-Linux](./arch_linux_banner.png)

</center>

# Arch-Linux Settings

* [Arch Linux Wikipedia](https://wiki.archlinux.org/)
* [Arch Linux **Core, Community, Extra** Packages](https://www.archlinux.org/packages/)
* [Arch Linux **AUR** Packages](https://aur.archlinux.org/packages/)

## XFCE Settings

### Appearance

| Page | What are you looking for | Value |
| --- | --- | --- |
| Style | Select Style | Arc-Darker |
| Icons | Select Icon Style | Papirus-Dark |
| Fonts | Default Font | Source Sans Pro 10 |
| Fonts | Default Monospace Font | Source Code Pro 10 |
| Fonts | Custom DPI settings | True and 96 DPI |
| Settings | Enable event sound | True |

### Dekstop

| Page | What are you looking for | Value |
| --- | --- | --- |
| Background | Select Background | Select background from backgrounds folder |
| Menus | Show window list menu on desktop middle click | False |
| Icons | Show icon tooltips size | 32 |
| Icons | Default Icons: Wastebasket  | False |

### File Manager Preferences

| Page | What are you looking for | Value |
| --- | --- | --- |
| Display | View new folders using | Detailed List View |
| Behaviour | Show action to permanently delete files and folders | True |

### Notifications

| Page | What are you looking for | Value |
| --- | --- | --- |
| General | Show notifications on | Primary Display |
| General | Disappear after | 3 seconds |

### Window Manager

| Page | What are you looking for | Value |
| --- | --- | --- |
| Style | Select Theme | Arc-Darker |
| Style | Title Font | Source Sans Pro Bold 11 |
| Style | Button Layout: Shade | Hidden |

### Windows Manager Tweaks

| Page | What are you looking for | Value |
| --- | --- | --- |
| Accessibility | Use mouse wheel on title bar to roll up the window | False |
| Workspaces | Everythings if false |
| Placesment | Minimum size of windows to triggers smart placement | Large |

### Workspaces

| Page | What are you looking for | Value |
| --- | --- | --- |
| General | Number of workspaces | 1 |

### XFCE Terminal

Copy `onedark.theme` file form `src` folder to `/usr/share/xfce4/terminal/colorschemes/`

| Page | What are you looking for | Value |
| --- | --- | --- |
| General | Dynamically-set title | Isn't displayed |
| General | Scrollbar is | Disabled |
| General | Unlimited scrollback | True |
| General | Cursor shape | Block |
| General | Cursor blinks | True |
| Appearance | Use system font | True |
| Appearance | Background | Transparent Background |
| Appearance | Opacity | 0.95 |
| Appearance | Default geometry columns | 120 |
| Appearance | Default geometry rows | 30 |
| Colours | Presets | One Dark |
| Advanced | Use middle mouse click to close tabs | False |

### Mouse and Touchpad

| Page | What are you looking for | Value |
| --- | --- | --- |
| Theme | Select Mouse Theme | Bibata Ice |

### Removable Drives and Media

| Page | What are you looking for | Value |
| --- | --- | --- |
| Storage | Mount removable drives when hot-plugged | True |
| Storage | Mount removable media when inserted | True |
| Storage | Browse removable media when inserted | True |

## Albert Settings

*You also have to add `albert` to Session and Startup Settings to run automaticaly on login!*

| Page | What are you looking for | Value |
| --- | --- | --- |
| General | Hotkey | Menu |
| General | Terminal | XFCE-Terminal |
| General | Show tray icon  | False |
| General | Incremental sort | True |
| General | Theme | Arc Dark Blue |
| General | Amount of results | 10 |
| General | Hide on close | False |
| General | Hide on focus out | False |
| General | Clear on hide | True |
| Extensions | Turn on these extensions | Applications, Chrome bookmarks, System, Terminal |

## Docker Setup

Add xentinus user to docker group with `usermod -aG docker xentinus`

## Start services

```bash
$ sudo systemctl enable mongodb.service
$ sudo systemctl enable docker.service
```

## Visual Studio Setup

Search for `Syncing` and download it!

Then press `F1` and type `download` and select `Syncing: Download Settings`

Insert this gist code: **f0e0909f0b91c516c9bc38386c9412382808c14d**

## Polybar Setup

Copy `/home/xentinus/.config/polybar/` files, then run `chmod +x $HOME/.config/polybar/launch.sh`

After the process is complete you have to go to the Session and Startup Settings Application Autostart Tab and add this [launch.sh](./src/home/xentinus/.config/polybar/launch.sh) as Polybar
