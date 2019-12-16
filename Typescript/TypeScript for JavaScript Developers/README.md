# Typescript

## Introduction to TypeScript

### Datatypes

#### String

```typescript
let color: string = "blue";
color == 'red';
```

#### Boolean

```typescript
let isDone: boolean = false;
```

#### Number

```typescript
// Hexadecimals
let hex: number = 0xf00d;

// Decimals
let decimal: number = 6;

// Binary
let binary: number = 0b1010;

// Octal
let octal: number = 0o744;
```

#### Array

```typescript
// Using squared braces
let list: number[] = [1, 2, 3];

// Using squared braces
let list: Array<number> = [1, 2, 3];
```

`Tuple` tpye array where elements can be of different types

```typescript
// Declare a tuple type
let x: [string, number];

// Initialize it
x = ["hello", 10]; // OK

// Initialize it incorrectly
x = [10, "hello"] // ERROR
```

#### Enum

```typescript
enum Color {Red, Green, Blue}
let c: Color = Color.Green;
```

#### Any

Dynamic content third party libraries

```typescript
let notSure: any = 4;
notSure = "maybe a string instead";
notSure = false;
// okay, definitely a boolean
```

#### Void

Void the absence of having any type at all

```typescript
let unusable: void = undefined;
function warnUser(): void {
  console.log("This is my warning message");
}
```

#### Null and Undefined

Null and Undefined have their own types respectively

```typescript
// Not much else we can assign to
// these variables!

let u: undefined = undefined;
let n: null = null;
}
```

#### Never

Never represents the types of values that have never occured.
It is a return type of the function expression

```typescript
// Function returning never
// must have unreachable end point
function error(message: string): never {
  throw new Error(message);
}
```

#### Object

Object It is a non-primitive data type

```typescript
declare function create(o: object | null):void;

create({ prop: 0 }); //OK
create(null); //OK

create(42); //Error
create("string"); //Error
create(false); //Error
create(undefined); //Error
```
