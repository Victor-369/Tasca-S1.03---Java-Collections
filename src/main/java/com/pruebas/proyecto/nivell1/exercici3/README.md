# Exercise 3 – Capital Game

A Java console game that practises file reading, `HashMap` and user interaction.

## What the program does

1. Reads the country and capital pairs from `countries.txt` and stores them in a `HashMap<String, String>` (key: country, value: capital).
2. Asks the player for their name.
3. Picks 10 different countries at random from the `HashMap`.
4. For each country, asks the player to type the name of its capital. A correct answer adds one point.
5. Shows the final score.
6. Saves the player's name and score in `classificacio.txt`.

## Project structure

```
src/main/java/com/pruebas/proyecto/nivell1/exercici3/
├── Main.java
├── ConsoleView.java
├── file/
│   ├── countries.txt
│   └── classificacio.txt
└── io/
    ├── CountryFileReader.java
    └── ClassificationFileWriter.java
```

## Important notes

### Data file format

Each line of `countries.txt` contains a country and its capital separated by a space. Underscores are replaced with spaces when the file is read (for example, `Andorra_la_Vella` becomes `Andorra la Vella`). The file currently has 51 lines.

### Answers are case-sensitive

An answer is correct only if it matches the capital exactly, including capital letters. Leading and trailing spaces are removed before the comparison.

### Classification file

Each line of `classificacio.txt` contains a name (stored in lower case) and a score separated by a space, for example `alex 10`. If the name already exists, its score is replaced by the new one. The file is only updated if it already exists.

### File paths

Both files are read from a path relative to the project root (`src/main/java/com/pruebas/proyecto/nivell1/exercici3/file/`), so the program should be run from the root folder of the project.
