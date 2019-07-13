# Java tanulás

## Változók

### Integer ( 32 szélesség )

> - 2,147,483,643 -> 2,147,483,647 **( 2 147 millió )**

```java
int myFirstNumer = 5;
int mySecondNumber = (10 + 5) + (2 * myFirstNumber);
int myLastOne = 1000 - mySecondNumber;
int myMinValue = -2_147_483_643; // more readable (java 8)
```

### Byte ( 8 szélesség )

> -128 -> 127 **( 128 )**

```java
byte myByteValue = -128;
byte myNewByteValue = (byte) (myByteValue / 2);
```

### Short ( 16 szélesség )

> -32,768 -> 32,767 **( 32 ezer )**

```java
short myShortValue = 32767;
short myNewShortValue = (short) (myShortValue / 2);
short shortTotal = (short) (1000 + 10 * (byteValue + shortValue + intValue));
```

### Long ( 64 szélesség )

> -9,223,372,036,854,775,808**L** -> -9,223,372,036,854,775,807**L**

```java
long myLongValue = 100L;
long longTotal = 50_000L + 10L * (byteValue + shortValue + intValue);
```
