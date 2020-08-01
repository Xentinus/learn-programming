# Python

## Python Basics

### Numbers

Numbers in Python have to main forms

* Integers (whole numbers `2` )
* Floating Point (numbers with decimals `4.3` )

#### Get type

```py
type(100.0)
# float
```

#### Basic Arithmetic

```py
# Addition
1 + 1
# 2

# Subtraction
2 - 1
# 1

# Division (always return float)
3 / 2
# 1.5

# Powers
2 ** 3
# 8
2 ** (1/2)
# 1.414213562

# Order of Operations
1 + 2 * 1000 + 1
# 2002
```

#### Assigning Variables

```py
# Assigning
a = 2
# type(a)=int

a + 3
# 5

b = 3
a + b
# 5

# Reassignment
a = 1000
a + b
# 1003
```

#### Reassinment with same variable

```py
a
# 1000

a = a + a
# 2000
```

### Strings

Strings are an **ordered** sequence of **characters** enclosed with either single or double quotes.

```py
"example string" 'another example'
```

Since they are ordered, we can use indexing to retrieve individual characters or slicing to retrieve a subsection of the original string.

These action use [ ] square brackets and a number index to indicate position of what you wish to grab.

```py
Character:  H   E   L   L   O
Index:      0   1   2   3   4
Revers ind: 0   -4  -3  -2  -1
```

For slice notation, [ ] brackets are also used with the format:

[ **start** : **stop** : **step** ]

* **start** is a numerical index for the slice start
* **stop** is the index you will go (up to but **not include**)
* **step** is how large of a jump to make between characters

#### Creating strings

```py
# Comment. Won' show up when you run a script.

# Single or double quotes are okay.
'hello'
"hello"

# Use another set of quotes to capture that inside single quote
" I'm not a spy! "
```

#### Basic Printing of Strings

```py
print('one')
# one

print("Special Codes")
print('this is a new line \n notice how this prints')
print('this is a tab \t notice how this prints')
# Special Codes
# this is a new line
#  notice how this prints
# this is a tab   notice how this prints
```

#### Indexing and Slicing

##### Indexing

```py
word = "hello"

word[0]
# h

word[3]
# l

word[-1]
# o
```

##### Slicing

```py
alpha 'abcdef'

alpha[0:3]
# abc

alpha[2:4]
# cd

alpha[2:]
# cdef

alpha[:2]
# ab

alpha[0:6:2]
# ace
```

#### Basic String Methods

Methods are actions you can call off an object usually in the form `.method_name()` notice the closed parenthesis at the end. Strings have many methods.

```py
basic = "Hello world I am still a recruit"

basic.upper()
# HELLO WORLD I AM STILL A RECRUIT

basic.lower()
# hello world I am still a recruit

basic.split()
# ['Hello', 'world', 'I', 'am', 'still', 'a', 'recruit']

basic.split('I')
# ['Hello world ', ' am still a recruit']
```

#### Print Formatting

```py
username = "Recuit"
action = "run"

print("Welcome {}").format(username))
print("The {} needs to {}".format(user_name,action))
print("The {b} needs to {a}".format(a=user_name,b=action))

num = 123.6789
print("The code is: {}".format(num))
print("The code is: {:.2f}".format(num))
```
