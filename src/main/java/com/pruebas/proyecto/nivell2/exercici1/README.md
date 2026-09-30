# Exercise 1 — `HashSet` without exact duplicates

This exercise demonstrates how to store restaurants in a `HashSet` and prevent exact duplicates: two objects are considered equal when they have the same name and score.

## Classes

- `Main` creates a list of restaurants, adds them to a `HashSet`, and displays both collections and their sizes.
- `model/Restaurant` defines the `name` (`String`) and `score` (`int`) attributes. It overrides `equals()` and `hashCode()` using both attributes, and `toString()` to make restaurants easier to print.

Restaurants may therefore have the same name if their scores differ. However, only one instance of each name-and-score pair is kept.

## Running the programme

Run the `main` method in `Main`. The example list contains seven entries; the `HashSet` contains five because the three `Michelin(5)` entries are reduced to one.

The order in which a `HashSet` prints its elements is not guaranteed and may vary:

```text
total: 7
[...]
total: 5
```
