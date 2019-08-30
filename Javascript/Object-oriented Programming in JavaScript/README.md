# Functions

## Factory Function

```js
function createCircle(radius) {
  return {
    radius,
    draw: funciton() {
      console.log('draw');
    }
  };
}

const circle = createCircle(1);
```

## Constructor Function

Kell hívásnál a `new` mert különben a `Global`-t fogja használni.

```js
function Circle(radius) {
  this.radius = radius;
  this.draw = function() {
    console.log('draw');
  }
}

const another = new Circle(1);
```

## Call function

```js
Circle.call({}, 1);
Circle.apply({}, [1,2,3]);
```

# Objects

## Object call

```js
circle.location = { x: 1};
circle['location'] = { x: 1};

for(let key in circle) {
  console.log(key, circle[key]);
}
```

## Object-en belüli dekl. törlése

```js
delete circle.location;
```

## Object-en belüli PRIVÁT MODE

**Privát dekl.**

Ha `let` vagy `const` ként dekl. akkor azok nem érhetőek el külsőleg.

**Publikus dekl.**

Ha `this`-t használunk akkor azt el lehet érni: `Sajt.eat`

## Csak olvasható / írható function

**Törölhető e az adott cucc**

`configurable: true`

**Látható e az adott cucc**

`enumerable: false`

**Írható e az adott cucc**

`writable: true`

**Ezeknek az értékeknek az olvasása**

> Properties vagy Property (mennyiségtől függ)

```js
let person = { name: 'Mosh' };
let objectBase = Object.getPrototypeOf(person);
let descriptor = Object.getOwnPropertyDescription(objectBase, 'toString');
console.log(descriptor);
```

**Csak írás / olvasás function-ök**

**Csak olvasható**

`get: function()`

**Csak írható**

`set: function()`

**get-re egy példa (nem ES06-os)**

```js
let property = 1;

this.getProperty = function() {
  return property;
};

Object.defineProperty(this, 'getProperty', {
  get: function() {
    return property;
  }
});
```

**ES6 get / set példa**

```js
Class Circle {

  // ...

  get radius() {
    return _radius.get(this);
  }

  set radius(value) {
    _radius.set(this, value);
  }
}
```

# Prototype

Elösszőr az objectben keresi a cuccokat, majd annak prototypejában és igy tovább a szülökön végig

>circle -> circleBase -> objectBase

```js
function Circle(radius) {
  // Instance members
  this.radius = radius;

  this.move = function() {
    this.draw();
    console.log('move');
  }
}

// Prototype members
Circle.prototype.draw = function() {
  console.log('draw');
}

Circle.prototype.toString = function() {
  return 'Circle with radius ' + this.radius;
}

const c1 = new Circle(1);
```

Prototype-os cuccok nem jelennek meg az `Object.keys(1)` -ben, viszont `for (let key in c1) console.log(key)` -ben pedig minden megjelenik (instance + prototype)

## Prototype-ok összekötése

`object prototype` hozzáadása külön

```js
Circle.prototype = Object.create(Object.prototype); //objectBase
Circle.prototype = Object.create(Shape.protoype);
```

Ha meg kell tartani az alap constructort (ajánlott) tehát ne váltson Shape object-re

```js
Circle.prototype = Object.create(Shape.protoype);
Circle.prototype.constructor = Circle;
```

**Function-ös összekötés**

```js
function extend(Child, Parent) {
  Child.prototype = Object.create(Parent.prototype);
  Child.prototype.constructor = Child;
}
```

## Circle Object készítése Constructorral

```js
new Circle.protoype.costructor(1);
new Circle(1); //rövidebb verzió
```

## Parent dekl. behívása

```js
function Shape(color) {
  this.color = color;
}

function Circle(radius, color) {
  Shape.call(this, color);

  this.radius = radius;
}
```
## Szülö method elérése

> Prototípe hozzáadás után kell

> Ez fog véghez menni csak ha szülőnek is van ugyan ilyen funcitonje

```js
Circle.prototype.duplicate = function() {
  // felnőtt hívása
  Sharpe.prototype.duplicae.call(this);
  
  // + cuccok
  console.log('duplicate circle');
}
```

## Polymorfozis

> Poly: Many morph: Forms

> Ha a shape egy circle akkor a circle duplicate functionjét fogja végbehajtani

```js
const shapes = [
  new Circle(),
  new Square()
];

for (let shape of shapes)
  shape.dusplicate();
```

