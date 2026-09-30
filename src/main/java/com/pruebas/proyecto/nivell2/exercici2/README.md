# Exercise 2 — Sorting by multiple criteria

This exercise stores restaurants in a `HashSet` to remove exact duplicates, then sorts a list copy alphabetically by name and, when two names are the same, by score in descending order.

## Classes

- `Main` creates a sample list, adds its elements to a `HashSet`, copies the set to a list, and sorts that list using a `Comparator`.
- `model/Restaurant` stores each restaurant's `name` and `score`. Its `equals()` and `hashCode()` methods use both fields, so only exact name-and-score duplicates are removed. Its `toString()` method formats restaurants for console output.

## Running the program

Run the `main` method in `Main`. It displays the original list followed by the unique restaurants ordered by name. Restaurants with the same name but different scores are kept, with the higher score first. The sample includes repeated `DiverXO(4)` and `Asador Etxebarri(8)` entries, which each appear only once in the final list.

The sorted, duplicate-free sample order is:

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

The comparator uses Java's natural `String` ordering for names, followed by descending score. `HashSet` itself does not guarantee an iteration order; the displayed order comes from sorting the list copy.
