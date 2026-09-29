# Exercise 2 – ListIterator

A short Java exercise that practises list manipulation and the use of `ListIterator`.

## What the program does

1. Creates and fills a `List<Integer>` with the values 1 to 6.
2. Creates a second list containing the same elements in reverse order.
3. Uses a `ListIterator` to read the elements of the first list and add them to the second list.
4. Prints the lists to the console.

## Project structure

```
src/main/java/com/pruebas/proyecto/nivell1/exercici2/
└── Main.java
```

## Output

```
Ordered list: [1, 2, 3, 4, 5, 6]
Reversed list: [6, 5, 4, 3, 2, 1]

Using ListIterator to read elements from the first list and add them to the second list (reversed list)
Checking the new elements in the reversed list: [6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6]
```

## Notes

- The reversed list is created with `reversed()`, so it requires Java 21 or later (the project is configured for Java 25 in `pom.xml`).
- After the `ListIterator` has added the elements of the first list, the second list contains its original reversed elements followed by the elements of the first list in their original order.
