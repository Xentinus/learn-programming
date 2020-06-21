# Python

## Basics

### Console log

```py
print('Hello world')
```

### Input

```py
input('What is your name? ')
```

You can save what you input like this.

```py
name = input('What is your name? ')
print('Hello' + name)
```

## Data Types

### Fundemental Core Data Types

#### Numbers

##### Math Functions

```py
round(3.1)  # 3
abs(-20)    # 20
```

##### Operator precedence

`()` , `**` , `* /` , `+-`

#### Binary

##### Get binary

```py
print(bin(5))   # 0b101
```

##### From binary

```py
int('0b101', 2)   # 5
# 2 is binary
```

#### Boolean

```py
is_licenced = True
```

#### String

##### Escape sequence

```py
weather = "It\'s \"king of\" sunny"
\t = add tab
\n = new line
```

##### Formatted strings

```py
name = 'Jonny'
age = 55

print('hi ' + name + '. You are ' + str(age) + ' years old')
```

If you put `f` in the line is better

```py
print(f'hi {name}. You are {age} years old')
print('hi {0}. You are {1} years old'.format(name, age))
print('hi {new_name}. You are {1} years old'.format(new_name='sally', age))
```

##### String indexing

```py
selfish = '01234567'
           01234567
```

[ **start** : **stop** : **stepover** ]

```py
print(selfish[0:8:2]) # 0246
print(selfish[1:])    # 1234567
print(selfish[:5])    # 01234
print(selfish[::1])   # 01234567
```

If you put minus then its going down

```py
print(selfish[-2])  # 6
```

Other sting metods

```py
print(len('hello')) # hosszúság 4
print(quote.replace('be', 'me'))  # to be or not to be -> to me or not to me
```

#### Lists (Arrays)

```py
li = [1,2,3,4,5]
li2 = ['a', 'b', 'c']
li3 = [1,2, 'ab', True]

matrix[0][2]
```

##### Lists slicing

```py
print(amazon_cart[0:2])
print(amazon_cart[0::2])
```

##### Copy lists

Dont simple copy because its watching memory! If there is change in `amazon_cart` then its change in `new_cart` too!

```py
new_cart = amazon_cart[:]
```

##### Add data to lists

```py
new_list = basket.insert(5,100)
new_list = basket.extend([100, 101])
```

##### Remove data from lists

```py
basket.pop()  # legutolsót kitörli, ha számot adsz meg akkor indexet törli, return amit kitörölsz
basket.remove(4)  # számot adsz meg akkor indexet törli, semmit nem returnöl
basker.clear()  # mindent kirötöl
```

##### Other lists metods

```py
basket.index(mitkeresek, mettol, meddig)  # az indexét adja vissza
basket.count('d') # mennyi van belölle a listsben
basket.sort() # sorrendbe teszi = sorted(basket) - new sorted array
basket.copy() # másol új listbe, nem memoriás
basket.reverse()  # megfordítja a listset, nem sortolja
len(basket) # lists hossza
list(range(1, 100)) # 1-től 99ig minden számmal készít egy listet, ha csak 1 szám van benne akkor 0-tól addig megy

new_sentence = '!'.join(['hi', 'my', 'name', 'is', 'JOJO']) = hi!my!name!is!JOJO

a,b,c, *other, d = [1,2,3,4,5,6,7,8,9]
a = 1, b = 2, c = 3, other = 4-8, d = 9


print('i' in ['a','b,'c','i']) = True
```

#### Tuple

**Fix** lists, you can't edit it.

```py
my_tuple = (1,2,3,4,5)
```

#### Set

```py
my_Set = {1,2,3,4,5,5}
print(my_Set) = {1,2,3,4,5} # csak az egyedi

my_Set.add(100)

print(my_Set[0])  # error
print(1 in my_Set)
len(my_Set) # csak egyedit számol
new_Set = my_Set.copy()
my_Set.clear()

my_Set.difference(your_Set)
```

#### Dictionary (Objects)

Placed randomly in the memory.

```py
user = {
  'a': [1,2,3],
  'b': 'hello',
  'x': True,
  123: [1,2,3],
  True: True
}

user['a'][1] = 1
user['b'] = hello

user2 = dict(name='JohnJohn')
```

##### Set Default Dictionary

```py
user.get('age', 55) = 55  # ha nem találja az age-t akkor használja a default 55-öt
```

