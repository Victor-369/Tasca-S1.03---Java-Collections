# Exercise 3 – Country Capitals Quiz

A Java console quiz that practises reading files, using a `HashMap`, and interacting with the user.

## How to play

1. Run `Main` and enter a non-empty player name. Names containing a semicolon (`;`) are rejected by input validation.
2. The program reads the country and capital pairs from `countries.txt`.
3. It shuffles the available countries and asks ten questions about different countries. At least ten valid country records must be available.
4. Enter each country's capital. Answers are compared without distinguishing upper-case and lower-case letters; leading and trailing spaces are ignored.
5. The programme displays the final score out of ten and appends the player's name and score to `classificacio.txt`.

## Project structure

```text
src/main/java/com/pruebas/proyecto/nivell1/exercici3/
├── Main.java
├── ConsoleView.java
├── README.md
├── exception/
│   └── NeedMoreCountriesException.java
├── file/
│   ├── countries.txt
│   └── classificacio.txt
└── io/
    ├── CountryFileReader.java
    └── ClassificationFileWriter.java
```

## Data files

### Countries

The input file is located at:

```text
src/main/java/com/pruebas/proyecto/nivell1/exercici3/file/countries.txt
```

Each non-blank line contains a country and its capital separated by a comma:

```text
Albania,Tirana
Andorra,Andorra_la_Vella
```

Underscores are converted to spaces when the data is loaded. The reader expects exactly two non-empty fields on each non-blank line and reports malformed records with their line number. The pairs are loaded into a `HashMap<String, String>` with the country as the key and its capital as the value.

### Classification

The results file is located at:

```text
src/main/java/com/pruebas/proyecto/nivell1/exercici3/file/classificacio.txt
```

Each record uses this format:

```text
playername:score
```

The writer appends a new record each time the quiz is completed; it does not update earlier records for the same player. The file is created if it does not already exist. Player names are saved after leading and trailing spaces are trimmed; semicolons and line breaks are not allowed.

## Main classes

- `Main` loads the data, selects ten random questions, checks answers, calculates the score, and saves the result.
- `ConsoleView` handles console input and output.
- `io/CountryFileReader` loads and validates the country and capital records.
- `io/ClassificationFileWriter` validates the player name and appends the result to the classification file.
- `exception/NeedMoreCountriesException` represents the case where fewer than ten countries are available.

## Running the program

The file paths are relative to the project root. Run `Main` with the project root as the working directory so that the input and classification files can be found.

The project is configured for Java 25 in `pom.xml`.
