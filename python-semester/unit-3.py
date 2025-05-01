# ========================================
# 📘 File Handling & Organization in Python
# ========================================

# -------------------------------
# 📂 1. Files and File Paths
# -------------------------------

# 'open' function is used to read/write files
# Modes: 'r' = read, 'w' = write (overwrite), 'a' = append

file_path = "example.txt"

# Writing to a file
with open(file_path, "w") as f:
    f.write("Hello, this is a sample file.\n")
    f.write("Python is fun!\n")

# Reading from a file
with open(file_path, "r") as f:
    content = f.read()
    print("File Content:\n", content)

# -------------------------------
# 🧭 2. os.path Module
# -------------------------------

import os

# Absolute path
abs_path = os.path.abspath("example.txt")
print("Absolute Path:", abs_path)

# Directory name
print("Directory:", os.path.dirname(abs_path))

# Check if path exists
print("Does file exist?", os.path.exists(file_path))

# Join paths (cross-platform)
new_path = os.path.join("folder", "subfolder", "file.txt")
print("Joined Path:", new_path)

# -------------------------------
# 💾 3. File Reading/Writing Process
# -------------------------------

# Reading line by line
with open(file_path, "r") as f:
    lines = f.readlines()
    print("Lines as List:", lines)

# Appending to file
with open(file_path, "a") as f:
    f.write("Appended line.\n")

# -------------------------------
# 📦 4. Saving Variables with shelve
# -------------------------------

import shelve

# Shelve creates a persistent dictionary
with shelve.open("mydata") as shelf:
    shelf["fruits"] = ["apple", "banana", "cherry"]

# Reading back
with shelve.open("mydata") as shelf:
    print("Fruits from shelf:", shelf["fruits"])

# -------------------------------
# 🧾 5. Saving Variables with pprint.pformat()
# -------------------------------

import pprint

data = [{"name": "Alice", "age": 25}, {"name": "Bob", "age": 30}]

# Save formatted data to file
with open("data.py", "w") as f:
    f.write("people = " + pprint.pformat(data) + "\n")

# data.py now contains a valid Python list called 'people'

# -------------------------------
# 📁 6. shutil Module
# -------------------------------

import shutil

# Copy file
shutil.copy("example.txt", "example_copy.txt")

# Move file
shutil.move("example_copy.txt", "moved_example.txt")

# Delete file
os.remove("moved_example.txt")

# -------------------------------
# 🌳 7. Walking a Directory Tree
# -------------------------------

for foldername, subfolders, filenames in os.walk("."):
    print("Current folder:", foldername)
    print("Subfolders:", subfolders)
    print("Files:", filenames)
    print("-----")

# -------------------------------
# 🗜️ 8. Compressing Files with zipfile
# -------------------------------

import zipfile

# Create a new zip file and add files
with zipfile.ZipFile("archive.zip", "w") as zipf:
    zipf.write("example.txt")

# Extracting files
with zipfile.ZipFile("archive.zip", "r") as zipf:
    zipf.extractall("unzipped")

# List contents of zip file
with zipfile.ZipFile("archive.zip", "r") as zipf:
    print("ZIP Contents:", zipf.namelist())

# -------------------------------
# ✅ End of Unit Summary
# -------------------------------

print("\nAll file handling and organization topics covered!")