##### Other Dictionary Methods

```py
print('basket' in user) = True
print('hello' in user.keys()) = False
print('hello' in user.values()) = True
print('hello' in user.items())
user.clear() = {} # return none
user2 = user.copy() # nem memória másolás
user.pop('age') # return value és törli a user-ből
user.popitem()  # legutolsó itemet törli (memóriában az utolsó, tehát random)
user.update({'age': 55})  # ha nem létezik a key akkor létrehoz egyet
```

#### None

```py
none = null
```

* complex

### Variables

```py
iq = 190

a,b,c = 1,2,3

#CONSTANT
PI = 3.14
```

`PI` is writeable! We have to show to the writter, that dont fuck with this.

### Expression statement

Statement line of action

```py
user_age = iq / 5
```

Expression

```py
iq / 5
```

### Augmented assignment operator

```py
some_value = 5
some_value = some_value + 2
some_value += 2
```

### String Concatenation

```py
'hello' + 5 = error 5 must be str
```

#### Type conversion

```py
str(100)
```

### Conditional logic

```py
is_old = True
is_licenced = True

if is_old and is_licenced:
  print('you are old enough to drive')
elif is_licenced:
  print('you can drive now')
else:
  print('else')

print('this not part of if')
```

#### Ternary Operator

```py
condition_if_true if condtion else conition_if_else

is_friend = True
can_message = 'message allowed' if is_friend else 'not allowed to message'
```

#### Short Circuiting

```py
if is_friend or is_user:
  print('best friends forever')
```

#### Logical Operators

* and
* or
* not   `!True`
* ===   `checking memory location if lists`
* \>
* <
* ==
* <=
* \>=

### Loops

#### For

```py
for item in [1,2,3,4,5]:
  print(item) => 1től 5ig kiprinteli (Egyesével)
```

##### Iterables

* list
* dictionary
* tuple
* set
* string

Iterated -> one by one check each item in the colleciton

##### Dictionary loops

```py
user = {
  'name': 'Golem',
  'age': 5006,
  'can_swim': False
}

for item in user:
  print(item) => print keys

for key, value in user.items():
  print(key, value) => print tuple key + value

for item in user.values():
  print(item) => print values

for item in user.keys():
  print(item) => print values


for number in range(0, 100):
  print(number) # loop 0-99

for _ in range(0, 10, 2):
  print(_)  # 0-2-4-6-8

for _ in range(mettől, meddig, step):
  print(_)
```

Very usefull if you need `index` number

```py
for i,char in enumerate('Hellllooooo'):
  print(i, char) => 0 H 1 e

for i, char in enumerate(list(range(100))):
  if char == 50:
    print(f'index of 50 is: {i})
```

#### While

```py
i = 0
while i < 50:
  print(i)
  i += 1
  break <- break out
else:
  print('done with all the work') <- break esetén nem írja ki


while True:
  response = input('say something: '):
  if (response == 'bye'):
    break

while i < len(my_list):
  i += 1
  continue <- visszamegy az elejére
  print(my_list[i])

while i < len(my_list):
  pass <- placeholder #thinking about it

picture = [
  [0,0,0,1,0,0,0],
  [0,0,1,1,1,0,0],
  [0,1,1,1,1,1,0],
  [1,1,1,1,1,1,1],
  [0,0,0,1,0,0,0],
  [0,0,0,1,0,0,0]
]

for row in picture:
  for pixel in row:
    if pixel:
      print('*', end='')
    else:
      print(' ', end='')
  print('')
```

### Functions

#### Parameters

```py
def say_hello(name, emoji):
  def another_func(n1, n2):
    return n1 + 2
  return another_func(num1, num2)
```

#### Arguments

```py
say_hello(1, 2)

Doc strings:

def test(a):
  '''
  Info: this function tests and prints param a
  '''
  print(a)

*args **kwargs

def super_func(*args, **kwargs):
  total = 0
  for items in kwargs.values():
    total += items
  return sum(args) + total

super_func(1,3,4,5,23, num1=5, num2=10)
```

Rule: params, *args, default parameters, **kwargs

### Scope

What variables do i have access to?

```py
def some_func():
  total = 100 <- function scope

total = 100 <- global scope
```

* Start with local
* Parent local
* Global
* Built in python function

#### Use global

```py
total = 0
def count():
  global total
  total += 1
  return total

print(count())
```

087
