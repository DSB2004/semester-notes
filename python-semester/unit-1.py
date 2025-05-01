# -------------------------------------------------------
# Introduction to Python Basics
# -------------------------------------------------------

# Python is an interpreted, high-level, dynamically-typed language.
# You can write code in a script or directly in the interactive shell (REPL).

# -------------------------------------------------------
# Entering Expressions into the Interactive Shell
# -------------------------------------------------------

# In the interactive shell, you can type expressions and immediately see results:
# Example:
# >>> 2 + 3
# 5

# Let's start with some simple expressions in code:

print(2 + 3)         # Addition
print(10 - 4)        # Subtraction
print(5 * 3)         # Multiplication
print(8 / 2)         # Division (always float)

# -------------------------------------------------------
# Integer, Floating-Point, and String Data Types
# -------------------------------------------------------

# Integers
a = 10               # int
# Floating-point numbers
b = 3.14             # float
# Strings
c = "Hello, Python!" # str

print(type(a))       # <class 'int'>
print(type(b))       # <class 'float'>
print(type(c))       # <class 'str'>

# -------------------------------------------------------
# String Concatenation and Replication
# -------------------------------------------------------

# Concatenation: combining strings using +
first = "Hello"
second = "World"
combined = first + " " + second
print(combined)      # Output: Hello World

# Replication: repeating strings using *
laugh = "ha"
print(laugh * 3)     # Output: hahaha

# -------------------------------------------------------
# Storing Values in Variables
# -------------------------------------------------------

# Variables are used to store values
age = 25
name = "Alice"

# You can print and manipulate them
print(name + " is " + str(age) + " years old.")

# -------------------------------------------------------
# Your First Program
# -------------------------------------------------------

# Let's create a small program that takes name and age as input
# (In interactive shell, use input(); in script use fixed values or input())

user_name = "John"
user_age = 30
print("Hello " + user_name + ", you are " + str(user_age) + " years old.")

# -------------------------------------------------------
# Dissecting Your Program
# -------------------------------------------------------

# This program:
# - Stores strings and numbers in variables
# - Uses + to concatenate strings
# - Converts int to str using str()
# - Displays result using print()

# -------------------------------------------------------
# Flow Control: Boolean Values
# -------------------------------------------------------

# Booleans: True and False
is_adult = True
print(type(is_adult))  # <class 'bool'>

# -------------------------------------------------------
# Comparison Operators
# -------------------------------------------------------

print(5 == 5)    # True (equal)
print(5 != 3)    # True (not equal)
print(10 > 7)    # True
print(4 < 3)     # False
print(6 >= 6)    # True
print(2 <= 1)    # False

# -------------------------------------------------------
# Boolean Operators
# -------------------------------------------------------

# and, or, not
print(True and False)  # False
print(True or False)   # True
print(not True)        # False

# -------------------------------------------------------
# Mixing Boolean and Comparison Operators
# -------------------------------------------------------

x = 10
y = 20
print(x > 5 and y < 30)    # True
print(x < 5 or y > 15)     # True
print(not (x == 10))       # False

# -------------------------------------------------------
# Elements of Flow Control: if, elif, else
# -------------------------------------------------------

age = 18

if age < 13:
    print("You are a child.")
elif age < 18:
    print("You are a teenager.")
else:
    print("You are an adult.")

# -------------------------------------------------------
# Program Execution – Flow control with indentation
# -------------------------------------------------------

# Python uses **indentation** to define code blocks
# The following block prints only if the condition is True

if age >= 18:
    print("You can vote.")
    print("You are legally an adult.")

# -------------------------------------------------------
# Flow Control Statements: while, for
# -------------------------------------------------------

# While loop
count = 0
while count < 3:
    print("Counting:", count)
    count += 1

# For loop
for i in range(3):
    print("Looping:", i)

# -------------------------------------------------------
# Importing Modules
# -------------------------------------------------------

# Use `import` to access standard or external libraries

import math
print(math.sqrt(16))    # Output: 4.0

import random
print(random.randint(1, 10))  # Random int between 1 and 10

# -------------------------------------------------------
# Ending a Program Early with sys.exit()
# -------------------------------------------------------

import sys

print("Before exit.")
sys.exit("Good bye")  # Terminates the program here
print("This line will never be printed.")  # Will not run
