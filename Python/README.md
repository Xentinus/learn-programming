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

#### Indexing and Slicing strings

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

### Lists

Lists are ordered sequence that can hold a variety of object types. They use [ ] brackets and commas to separate objects in the list.

```py
[1, 2, 3, 4, 5]
```

Lists support indexing and slicing. Lists can be nested and also have a variety of useful methods that can be called off of them.

```py
my_list = [1,2,3]
# [1, 2, 3]

my_list2 = ['a', 2.3, 1]
# ['a', 2.3, 1]
```

#### Indexing and Slicing lists

Work just like string.

```py
mylist = ['a', 'b', 'c', 'd']

mylist[0]
# 'a'

mylist[0:3]
# ['a', 'b', 'c']
```

#### Len Function

One useful builtin function is the **len** function which returns back the length of an object.

```py
len('string')
# 6

len(my_list)
# 3
```

#### Useful List Methods

```py
mylist = [1, 2, 3]
mylist.append(4)
# [1, 2, 3, 4]

mylist.pop()
# return what is removed!
# 4

mylist
# [1, 2, 3]

mylist.pop(0)
# 1
# [2, 3]

mylist = [1, 2, 3, 4, 5]

mylist.reverse()
# Doesn't return anything
# [5, 4, 3, 2, 1]

mylist.sort()
# Doesn't return anything
# [1, 2, 3, 4, 5]

mylist.insert(0, 'NEW')
['NEW', 1, 2, 3, 4, 5]
```

#### Nested Lists

Lists can hold other lists!

```py
new_list= [1, 2, 3, ['a', 'b', 'C']]
new_list[3]
# ['a', 'b', 'c']

new_list[3][0]
# 'a'
```

### Dictionaries

Doctopmaroes are unordered mappings for storing objects. Dictionaries use a key-value.
This key-value pair allows users to quickly grab objects without needing to know an index location.

#### Creating a Dictionary

```py
d = {'key1': 'value1', 'key2': 'value'}
d['key1']
# 'value'
```

#### Adding new key-items pairs

```py
d['new_key'] = 'new item'
# {'key1': 'value1', 'key2': 'value2', 'new_key': 'new item'}
```

> **Note:** Dictionaries are unordered! This may not be clear at first with smaller dictionaries, but as dictionaries get larger they won't retain order, which means they can not be sorted! If you need order and the ability to sort, stick with a sequence, like a list!

```py
d = {'a':1,'z':2}
d['new'] = 0
# {'a': 1, 'new': 0, 'z': 2}
```

Dictionaries are very flexible in the data types they can hold, they can hold numbers, strings, lists, and even other dictionaries!

#### Dictionaries Methods

```py
code_names = {"Obama":'Renegade',
             "Bush":'Trailblazer',
             "Reagan":"Rawhide",
             "Ford":"Passkey"}

code_names.keys()
# dict_keys(['Obama', 'Bush', 'Reagan', 'Ford'])

code_names.values()
# dict_values(['Renegade', 'Trailblazer', 'Rawhide', 'Passkey'])

code_names.items()
# dict_items([('Obama', 'Renegade'), ('Bush', 'Trailblazer'), ('Reagan', 'Rawhide'), ('Ford', 'Passkey')])

```

### Tuples

Tuples are very similar to a list. They are ordered sequences of objects, however they use ( ) parentheses instead of [ ].

```py
my_tuple = (1, 2, 3, 4, 5)
```

The major difference, being that turples are **immutable**!

#### Creating a Tuple

Mixed data types are fine!

```py
t = (1, 2, 3)
t[0]
# 'a'
```

#### Immutability

```py
t[0] = 'new'
# TypeError: 'tuple' object does not support item assignment

t.append('Nope')
# AttributeError: 'tuple' object has no attribute 'append'
```

#### Tuple Methods

```py
t = ('a','b','c','a')
t.index('b')
# Returns index of first instance!
# 1

t.count('a')
# 2
```

### Sets

A set is an unordered collection of unique elements.
We can construct them by using the `set()` function.

#### Constructing Sets

```py
x = set()
x.add(1)
# {1}

x.add(2)
# {1, 2}

# You can also quickly create a set with just {}
myset = {1,2,3}
```

> **Note** the curly brackets. This does not indicate a dictionary! Although you can draw analogies as a set being a dictionary with only keys.

We know that a set has only unique entries. So what happens when we try to add something that is already in a set?

```py
mylist = [1,1,1,1,1,2,2,2,2,2,3,3,3,3,3]
set(mylist)
# {1, 2, 3}
```

### Booleans

Booleans are data types that indicate a logical state of `True` or `False`.

