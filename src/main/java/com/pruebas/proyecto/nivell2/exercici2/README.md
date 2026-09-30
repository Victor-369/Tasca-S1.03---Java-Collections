# Exercise 2 — Sorting by multiple criteria

This exercise sorts a list of restaurants alphabetically by name and, when two names are the same, by score in descending order.

## Classes

- `Main` creates a sample list and sorts it in place using `List.sort()` with a `Comparator`. The comparator orders restaurants by name first, then by score from highest to lowest.
- `model/Restaurant` stores each restaurant's `name` and `score` and provides getters used by the comparator. Its `toString()` method formats restaurants for console output.

## Running the program

Run the `main` method in `Main`. It displays the original list followed by the sorted list. The sample names are unique, so the secondary score ordering is not visible in this particular output. For restaurants with the same name, the higher score appears first.

The sorted sample order is:

```text
Arzak(3)
Asador Etxebarri(8)
Azurmendi(10)
Disfrutar(9)
DiverXO(4)
El Celler de Can Roca(6)
Martín Berasategui(5)
Mugaritz(6)
Quique Dacosta(2)
Tickets(7)
```

The comparator uses Java's natural `String` ordering for names. The order of restaurants with both the same name and the same score is not further specified.