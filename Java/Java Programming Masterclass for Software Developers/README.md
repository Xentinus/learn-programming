# Java

[http://java.progtanulo.hu/java-programozas](http://java.progtanulo.hu/java-programozas)

## Változók

### Egész számok

#### Integer

* -2,147,483,643 -> 2,147,483,647 **( 2 147 millió )**
* Mérete: **4 byte** ( 32 szélesség )

```java
int myFirstNumer = 5;
int mySecondNumber = (10 + 5) + (2 * myFirstNumber);
int myLastOne = 1000 - mySecondNumber;
int myMinValue = -2_147_483_643; // more readable (java 8)
```

#### Byte

* -128 -> 127 **( 128 )**
* Mérete: **1 byte** ( 8 szélesség )

```java
byte myByteValue = -128;
byte myNewByteValue = (byte) (myByteValue / 2);
```

#### Short

* -32,768 -> 32,767 **( 32 ezer )**
* Mérete: **2 byte** ( 16 szélesség )

```java
short myShortValue = 32767;
short myNewShortValue = (short) (myShortValue / 2);
short shortTotal = (short) (1000 + 10 * (byteValue + shortValue + intValue));
```

#### Long

* -9,223,372,036,854,775,808**L** -> -9,223,372,036,854,775,807**L**
* Mérete: **8 byte** ( 64 szélesség )

```java
long myLongValue = 100L;
long longTotal = 50_000L + 10L * (byteValue + shortValue + intValue);
```

### Tizedes számok

#### Float

* 7 tizedes érték
* Mérete: **4 byte** ( 32 szélesség )

```java
float myFloatValue = (float) 5.4;
float myFloatValue = 5.4f; // tísztább

// myFloatValue = 1.6666666
float myFloatValue = 5f / 3f;
```

#### Double

* 16 tizedes érték
* Mérete: **8 byte** ( 64 szélesség )
* *érdemes ezt használni mert gyorsabb ( több dolog ink ezt használja )*

```java
double myDoubleValue = (double) 5.4;
double myDoubleValue = 5.4d; // tísztább

// myDoubleValue = 1.6666666666666667
double myDoubleValue = 5d / 3d;
```

### Betűs

#### Char

* egy szám, betű vagy speciális karakter
* Mérete: **2 byte** ( 16 szélesség )
* használható [unicode](https://unicode-table.com/en/) is ha van az elején `\u`

```java
char myChar = 'D';

// Unicode ©
char myUnicodeCharacter = '\u00A9';
```

#### String

* több szám, betű vagy speciális karakter
* String egy **class** minden más változó primitív
* Mérete függ a tartalmától
* használható [unicode](https://unicode-table.com/en/) is ha van az elején `\u`

```java
String myString = "This is a string";
System.out.println(myString);

myString = myString + ", and this is more.";
System.out.println(myString);

String lastString = "10";
int myInt = 50;
lastString = lastString + myInt;

// 1050
System.out.println(lastString);
```

### Eldöntendő

#### Boolean

* csak igaz vagy hamis lehet
* Mérete: **1 bit** ( 1 szélesség )

```java
boolean myBoolean = false;
```

## Operátorok

### =, ==, != operátorok

* = értékadás

```java
int result = 10; // 10
```

* == egyenlő e a tartalma?

```java
int topScore = 100;
if (topScore == 100) // true
```

* != különböző e a tartalma?

```java
int topScore = 100;
if (topScore != 100) // false
```

### +, ++, += operátorok

* hozzáadás

```java
int result = 10 + 2; // 12
```

* hozzáadás rövidítése

```java
int result = 10;
result += 2; // 12
```

* 1 érték hozzáadása

```java
int result = 10;
resuilt++; // 11
```

### -, --, -= operátorok

* kivonás

```java
int result = 10 - 1; // 9
```

* kivonás rövidítése

```java
int result = 10;
result -= 2; // 8
```

* 1 érték kivonása

```java
int result = 10;
resuilt--; // 9
```

### *, *= operátorok

* szorzás

```java
int result = 10 * 10; // 100
```

* szorzás rövidítése

```java
int result = 10;
result *= 2; // 20
```

### /, /= operátorok

* osztás

```java
int result = 10 / 2; // 5
```

* osztás rövidítése

```java
int result = 10;
result /= 2; // 5
```

### %, %= operátorok

* maradék

```java
int result = 10 % 3; // 1
```

* maradék rövidítve

```java
int result = 10;
result %= 3; // 1
```

### >, >=, <, <= operátorok

* kevesebb

```java
int topScore = 100;
if (topScore < 100) // false
```

* kevesebb vagy egyenlő

```java
int topScore = 100;
if (topScore <= 100) // true
```

* több

```java
int topScore = 100;
if (topScore > 100) // false
```

* több vagy egyenlő

```java
int topScore = 100;
if (topScore >= 100) // true
```

### ||, && operátorok

* && és ( **mindkettőnek** IGAZNAK KELL lennie )

```java
int topScore = 100;
if ((topScore > 50) && (topScore < 120)) // true && true = true
```

* || vagy ( **valamelyiknek** IGAZNAK KELL lennie )

```java
int topScore = 100;
if ((topScore >= 0) || (topScore < 100)) // true || false = true
```

### ?: operátor

Lényegében egysoros if

```java
boolean isCar = false;


boolean wasCar = isCar ? true : false; // false

if (isCar) {
  return true;
} else {
  return false;
}
```

## Kifejezések, utasítások, blokkok

### Expression (kifejezés)

```java
int myVariable = 50;
// Ebből expression csak ez:
myVariable = 50


System.out.println("Ez egy szöveg");
// Ebből expression csak ez:
"Ez egy szöveg"
```

### Statement (utasítás)

Amit végre kell hajtania a gépnek.

Semicolon `;` **zárja be** a statementeket ( vannak kivételek )

```java
// Az egész sor egy statement
int myVariable = 50;

//Több Statement egy sorban
int anotherVariable = 50;myVariable--;System.out.println("This is another one");

1.) int anotherVariable = 50;
2.) myVariable--;
3.) System.out.println("This is another one");
```

### Whitespace

Szóközök, tabok kulcsszavak és kifejezések között. Mindegy mennyi whitespacet teszel közéje, Java átalakítja magának.

```java
int         sokWhiteScapees    =    20;

// átalakítva
int sokWhiteScapees=20;
```

### Code Block (blokkok)

`{` és `}` között lévő tartalom

```java
if (score == 5000) {
  System.out.println("Your score was 5k");
} else if (score > 5000) {
  System.out.println("Your score was greate than 5k");
} else {
  System.out.println("Got here");
}
```

Code Blockon belül deklarált változók nem használhatók azon kivül, csak azon belül

```java
int nulla = 0;

if (true) {
  int egy = 1;
  // <- Elérhető: nulla, egy

  if (true) {
    int ketto = 2;
    // <- Elérhető: nulla, egy, ketto
  }

  int harom = 3;
  // <- Elérhető: nulla, egy, harom
}

int negy = 4;
// <- Elérhető: nulla, negy
```

### Metódusok

`void` nem küld vissza semilyen értéket, ha visszaakarunk küldeni valamit akkor átkell írni a dataType-ot és returnölni a metódus végén

```java
public static void main(String[] args) {
  int playerPosition = calculateHighScorePosition(1500);
  displayHighScorePosition("Player One", playerPosition);
}

private static void displayHighScorePosition(String playerName, int position) {
  System.out.println(playerName + " managed to get into position " + position + " on the high score table");
}

private static int calculateHighScorePosition(int playerScore) {
  int position = 4;

  if(playerScore >= 1000) {
    position = 1;
  } else if (playerScore >= 500) {
    position = 2;
  } else if (playerScore >= 100) {
    position = 3;
  }

  return position;
}
```

#### Method Overloading

A **paraméterek** miatt különbözöek, de például void-ként már az írja hogy a metódus neve már használatban van.

```java
public static void main(String[] args) {
  System.out.println(getDurationString(61, 0));
  System.out.println(getDurationString(1234));
}

 public static String getDurationString(int minutes, int seconds) {
  if ((minutes < 0) || ((seconds < 0) || seconds > 59)) {
    return "Invalid value";
  }

  int hours = minutes / 60;
  minutes %= 60;

  return hours + "h " + minutes + "m " + seconds + "s";
}

public static String getDurationString(int seconds) {
  if (seconds < 0) {
    return "Invalid value";
  }

  int minutes = seconds / 60;
  seconds %= 60;

  return getDurationString(minutes, seconds);
}
```

### Const

Végig nagy betűvel, hogy különbözzön egy sima változótól.

```java
private static final String INVALID_VALUE_MESSAGE = "Invalid value";
```

Vannak beépítettek is

```java
int inputMax = Integer.MIN_VALUE;
int inputMin = Integer.MAX_VALUE;
```

## Vezérlési szerkezetek

### Switch case

Használható változó típusok: byte, short, char és int

```java
int value = 1;

switch (value) {
  case 1:
      System.out.println("Value was 1");
      break;
  case 2:
      System.out.println("Value was 2");
      break;
  case 3: case 4: case 5:
      System.out.println("Was a 3, or a 4, or a 5");
      break;
  default:
      System.out.println("Was not 1 or 2");
      // break;
}
```

### For

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Loop " + i + " hello!");
}
```

### While

```java
int whileCount = 0;
while ( whileCount != 5 ) {
    System.out.println( "Count value is " + whileCount );
    whileCount++;
}
```

### Do While

```java
whileCount = 1;
do {
    System.out.println( "Count value was " + whileCount );
    whileCount++;
} while ( whileCount != 6 );
```

## Stringből számérték

Ha a stringben számon kívül más is található, akkor errot fog kiadni.

```java
String numberAsString = "2018";
System.out.println( "numberAsString = " + numberAsString );

int parseNumber = Integer.parseInt( numberAsString );
System.out.println( "number = " + parseNumber );

numberAsString = "2018.125";

double doubleNumber = Double.parseDouble( numberAsString );
System.out.println( "doublenumber = " + doubleNumber );
```

## Bekérés konzolról

Minden Int (és hasonló számos után) kell egy `nextLine()` amivel eltudjuk intézni az enter problémákat.

```java
// Fájl teteje:
import java.util.Scanner;

// Main:
Scanner scanner = new Scanner( System.in );

int inputMax = Integer.MIN_VALUE;
int inputMin = Integer.MAX_VALUE;

while ( true ) {
    System.out.println( "Enter number:" );
    boolean userInputInt = scanner.hasNextInt();
    if ( userInputInt ) {
        int userInt = scanner.nextInt();
        inputMax = userInt > inputMax ? userInt : inputMax;
        inputMin = userInt < inputMin ? userInt : inputMin;
    } else {
        System.out.println( "Min: " + inputMin );
        System.out.println( "Max: " + inputMax );
        break;
    }

    scanner.nextLine();
}

scanner.close();
```

## Object órientált programozás

### Osztályok, Construktorok

* Main

```java
Account peterAcccount = new Account(  );
Account bobsAccount = new Account("12345", 0.00, "Bob Brown", "myemail@bob.com", " 1234567");
System.out.println(bobsAccount.getCustomerName());
```

* Account osztály

```java

public class Account {
    private String number;
    private double balance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

// Construktorok üres(default értékek adása) és teli
    public Account() {
        this("56789", 2.50, "Default name", "Default adress", "Default phone");
        System.out.println("Empty constructor called");
    }

    public Account( String number, double balance, String customerName, String customerEmailAddress, String customerPhoneNumber ) {
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
        System.out.println("Account constructor with parameters");
    }

// account.method() készítése
    public void deposit ( double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made. New balance is " + this.balance);
    }

    public void withdrawal (double withdrawalAmount) {
        if ((this.balance - withdrawalAmount) >= 0) {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed. Remaining balance = " + this.balance);
        } else {
            System.out.println("Only " + this.balance + " available. Withdrawal not processed");
        }
    }

// érték lekérés
    public String getNumber () {
        return number;
    }

// privátnak értékadás
    public void setBalance ( double balance ) {
        this.balance = balance;
    }
}
```

### Több rétegű osztályok

* Main

```java
Animal animal = new Animal( 1,1,5,5,"Animal" );
Dog dog = new Dog(8,20, "Yorkie", 2, 4, 1, 20, "Brown");
dog.eat(); // alsó class használja a felső class metódusát
```

* Animal - felsöbb class / **super class**

Az állatok egy full globális csoport, beletartoznak madarak, pókok, kutyák. Globális csoportba csak azok kerülnek amik **MINDEGYIKNEK vannak**

```java
public class Animal {
    private int brain;
    private int body;
    private int size;
    private int weight;

    private String name;

    public Animal ( int brain, int body, int size, int weight, String name ) {
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
        this.name = name;
    }

    public void eat() {
        System.out.println("Animal.eat() called");
    }
}
```

* Dog - alsóbb class

Az állatok globális csoport egyik alcsoportja. Mivel a kutya az egy állat ezért az állatcsoportban készített .eat() metódust és társait tudja használni

```java
public class Dog extends Animal { // <-- felső class beállítása

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;

    private String coat;

    public Dog ( int size, int weight, String name, int eyes, int legs, int tail, int teeth, String coat ) {
        super( 1, 1, size, weight, name ); // <-- felső class meghívása
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew () {
        System.out.println("Dog.chew() called");
    }

    // felső class újraírása
    // pl ha a kutyák máskép esznek mint más állatok

    @Override
    public void eat () {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }
}

```

Ha az adott ostályban nem találja a metodust akkor mindig **elkezd fentebbi szinteken keresni**. Tehát ha `dog`-ban nem talál `chew` akkor az `animal`-ba keres, ha ott sem talál akkor a `java fő osztályát` nézi ha ott sem talál akkor **error**