Python also has a placeholder object called `None`.

```py
a = True
# True

type(a)
# bool

1 > 2
# False

2 == 2
# True
```

We can use `None` as a placeholder for an object that we **don't want to reassign yet**!

```py
c = None
type(c)
# NoneType
```

### Working with Files

#### Open a file

```py
myfile = open('test_file.txt')
# Same location

myfile.read()
# One giant string!

myfile.seek(0)
# resets the cursor to the very beginning of the file


myfile.readlines()
# return back a list where every item is a single line
```

> **Remember:** Always close the file once you open.

#### File Locations

If want to open files at another location on your computer, simply pass in the entire file path.

For Windows you need to use double \ so python doesn't treat the second \ as an escape character, a file path is in the form:

```py
myfile = open("C:\\Users\\YourUserName\\Home\\Folder\\myfile.txt")
```

For MacOS and Linux you use slashes in the opposite direction:

```py
myfile = open("/Users/YouUserName/Folder/myfile.txt")
```

#### Best Practice

Often best practice is to use the `with` statement for opening files, this allows you to not worry about closing the file after you open it.

```py
with open('test_file.txt') as myfile:
    # Notice the indentation!
    lines = myfile.read()


# File auto closed after this with statment
```

#### Read and Write Options

The open() function has a second parameter that allows you to specify whether you only want to be able to read the file, or write to it as well, or do both.

##### Modes & Description

**r**  
Opens a file for reading only. The file pointer is placed at the beginning of the file. This is the default mode.

**r+**  
Opens a file for both reading and writing. The file pointer placed at the beginning of the file.

**w**  
Opens a file for writing only. **Overwrites** the file if the file exists. If the file does not exist, creates a new file for writing.

**w+**  
Opens a file for both writing and reading. **Overwrites** the existing file if the file exists. If the file does not exist, creates a new file for reading and writing.

**a**  
Opens a file for **appending**. The file pointer is at the end of the file if the file exists. That is, the file is in the append mode. If the file does not exist, it creates a new file for writing.

**ab**  
Opens a file for **appending** in binary format. The file pointer is at the end of the file if the file exists. That is, the file is in the append mode. If the file does not exist, it creates a new file for writing.

**a+**  
Opens a file for both appending and reading. The file pointer is at the end of the file if the file exists. The file opens in the append mode. If the file does not exist, it creates a new file for reading and writing.

```py
f = open('test_file.txt', mode='w')
# Returns the number of characters written
f.write('new line')
# 8

f.close()

f = open('test_file.txt')
f.read()
# 'new line'
```

> Notice how the entire file has been overwritten! If you want to add to the file, you need to use the **'a'** append mode for writing to it.

## Control Flow Basics

Control flow allows us to add logic to our code.  
We can specify under what conditions we want certain code execute.  

To do this, we use the `if`, `elif`, and `else` statements.

Overview of Comparison Operators

| Symbol | Meaning |
| - | - |
| > | Greater Than |
| < | Less Than |
| <= | Less Than or Equal To |
| >= | Greater Than or Equal To |
| == | Equals
| != | Not Equal |

Control Flow will use boolean conditions to decide whether or not to execute a block of code.

Control Flow syntax makes use of colons and indentation ( **whitespace** )

> This indentation system is crucial to Python and is what sets it apart from other programming languages.

### if, elif, and else statements

#### Simple if Statement

The format for an if statement

```py
if 1>2:
    print("One is greater than two")

# Nothing
```

#### If, else Statement

```py
if 1==2:
    print("One is equal to Two")
else:
    print("First if was not True")

# First if was not True
```

#### If, elif, else Statement

```py
if 2 == 0:
    print('First condition True')
elif 2 == 1:
    print("Second condition True")
elif 2 == 100:
    print("Third condition True")
else:
    print("None of the above conditions were True")

# None of the above conditions were True
```

### While Loops

In general loops allow us to repeat code multiple times.

```py
# Start by setting variable x
x = 1

while x <= 3:
    print(x)
    x = x + 1 # alternatively you could write x += 1

# 1
# 2
# 3
```

> Be very careful with while loops, if a condition is set to **always be true**, your while loop will run forever, causing your program to stuck.

Let's move on with some more examples. First let's show you how to accept an input from a user

```py
saved_input = input("Please input a number: ")
# '2'
```

> Notice its a string! You can always cast it with `int()` or `float()` to get a int or float to work with.

