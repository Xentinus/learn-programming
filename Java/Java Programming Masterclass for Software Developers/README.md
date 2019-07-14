# Java tanulás

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
