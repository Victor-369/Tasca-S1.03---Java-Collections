# Exercise 1 — Lists, Sets, and Duplicates

A short Java exercise that explores how `ArrayList` and `HashSet` behave, particularly when duplicate elements are involved.

## What the program does

1. Creates a `Month` class with a single `name` attribute.
2. Adds 11 month objects to an `ArrayList`, deliberately leaving out "August".
3. Inserts "August" at index 7 so that the months are in the correct order.
4. Converts the `ArrayList` into a `HashSet`.
5. Attempts to add two duplicates ("January" and "February") and shows that the set rejects them.
6. Traverses the `HashSet` using both a `for` loop and an `Iterator`.

## Project structure

```
src/main/java/com/pruebas/proyecto/nivell1/exercici1/
├── Main.java
└── model/
    └── Month.java
```

## Important notes

### A `HashSet` does not keep its elements in order

Unlike the `ArrayList`, a `HashSet` **does not guarantee any particular order**. Elements are stored according to their hash code, so the months will appear in an apparently random sequence when the set is printed. This is expected behaviour and not a bug.

If insertion order needs to be preserved, `LinkedHashSet` can be used instead, but this exercise specifically requires `HashSet`.

### Why duplicates are rejected

A `HashSet` relies on `hashCode()` and `equals()` to decide whether an element already exists. The `Month` class overrides both methods so that two `Month` objects with the same name are considered equal. Without these overrides, Java would compare memory references and the duplicates would be accepted.

## Expected output (duplicates check)

```
Initial length: 12
Add 'January': false
Add 'February': false
Final length: 12
```

The `add()` method returns `false` when the element is already present, and the size of the set stays the same.