```py
print("Welcome Agent")
# start with some default passcode (needs to be defined before while loop starts)
passcode = 0

while passcode != 123:
    passcode = int(input("Please provide your passcode: "))

    #Nested control flow logic
    if passcode != 123:
        print("Sorry wrong passcode provided")
        print("Try Again")
        print('\n')

# This won't run until the while loop is
# done because of the indentation
print("Correct Passcode!")
```

#### break keyword

The break keyword allows you to "break" out of the loop that contains the break keyword.

```py
x = 0

while x < 10:
    print(x)
    x += 1

    if x == 3:
        # This will cause to break out of the top loop
        # Note that if statements don't count as loops
        break

# 0
# 1
# 2
```

### For Loops

Many objects in Python are "iterable", meaning we can iterate over every element in the object. Such as every element in a list or every character in a string.  
We can use for loops to execute a block of code for every iteration.

```py
# for loop with a list

mylist = [1,2,3,4]

for num in mylist:
    print(num)

# 1
# 2
# 3
# 4

for num in mylist:
    print(num,end=' ')

> 1 2 3 4
```

#### continue keyword

The continue keyword can be a bit tricky to see its usefulness, but it allows you to continue with the top level loop, basicaly the opposite of break.

```py
for letter in 'code':
    if letter == 'd':
        continue
        
    print('Current Letter is: {}'.format(letter))

# Current Letter is: c
# Current Letter is: o
# Current Letter is: e
```

### Useful Operators

#### range function

The range function allows you to quickly generate a **list of integers**, this comes in handy a lot, so take note of how to use it! There are 3 parameters you can pass, a start, a stop, and a step size.

```py
range(0,11)
```

> Note that this is a **generator** function, so to actually get a list out of it, we need to cast it to a list with `list()`. What is a generator? Its a special type of function that will generate information and not need to save it to memory.

```py
# Third parameter is step size!

list(range(0,11,2))
# [0, 2, 4, 6, 8, 10]
```

#### enumerate function

enumerate is a very useful function to use with for loops.

```py
index_count = 0

for letter in 'abcde':
    print("At index {} the letter is {}".format(index_count,letter))
    index_count += 1
```

```py
# Notice the tuple unpacking!

for i,letter in enumerate('abcde'):
    print("At index {} the letter is {}".format(i,letter))
```

#### zip function

```py
list(enumerate('abcde'))
```

It was a list of tuples, meaning we could use tuple unpacking during our for loop. This data structure is actually very common in Python , especially when working with outside libraries. You can use the `zip()` function to quickly create a list of tuples by "zipping" up together two lists.

```py
mylist1 = [1,2,3,4,5]
mylist2 = ['a','b','c','d','e']

list(zip(mylist1,mylist2))
[(1, 'a'), (2, 'b'), (3, 'c'), (4, 'd'), (5, 'e')]
```

#### in operator

```py
'x' in ['x','y','z']
# True

'x' in [1,2,3]
# False
```

#### min and max function

```py
mylist = [10,20,30,40,100]

min(mylist)
# 10

max(mylist)
# 100
```

#### random function

Python comes with a built in random library. There are a lot of functions included in this random library.

```py
from random import shuffle

# This shuffles the list "in-place" meaning it won't return
# anything, instead it will effect the list passed
shuffle(mylist)
# [40, 10, 100, 30, 20]

from random import randint
# Return random integer in range [a, b], including both end points.
randint(0,100)
# 25
```

#### input

```py
input('Enter Something into this box: ')
Enter Something into this box: great job!
```

### List Comprehensions

 List comprehensions allow us to build out lists using a different notation. You can think of it as essentially a one line for loop built inside of brackets.

 ```py
mylist = []
for let in 'word':
    mylist.append(let)

# ['w', 'o', 'r', 'd']
```

Using a list comprehension

```py
myletters = [let for let in 'word']
# ['w', 'o', 'r', 'd']

squares = [x**2 for x in range(0,11)]
# [0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100]
```

You can also do an if/else statement in a list comprehension, but keep in mind, at a certain point you will sacarafice readability, which is a big part of Python. If you are having trouble figuring out how to put something in a list comprehension, just use a for loop instead, its almost always just as efficient.

```py
mylist = [x if x%2 == 0 else 'not even' for x in range(0,10) ]
# [0, 'not even', 2, 'not even', 4, 'not even', 6, 'not even', 8, 'not even']
```

## Functions

Creating clean repeatable code is a key part of becoming an effective programmer.

Functions allow us to create blocks of code that can be easily execute multiple times, without needing to constantly rewrite the entire block of code.

### The def Statement

To create a function we use the def keyword.

```py
def lowercase_function_name(argument1,argument2,argument3='default value'):
    '''
    This is the DocString of the function. It is where you can write a helpful 
    description for anyone who will use your function.
    '''
    # After the docstring you write code that does stuff.
```

