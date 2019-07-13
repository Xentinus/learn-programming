# Kotlin tanulás

## Parancssor kiiírása

### Sima parancssor kiírás

```kt
println("Hello World")
```

### Értékes parancssor kiírás

```kt
println("Tim's $ weekly salary is $$timsWeeklySalary")
println("Monthly, that comes to $timsMonthlySalary")

println("$apples apples - $oranges oranges leaves $fruit piece(s) of fruit")

println("A quarter of the apples is ${apples / 4}")
```

## Deklarálás

### Változhat a késöbbiekben a deklarált érték

> **var** is like **general variable** and it's known as a mutable variable in kotlin and can be assigned multiple times.

```kt
var jim: String
jim = "James T Kirk"
```

### Nem változik késöbbiekben a deklarált érték

> **val** is like **Final variable** and it's known as immutable in kotlin and can be initialized only single time.

```kt
val apples: Int = 6
val oranges = 5
val fruit = apples - oranges
```

## Bekérés a parancssoron

```kt
println("How old are you: ")
val age = readLine()!!.toInt()
println("age is $age")
```

## Kérdéses

### Alap kérdés

```kt
val message: String
if (age < 18) {
  message = "You're too young to vote"
} else if ( age == 100 ) {
  message = "Congratulations"
} else {
  message = "You can vote"
}
```

### Alap kérdés rövidítve

```kt
val message: String
message = if (age < 18) {
  "You're too young to vote"
} else if (age == 100) {
  "Congratulations"
} else {
  "You can vote"
}
```

### Kérdések When-el

```kt
val message: String
message = when {
    age < 18 -> "You're too young to vote"
    age == 100 -> "Congratulations"
    else -> "You can vote"
}
```

## Osztályok

### Osztály file kinézete

```kt
class Name(constructor1 (amiket meg lehet adni)) {
  constructor2
  var asd fixek

  fun show {
    random function
  }
}
```

### Osztály példa

```kt
class Player(val name: String, var level: Int = 1, var lives: Int = 3, var score: Int = 0) {
    var weapon: Weapon = Weapon("Fist", 1) // másik class használata

    fun show() {
        println("""
            name: $name
            lives: $lives
            level: $level
            score: $score
            """)
```

### Osztályok használata

```kt
val louise = Player("Louise", 5)
louise.show()

val gr8 = Player("gr8", 4, 8)
val one2watch = Player("Ace",2, 5, 1000)
gr8.show()
one2watch.show()
```

```kt
val axe = Weapon("Axe", 12)
gr8.weapon = axe
println(gr8.weapon.name)
println(axe.name)

axe.damageInflicted = 24
println(axe.damageInflicted)
println(gr8.weapon.damageInflicted)

tim.weapon = Weapon("Sword", 10)
println(tim.weapon.name)
```

### Osztály alap function (toString) felülírása

> Alapból ha println-ezel egy akkor a Classname@Hascode -t fog kiírni

```kt
override fun toString(): String {
    return """
        name: $name
        lives: $lives
        level: $level
        score: $score
        weapon: ${weapon.name}
        damage: ${weapon.damageInflicted}
        """
}
```

### Osztály család

> superclass

```kt
open class Enemy(val name: String, var hitPoints: Int, var lives: Int) {
  open fun takeDamage(damage: Int) {
    ...
  }
}
```

> Subclass

```kt
class Troll(name: String, hitPoints: Int, lives: Int) : Enemy(name, hitPoints, lives) {
  override fun takeDamage(damage: Int) {
    super.takeDamage(damage / 2)
  }
}
```

> Ha vannak alapok

```kt
class Troll(name: String, hitPoints: Int = 20) : Enemy(name, hitPoints, 1) {

}
```

> init - obj elkészítésekor egyből elkészül ez is

```kt
class VampyreKing(name: String) : Vampyre(name) {
  init {
    hitPoints = 140
  }
}

## Listák

```kt
enum class LootType { // Loot típus
    POTION, RING, ARMOR
}

class Loot(val name: String, val type: LootType, val value: Double) {
  // minden lootnak van neve TÍPUSA és értéke
}
```

### Listák használata

#### Egy darab hozzáadása és megjelenítése

```kt
// Player Class
val inventory = ArrayList<Loot>()

fun showInventory() {
    println("$name's Inventory")
    println(inventory.get(0)) // csak az elsőt fogja megjeleníteni
    println("================================")
}

// Main
val redPotion = Loot("Red Potion", LootType.POTION, 7.50)
tim.inventory.add(redPotion)
tim.showInventory()
```

### Listából kivétel

```kt
fun dropLoot(item: Loot): Boolean {
  return if (inventory.contains(item)) { // ha az itemet tartalmazza
    inventory.remove(item) // kiveszi az adott elemet
    true
  } else {
    false
  }
}

 // overloading function - megnézi melyi a megfelelő a bevittek alapján
fun dropLoot(name: String): Boolean {
  println("$name will be dropped")
  return inventory.removeIf { it.name == name }
}
```

#### Több darab hozzáadása

```kt
// Player Class
val inventory = ArrayList<Loot>()

fun showInventory() {
    println("$name's Inventory")
    for (item in inventory) { //forEach
      println(item)
    }
    println("================================")
}
```

## for Loops

### for ( item in inventory ) - forEach

> Amennyi item van az inventoryban annyit ír ki

```kt
for (item in inventory) {
  println(item)
}
```

### for ( i in MENNYITŐL..MEDDIG ) - NÖVEKVŐ

> 0-10ig kiirja

```kt
for (i in 0..10) {
  println(i)
}
```

### for ( i in MENNYITŐL until MENNYIT )

> 0-tól indul és 10 darabot csinál

```kt
for (i in 0 until 10) {
  println(i)
}
```

### for ( i in MENNYITŐL downTo MEDDIG ) - CSÖKKENŐ

> 10-től visszaszámol 0-ig

```kt
for (i in 10 downTo 0) {
  println(i)
}
```

### for ( i in MENNYITŐL downTo MEDDIG step MENNYIKÉNT )

> Minden mennyit csinál csak meg pl ha 2 akkor csak minden másodikat

```kt
for (i in 10 downTo 0 step 2) { // lehet minusz is
  println(i)
}
```

## while Loops

```kt
while(dracula.lives > 0) {
  if (dracula.dodges()) {
    continue // csak akkor halad tovább ha igaz, különben breakel
  }

  if (dracula.runAway()) {
    println("Dracula ran away")
    break
  } else {
    dracula.takeDamage(12)
  }
}
```

## do while Loops

```kt
do {
  if (dracula.dodges()) {
    continue // csak akkor halad tovább ha igaz, különben breakel
  }

  if (dracula.runAway()) {
    println("Dracula ran away")
    break
  } else {
    dracula.takeDamage(12)
  }
} while(dracula.lives > 0)
```

## Random

```kt
import java.util.*

fun dodges(): Boolean {
  val rand = Random()
  val chance = rand.nextInt(6)

  if(chance > 3) {
    println("Dracula dodges")
    return true
  }
  return false
}
```

## Private vagy Public

> Alapból minden public

### Típusok

* public
* private
* protected
* internal

### Ha például valami private

Létrekell hozni egy function-t amihez hozzáadható

```kt
fun getLoot( item: Loot) {
  inventory.add(item)
}
```
