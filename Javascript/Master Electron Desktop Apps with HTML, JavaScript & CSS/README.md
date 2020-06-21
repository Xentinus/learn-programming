# Electron App

## Egy vagy több window készítése

Több ablak esetén ugyan ugy a `createWindow()` functionbe kell irni e tulajdonságait

```js
let mainWindow


functiion createWindow() {
  mainWindow = new BrowserWindow({
    width: 600, height: 600,
    webPreferences: { nodeIntegration: true },
  })

  // Fájl megnyítása
  mainWindow.loadFile('index.html');

  // Oldal megnyítása
  mainWindow.loadURL('https://github.com/);
  
  // Chrome Dev Tool megnyítása
  mainWindow.webComponents.openDevTools();

  mainWindow.on('closed', () => {
    mainWindow = null;
  })
}
```

## Electron elindítása (window meglétekor)

```js
app.on('ready', () => {
  createWindow();
})

// Lépjen ki az alkalmazásból ha minden ablak zárva( darwin, ami nem macos)
app,on('window-all-closed', () => {
  if (process.platform !== 'darwin) app.quit()
})

app.on('activate', () => {
  if (mainWindow === null) createWindow()
})
```

## App.on eventek

Több megtalálható: https://www.electronjs.org/docs/api/app

```js
app.on('before-quit', e => {
  console.log("Preventing app from quiting");
  e.preventDefault(); // nem engedi kilépni a felhasználót
  storeUserData()
  app.quit()
  console.log('App is quiting');
})

app.on('browser-window-blur', e => {
  console.log('App unfocused');
})

app.on('browser-window-focus', e => {
  console.log('App focused');
})
```

## Default app helyek

```js
console.log(app.getPath('desktop'));
console.log(app.getPath('temp'));
console.log(app.getPath('userData'));
```

## WindowStateKeeper

Külön add-Ons ami megjegyzi a window pocizióját amikor kilépünk belölle.

### Deklarációhoz

```js
const windowStateKeeper = require('electron-window-state');
```

### CreateWindow functionbe

```js
let winState = windowStateKeeper({
    defaultWidth: 1000, defaultHeight: 800
  })

mainWindow = new BrowserWindow({
    width: winState.width, height: winState.height,
    x: winState.x, y: winState.y,
})

winState.manage(mainWindow);
```

## Ablak tulajdonságok

Több megtalálható: https://www.electronjs.org/docs/api/browser-window

> Amig betölt a fájl/oldal addig fehér ablak látszódik. Érdemes átszínezni vagy app.on eventel megváratni mig betölt és utána megjelenítetni.

```js
mainWindow = new BrowserWindow({
    width: 1000, height: 600,
    x: 200, y: 200,
    frame: false, // ablak keret stílus
    titleBarStyle: 'hidden',
    webPreferences: { nodeIntegration: true, session: customSession }, // ablak egyedi session használat stb
    show: false
  })

secondaryWindow = new BrowserWindow({
  width: 700, height: 400,
  webPreferences: { nodeIntegration: true },
  parent: mainWindow, // parent window
  modal: true, // beépíti a parent windowba (pl appon belüli értesítés)
  show: false // láthatóság
  })
```

### Popup példa

2 másodperc multán megjelenik a 2. window majd 1 másodperc után eltünik

```js
setTimeout(() => {
  secondaryWindow.show()
  setTimeout(() => {
    secondaryWindow.hide()
  }, 3000);
}, 2000);
```

## WebContents

Weboldalon belüli eventek. Például amikor valaki rányom egy linkre, valaki gombot nyom stb.

```js
const { app, BrowserWindow, webContents} = require('electron')

let wc = mainWindow.webContents;

wc.on('before-input-event', (e, input) => { 
  console.log('${input.key} : ${input.type}')
})

wc.on('new-window', (e, url) => {
  console.log('Creating new window for: ${url}')
})
```

## Sessions

2 típus van. Ami memóriába ment és a bprogram bezárása után nem található meg újra és ami a merevlemezre menti és a program újraindítása után is ott lesz.

### Merevlemezes verzió

```js
let ses = mainWindow.webContents.session; // chache stb (hard drive tárolás)
let defaultSes = session.defaultSession; // default session

console.log(`ses = defaultSes : ${Object.is(ses, defaultSes)}`); // true
```

### Memóriás verzió

```js
let customSes = session.fromPartition('part1');
```

Ha egy `presist:` -et eléteszünk a part1 elé akkor viszont az adatok tárolva maradnak a merevlemezen.

```js
let customSes2 = session.fromPartition('persist:part1');
```

## Cookie

### Sütik megtekintése

```js
const { app, BrowserWindow, session } = require('electron')

let ses = session.defaultSession;

let getCookies = () => {
  ses.cookies.get({}, (err, cookies) => {
    console.log(cookies);
  })
}
```

### Süti hozzáadása

Élettartam nélkül a süti csak addig él ameddig ki nem lépünk a programból.
>Az időt UNIX-ban kell megadni.

```js
let cookie = { url: 'https://myappdomain.com', name: 'cookie1', value: 'electron', expirationDate: 1613852855 };
  ses.cookies.set(cookie, err => {
    console.log('cookie 1 set');
    getCookies();
  })
```

### Összes süti törlése

```js
session.clearStorageData();
```

## Letöltés

Documentation: https://www.electronjs.org/docs/api/download-item

### HTML

```js
<h2><a href="http://ipv4.download.thinkbroadband.com/100MB.zip" download>Download Image</a></h2>
<progress value="0" max="100" id="process"></progress>

<script>
window.progress = document.getElementById('process');
</script>
```

```js
ses.on('will-download', (e, downloadItem, webContents) => {
  console.log('Starting download:');
  let fileName = downloadItem.getFilename();
  let fileSize = downloadItem.getTotalBytes();

  downloadItem.setSavePath(app.getPath('desktop') + `/${fileName}`);

  downloadItem.on('updated', (e, state) => {
    let received = downloadItem.getReceivedBytes();

    if (state === 'progressing' && received) {
      let process = Math.round((received / fileSize) * 100);
      webContents.executeJavaScript(`window.progress.value = ${process}`);
    }
  })
})
```