```py
def report(name='Jason'):
    print('Reporting {}'.format(name))

report()
# Reporting Jason

report('Kay')
# Reporting Kay
```

### The return keyword

```py
def add(n1,n2):
    return n1+n2

add(2,3)
# 5
```

### Nested Statements and Scopes

```py
x = 'outside'

def report():
    x = 'inside'
    return x
```

#### Scope

**LEGB Rule.**

**L: Local** — Names assigned in any way within a function (def or lambda)), and not declared global in that function.

**E: Enclosing function locals** — Name in the local scope of any and all enclosing functions (def or lambda), from inner to outer.

**G: Global (module)** — Names assigned at the top-level of a module file, or declared global in a def within the file.

**B: Built-in (Python)** — Names preassigned in the built-in names module : open,range,SyntaxError

### Global keyword

You can use the global keyword before the variable to indicate you want to "grab" the global variable. Keep in mind this is generally not recommended, and you should try your best to avoid this until you become more experienced, because it becomes very easy to accidentally create errors this way by overwriting variables in one part of your script that effect the script in a completely different part.

```py
x = 'global outside'

def myfunc():
    # Must declare global keyword before every using it
    # inside of the function.
    global x

    print('X is {}'.format(x))

    x = 'redefined inside myfunc() with global keyword'

    print('X is {}'.format(x))


myfunc()
# X is global outside
# X is redefined inside myfunc() with global keyword 
```

### Lambda Expression, Map, Filter

Map and Filter are built-in functions in Python that allow you to efficiently apply functions to lists.

Lambda expressions are useful in this context because they allow for the creator of functionality without the full formal syntax of a normal Python function.

#### map function

The map function allows you to "map" a function to an iterable object. That is to say you can quickly call the same function to every item in an iterable, such as a list.

```py
def square(num):
    return num**2
my_nums = [1,2,3,4,5]

for item in map(square,my_nums):
  print(item)
# 1, 4, 9, 16, 25

list(map(square,my_nums))
# [1, 4, 9, 16, 25]
```

#### filter function

The filter function returns an iterator yielding those items of iterable for which function(item) is true. Meaning you need to filter by a function that returns either True or False. Then passing that into filter (along with your iterable) and you will get back only the results that would return True when passed to the function.

```py
def check_even(num):
    return num % 2 == 0
nums = [0,1,2,3,4,5,6,7,8,9,10]

list(filter(check_even,nums))
# [0, 2, 4, 6, 8, 10] <- only true numbers
```

#### lambda expression

One of Pythons most useful (and for recruits, confusing) tools is the lambda expression. lambda expressions allow us to create "anonymous" functions. This basically means we can quickly make ad-hoc functions **without needing to properly define** a function using def.

Function objects returned by running lambda expressions work exactly the same as those created and assigned by defs. There is key difference that makes lambda useful in specialized roles:

**lambda's body is a single expression, not a block of statements.**

The lambda's body is similar to what we would put in a def body's return statement. We simply type the result as an expression instead of explicitly returning it. Because it is limited to an expression, a lambda is less general that a def. We can only squeeze design, to limit program nesting. lambda is designed for coding simple functions, and def handles the larger tasks.

Block type

```py
def square(num):
  result = num**2
  return result
```

Simplify

```py
def square(num):
  return num**2
```

Even write this all on one line

```py
def square(num): return num**2
```

This is the form a function that a lambda expression intends to replicate.

```py
lambda num: num ** 2

list(map(lambda num:num**2,[1,2,3]))
# {1, 4, 9}
```

## Object Oriented Programming

Object Oriented Programming (OOP) allows programmers to create their own objects that have methods and attributes.

Recall that after defining a string, list, dictionary, or other objects, you were able to call methods off of them with the .method_name() syntax.

OOP allows users to create their own objects.

The general format is often confusing then first encountered, and its usefulness may not be completely clear at first.

In general, OOP allows us to create code that is repeatable and organized.

For much larger scripts of Python code, functions by themselves aren't enough for organization and repeatability.

Commonly repeated tasks and objects can be defined with OOP to create code that is more usable.

```py
class NameOfClass():
  
  def __init__(self, param1, param2):
    self.param1 = param1
    self.param2 = param2

  def some_method(self):
    # perform some action
    print(self.param1)
```

### Class

The user defined objects are created using the class keyword. The class is a blueprint that defines a nature of a future object. From classes we can construct instances. An instance is a specific object created from a particular class. 

