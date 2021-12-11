# Git

## Aláírás

Git felhasználói adatok megjelenítésének parancsa

```sh
$ git config --global --list
```

Az aláíró nevének és email címének beállítása

```sh
$ git config --global user.name "Béla Kellner"
$ git config --global user.email bela.kellner@icloud.com
```

## Fő parancsok

Adott mappa gittelése (létrehozza a .git mappát amiben eltárol mindent)

```sh
$ git init
```

Fájl változások megjelenítése

```sh
$ git status
```

Változtatások hozzáadása

> Ez lehet minden vagy egyszerre egy fájl is

```sh
# Minden fájl hozzáadása
$ git add .

# Csak egy bizonyos fájl hozzáadása
$ git add index.html
```

A hozzáadott változtatás leírása

```sh
$ git commit -m "Megjegyzés, röviden mi történt ebben a változtatásban"
```
