# Bash Script

## Kötelező lépések

Cheatsheet

[DevHints.IO](https://devhints.io/bash)

Script fájlok eleje

```bash
#!/bin/bash
```

Futtathatóvá tétel

```bash
chmod u+x fájlneve
```

Strict mode

```bash
set -euo pipefail
IFS=$'\n\t'
```

## Kommentek

```bash
# Egysoros komment

: '
Ez
egy
többsoros
komment
'
```

## Megjelenítés

```bash
echo Hello, World!
```

## Változók

Az `=` körül nem lehet szóköz! Akkor hibát fog feldobni!

```bash
WHO="World"
echo Hello, $WHO!
echo "Hello, $WHO!"
echo "Hello, ${WHO}!"
```

Paraméterek

```bash
name="John"
echo ${name}
echo ${name/J/j}    #=> "john"
echo ${name:0:2}    #=> "Jo"
echo ${name::2}     #=> "Jo"
echo ${name::-1}    #=> "Joh"
echo ${name:(-1)}   #=> "n"
echo ${name:(-2):1} #=> "h"
echo ${food:-Cake}  #=> $food vagy "Cake"

length=2
echo ${name:0:length}  #=> "Jo"

echo ${#name}       #=> name hossza
```

## Idézőjelek

```bash
NAME="John"
echo "Hi $NAME"  #=> Hi John
echo 'Hi $NAME'  #=> Hi $NAME
```

## Bekérés

```bash
echo Who are you?

read who

echo Hello, $who!
```

## Operátorok

| Operátor | Bash Operátor | Leírás |
| --- | --- | --- |
| == | -eq | Egyenlő |
| != | -ne | Nem egyenlő |
| > | -gt | Nagyobb mint |
| >= | -ge | Nagyobb mint vagy egyenlő |
| < | -lt | Kevesebb mint |
| <= | -le | Kevesebb mint vagy egyenlő |
| == null | -z | Azz értéke null |

## Eldöntendő

```bash
echo How old are you?

read age

if [ "$age" -gt 18 ]; then
    echo Ihatsz.
elif [ "$age" -eq 18 ]; then
    echo Mostmár ihatsz.
else
    echo Túl fiatal vagy az iváshoz.
fi
```

## Tömbök

```bash
Fruits=('Apple' 'Banana' 'Orange')
Fruits[0]="Apple"
Fruits[1]="Banana"
Fruits[2]="Orange"
```

Paraméretek

```bash
echo ${Fruits[0]}           # 0. érték
echo ${Fruits[@]}           # @ érték, szóközzel elválasztva
echo ${#Fruits}             # A stringnek csak az első betűje
echo ${#Fruits[@]}          # A stringnek az első @ betűje
echo ${Fruits[@]:3:2}       # A 3.-tól 2-őt
```

## Cíklusok

Alap for loop

```bash
for i in {1..5}; do
    echo "Welcome $i"
done
```

Lépések mennyiségének növelése

```bash
for i in {5..50..5}; do
    echo "Welcome $i"
done
```

Line olvasó loop

```bash
< file.txt | while read line; do
  echo $line
done
```

## Parancsok használata

Úgy lehet öket használni mint ha parancssorba írnánk

```bash
read -r -p 'Commit message: ' desc
git add .
git add -u
git commit -m "$desc"
git push origin master
```

Ha cillusban kellene használni akkor `${}` köré kell tenni

```bash
if type "xrandr"; then
  for m in $(xrandr --query | grep " connected" | cut -d" " -f1); do
    MONITOR=$m polybar --reload example &
  done
else
  polybar --reload example &
fi
```

## Metódusok

```bash
get_name() {
  echo "John"
}

# Úgyan az mint a felső
function get_name() {
    echo "John"
}

echo "You are $(get_name)"
```

Értékek olvasása

```bash
myfunc() {
    local myresult='some value'
    echo $myresult
}
result="$(myfunc)"
```
