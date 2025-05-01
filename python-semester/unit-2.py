# ===============================
# 📘 Python Core Concepts - Unit
# ===============================

# --------------------------------
# 🧠 1. Function Definitions
# --------------------------------

# Defining a function with parameters (also called formal arguments)
def add(x, y):
    # Return the sum of two numbers
    return x + y

# Calling the function with actual arguments
result = add(5, 3)
print("Addition Result:", result)  # Output: 8

# --------------------------------
# ➕ Return Values and the None Type
# --------------------------------

def show_message():
    print("Hello, this function prints but returns nothing.")

returned_value = show_message()
print("Returned Value:", returned_value)  # Output: None

# --------------------------------
# 💬 Keyword and Default Arguments
# --------------------------------

def greet(name, message="Hello"):
    print(f"{message}, {name}!")

greet("Alice")                    # Uses default message
greet(name="Bob", message="Hi")  # Uses keyword arguments

# --------------------------------
# 🗺️ Local vs Global Scope
# --------------------------------

x = 10  # Global variable

def change_local():
    x = 5  # Local to this function
    print("Inside change_local():", x)

def change_global():
    global x  # Declare to modify global variable
    x = 20
    print("Inside change_global():", x)

change_local()          # Output: 5
print("After local:", x)  # Output: 10

change_global()         # Changes global x
print("After global:", x)  # Output: 20

# --------------------------------
# ⚠️ Exception Handling
# --------------------------------

try:
    result = 10 / 0
except ZeroDivisionError:
    print("Cannot divide by zero!")  # Handles division error
finally:
    print("This block always executes.")  # Always runs

# --------------------------------
# 📋 Lists and Their Methods
# --------------------------------

# Creating a list
fruits = ["apple", "banana", "cherry"]

# Accessing elements
print(fruits[0])  # Output: apple

# Adding elements
fruits.append("orange")  # Adds at the end

# Inserting at a position
fruits.insert(1, "mango")  # Inserts at index 1

# Removing elements
fruits.remove("banana")  # Removes first occurrence

# Sorting the list
fruits.sort()

print("Updated List:", fruits)

# --------------------------------
# ➕ Augmented Assignment Operators
# --------------------------------

x = 5
x += 3  # Same as x = x + 3
x *= 2  # Same as x = x * 2
print("Augmented Result:", x)  # Output: 16

# --------------------------------
# 📚 Dictionaries and Structuring Data
# --------------------------------

# Creating a dictionary
person = {
    "name": "Alice",
    "age": 30,
    "city": "New York"
}

# Accessing values
print(person["name"])  # Output: Alice

# Adding new key-value pair
person["email"] = "alice@example.com"

# Removing a key
del person["city"]

# Iterating through dictionary
for key, value in person.items():
    print(f"{key}: {value}")

# --------------------------------
# 🖨️ Pretty Printing Dictionaries
# --------------------------------

import pprint

data = {
    "user": "Alice",
    "activities": ["reading", "writing", "coding"],
    "profile": {
        "age": 30,
        "location": "USA"
    }
}

pprint.pprint(data)

# --------------------------------
# 🔤 String Manipulation
# --------------------------------

text = "  Hello, World!  "

# String methods
print(text.lower())         # hello, world!
print(text.upper())         # HELLO, WORLD!
print(text.strip())         # Removes leading/trailing spaces
print(text.replace("World", "Python"))  # Replace substring
print(text.split(","))      # Split into list by comma

# Joining strings
words = ["Python", "is", "awesome"]
joined = " ".join(words)
print(joined)

# Accessing characters
print(text[2])  # Prints character at index 2

# --------------------------------
# ✅ End of Unit Summary
# --------------------------------

print("\nAll core concepts covered with examples and comments!")