```py
# Create a new object type called Sample
class Sample():
    pass

# Instance of Sample
x = Sample()

print(type(x)
# <class '__main__.Sample'>
```

By convention we give classes a name that starts with a capital letter. Note how x is now the reference to our new instance of a Sample class. In other words, we **instantiate** the Sample class.

Inside of the class we currently just have pass. But we can define class attributes and methods.

An **attribute** is a characteristic of an object. A **method** is an operation we can perform with the object.

For example we can create a class called Agent. An attribute of an Agent may be their height, eye color, name, etc. A method is typically more similar to a function acting on the object itself, for example having the Agent object print out its code name would be suitable for a method.

Let's get a better understanding of attributes through an example.

### Attributes

The syntax for creating an attribute is:

```py
self.attribute = something
```

There is a special method called:

```py
__init__()
```

This method is used to initialize the attributes of an object.

```py
class Agent():
    def __init__(self, real_name):
        self.real_name = real_name


m = Agent('Mike')
# 'Mike'
```

Lets break down what we have above. The special method

`__init__()`

is called automatically right after the object has been created:

`def __init__(self, real_name):`

Each attribute in a class definition begins with a reference to the instance object. It is by convention named self. The real_name is the argument. The value is passed during the class instantiation.

`self.real_name = real_name`

Now we have created two instances of the Agent class. With two Agent instances, they each have their own real_name attribute, we can then access these attributes like this:

```py
m.real_name
# 'Mike'
```

In Python there are also class object attributes. These Class Object Attributes are the same for any instance of the class. For example, we could create the attribute **planet** for the Agent class. Agents (regardless of their height,eye color,name, or other attributes will always be on planet Earth, at least for now! We apply this logic in the following manner:

```py
class Agent():

    # Class Object Attribute
    planet = 'Earth'

    def __init__(self, real_name, eye_color, height):
        self.real_name = real_name
        self.eye_color = eye_color
        self.height = height

m = Agent('Mike', 'Green', 175)
```

> Note that the Class Object Attribute is defined outside of any methods in the class. Also by convention, we place them first before the init.

```py
m.real_name
# 'Mike'
m.height
# 175
m.eye_color
# 'Green'
m.planet
# 'Earth'
```

### Methods

Methods are functions defined inside the body of a class. They are used to perform operations with the attributes of our objects. Methods are essential in encapsulation concept of the OOP paradigm. This is essential in dividing responsibilities in programming, especially in large applications.

You can basically think of methods as functions acting on an Object that take the Object itself into account through its self argument.

```py
class Circle():

    # Should be same for any circle of any size
    pi = 3.14

    # Circle get instantiated with a radius (default is 1)
    def __init__(self, radius=1):
        self.radius = radius

    # Area method calculates the area. Note the use of self.
    def area(self):
        return self.radius * self.radius * Circle.pi

    def perimeter(self):
        return 2 * self.radius * Circle.pi

    def report_something(self,name):
        return 'Report {}'.format(name)

mycircle = Circle(3)

mycircle.radius

mycircle.area()
# 28.26
```

### Inheritance

Inheritance is a way to form new classes using classes that have already been defined. The newly formed classes are called derived classes, the classes that we derive from are called base classes. Important benefits of inheritance are code reuse and reduction of complexity of a program. The derived classes (descendants) override or extend the functionality of base classes (ancestors).

First Base Class

```py
class Person():
    def __init__(self,first_name,last_name):
        self.first_name = first_name
        self.last_name = last_name

    def report(self):
        print("I am {} {}.".format(self.first_name,self.last_name))

    def hello(self):
        print("Hello!")
```

Second Class will inherit from Person base class, allowing it to inherit its attributes and methods. Notice how we pass the class, we don't actually instantiate it with () , we just pass it through.

```py
class Agent(Person):

    def __init__(self,first_name,last_name,code_name):
        Person.__init__(self,first_name,last_name)
        self.code_name = code_name

    def report(self):
        # This overwrites the Person report() method
        print('Sorry I can not give you my real name')
        print("You can call me {}".format(self.code_name))

    def true_name(self,passcode):
        # We can add additional methods unique to the Agent class

        if passcode == 123:
            print("Thank you for providing the passcode")
            print("I am {} {}.".format(self.first_name,self.last_name))
        else:
            self.report()

    def _private_methods(self):
        # Start methods with a single underscore to make them "private"
        # Keep in mind Python is very open by its nature
        # Any user could still find out these classes exist
        # This is more to denote that the user shouldn't be needing
        # To interact with this method.
        print("Privacy Please.")


    # Notice how we don't have the hello() method here
    # We will be inheriting it from the Person class!
```

### Special Methods