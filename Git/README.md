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

## Mappa gittelés

Adott mappa gittelése (létrehozza a .git mappát amiben eltárol mindent)

```sh
$ git init
```

## Gitignore segítségével, fájlok vagy mappák szinkronízálásának tiltása

Van mikor bizonyos fájlokat nem szeretnénk elmenteni. Erre létrekell hozni egy .gitignore fájl és abba beleírni a fájl vagy mappa nevét

## Git állapota egy repo-ban

Fájl változások megjelenítése

```sh
$ git status
```

Elöző változtatások (soronként egy változtatás)

```sh
## --graph hozzáadásával láthatjuk az ágak helyzetét is
$ git log --oneline --graph
```

Változtatások vizuális megjelenítése

```sh
$ gitk
```

Git-ben történt változtatások megjelenítése

```sh
$ git reflog
```

## Git állapotának megváltoztatása

Változtatások hozzáadása (mindent vagy egy fájlt)

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

## Git visszatöltése egy régebbi állapotra

Teljes visszatöltés egy régebbi válzotatásra

```sh
$ git checkout a2a6c47
```

Egy fájl visszatöltése egy régebbi változtatás id-jéből

```sh
$ git checkout 87af770 index.html
```

Minden fájl visszaállítása az eredeti állapotba (ha visszalett töltve több fájl)

```sh
$ git checkout -- .
```

Változtatások megnézése 2 változás között

> Múltból haladunk a jelen felé ha fordítva akkor a jelenből haladunk a múltba

```sh
$ git diff HEAD~9 HEAD
```

HEAD áttétele máshová és az azóta történt változtatások megtartása és jováhagyása, ezért soft (hardnál minden elveszik)

```sh
$ git reset --soft HEAD~1
```

HEAD áttétele egy régebbi állapotra

> Ezzel törlödik az azóta végrehajtott változások, és ezeket nem lehet visszavonni!

```sh
$ git checkout -B master
```

## Ágak

Új ág készítése az aktuális állapotból

> Ezzel külön úton tudunk elkezdeni fejleszteni majd a végén összeilleszteni a fő ággal, ha időközben történt vele változás

```sh
$ git checkout -b korabbi-ag
```



### Ág visszavezetése a fő ágba

Ágak összeolvasztása

> Összeütközés esetén feldobja hogy melyiket kívánod megtartani

```sh
$ git merge
```

Ágak összefésülése egy ággá

> Az ágak visszamennek egy régebbi közös pontra majd minden egyes változtatásnál ha ütközés van akkor el kell dönteni melyiket kívjuk használni

```sh
$ git rebease korabbi-ag
```

## Git fájl műveletek

Fájlok vagy mappák törlése

```sh
$ git rm README.md
```

Fájlok vagy mappák mozgatása

> honnan hova (léteznie kell a hova mappának)

```sh
$ git mv styles/styles.css css/styles.css
```
