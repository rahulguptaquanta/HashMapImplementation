# HashMap Implementation

A Java console application demonstrating how to store and manage student grades using `HashMap`.

## Features

- Add a student's grade
- Retrieve a grade by student name
- Update an existing grade
- Display all student grades
- Remove a student
- Validate names and grade values

## Requirements

- Java Development Kit (JDK) 8 or later

## Project Structure

```text
HashMapImplementation/
├── src/
│   └── com/
│       └── internship/
│           └── hashmap/
│               └── HashMapImplementation.java
├── .gitignore
└── README.md
```

## Run the Program

From the project root, compile the source file:

```bash
javac -d out src/com/internship/hashmap/HashMapImplementation.java
```

Run the program:

```bash
java -cp out com.internship.hashmap.HashMapImplementation
```

## Concepts Demonstrated

- Java `HashMap`
- Key-value pairs
- `put()`, `get()`, `containsKey()`, and `remove()`
- Iterating through `entrySet()`
- Input validation and exception handling