## Mixins

> Ezzel a modszerrel könnyebb hozzáadni és eltávolítani functionöket

```js
const canSwim = {
  swim: function() {
    console.log('swim');
  }
};

function Person() {
}

Object.assign(Person.prototype, canSwim);

const person = new Person();
console.log(person);
```

# ES6

## Classes

> Nincs hoisting mint az alap objektumosnál

**Objectumos stílus**

```js
function Circle(radius){
  this.radius = radius;

  this.draw = function() {
    console.log('draw');
  }
}

const c = new Circle(1);
```

**ES6 Class-ként**

> `new`-t kötelező használni mert különben errot fog kiadni

```js
class Circle {
  constructor(radius) {
    //ez a rész ugyan az mint az objektumnál az dekl. rész

    this.radius = radius;
    this.move = function() {}
  }

  draw() {
    console.log('draw');
  }
}

const c = new Circle(1);
```

## Szölő hozzáadása

> extends SZÜLŐ (ahol utána fogja megnézni miután az adott prototypeban nem találta)

```js
class Shape {
  constructor(color) {
    this.color = color;
  }

  move() {
    console.log('move');
  }
}

class Circle extends Shape {
  // Mindenféle képpen kell a super ha a szölőben van kellő konstruktor
  constructor(color, radius) {
    super(color);
    this.radius = radius;
  }

  draw() {
    console.log('draw');
  }

  move() {
    // A Circle move-ját fogja csak használni, ha akarjuk a szölőt is belevonni akkor a super-ral behívható az adott metodus
    super.move();
    console.log('move');
  }
}

const c = new Circle('red', 1);

```

## Get / Set Classban

```js
const _radius = new WeakMap();

Class Circle {
  constructor(radius) {
    _radius.set(this, radius);
  }

  get radius() {
    return _radius.get(this);
  }

  set radius(value) {
    if (value <= 0) throw new Error('invalid value');
    _radius.set(this, value);
  }
}

const c = new Circle(1);
```

## Statikus Method

Egy Objektumhoz nem hozzátartozó segéd methódusok

```js
class Circle {
  constructor(radius) {
    this.radius = radius;
  }

  // Instance Method
  draw() {
    console.log('draw');
  }

  // Static Method
  static parse(str){
    const radius = JSON.parse(str).radius;
    return new Circle(radius);
  }
}

const circle = Circle.parse('{ "radius": 1 }');
```

## Privát dekl. (Sybols)

> Minden Symbol egyedi!

```js
const _radius = Symbol();
const _draw = Symbol();

class Circle {
  constructor(radius) {
    this[_radius] = radius;
  }

  [_draw]() {

  }
}

const c = new Circle(1);
const key = Object.getOwnPropertySymbols(c)[0];
console.log(c[key]);
```

## Privát dekl. (WeakMap)

```js
const _radius = new WeakMap();
const _move = new WeakMap();

class Circle {
  constructor(radius) {
    _radius.set(this, radius);

    _move.set(this, () => {
      console.log('move', this);
      // ha this arrow functionben van itt akkor látható dev toolban minden hidden cucc!

      // Alap fucntionben a Global-t piszkálja
    });

    draw() {
      _move.get(this)();
      console.log('draw');
    }
  }
}
```

# Modules

## CommonJS (Node)

**Export**

```js
const _radius = new WeakMap();

class Circle {
  constructor(radius) {
    _radius.set(this, radius);
  }

  draw() {
    console.log('Circle with radius ' + _radius.get(this));
  }
}

module.exports = Circle; // ha csak egyet kell kiprotálni
module.exports.Circle = Circle;
```

**Import**

```js
const Circle = require('./circle');

const c = new Circle(10);
c.draw();
```

## ES6 Modules (Web)

**Export**

```js
const _radius = new WeakMap();

export class Circle {
  constructor(radius) {
    _radius.set(this, radius);
  }

  draw() {
    console.log('Circle with radius ' + _radius.get(this));
  }
}
```

**Import**

* HTML

```html
<script type="module" src="index.js"></script>
```

* JS

```js
import {Circle} from './circle.js';

const c = new Circle(10);
c.draw();
```

# Enable strip mode

`'use strict';` kell a doksi elejére ahhoz hogy bekapcsoljon ez a mod.

Hibát fog kiírni ha a `Global` lenne basztatva.
