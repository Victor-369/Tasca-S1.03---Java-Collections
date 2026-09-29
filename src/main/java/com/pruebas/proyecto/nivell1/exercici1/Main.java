package com.pruebas.proyecto.nivell1.exercici1;


import com.pruebas.proyecto.nivell1.exercici1.model.Month;

import java.util.*;

public class Main {
    public static void main() {
        ArrayList<Month> monthsArrayList = new ArrayList<>(List.of(
                new Month("Gener"),
                new Month("Febrer"),
                new Month("Març"),
                new Month("Abril"),
                new Month("Maig"),
                new Month("Juny"),
                new Month("Juliol"),
                new Month("Setembre"),
                new Month("Octubre"),
                new Month("Novembre"),
                new Month("Desembre")
        ));

        System.out.println("Original array:");
        for (Month month : monthsArrayList) System.out.println(month);

        System.out.println("\nAdded 'Agost':");
        monthsArrayList.add(7, new Month("Agost"));
        for (Month month : monthsArrayList) System.out.println(month);

        System.out.println("\nTrying to add duplicates to HashSet:");
        Set<Month> monthsHashSet = new HashSet<>(monthsArrayList);
        System.out.println("Initial length: " + monthsHashSet.size());
        System.out.println("Add 'Gener': " + monthsHashSet.add(new Month("Gener")));
        System.out.println("Add 'Febrer': " + monthsHashSet.add(new Month("Febrer")));
        System.out.println("Final length: " + monthsHashSet.size());

        System.out.println("\nHashSet with Iterator:");
        Iterator<Month> iteratorMonth = monthsHashSet.iterator();
        while (iteratorMonth.hasNext()) System.out.println(iteratorMonth.next());

        System.out.println("\nHashSet with for:");
        for (Month month : monthsHashSet) System.out.println(month);
    }
}
