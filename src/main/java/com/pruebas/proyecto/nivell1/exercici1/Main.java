package com.pruebas.proyecto.nivell1.exercici1;


import com.pruebas.proyecto.nivell1.exercici1.model.Month;

import java.util.*;

public class Main {
    public static void main() {
        start();
    }

    public static void start() {
        ArrayList<Month> monthsArrayList = new ArrayList<>(List.of(
                new Month("January"),
                new Month("February"),
                new Month("March"),
                new Month("April"),
                new Month("May"),
                new Month("June"),
                new Month("July"),
                new Month("September"),
                new Month("October"),
                new Month("November"),
                new Month("December")
        ));

        System.out.println("Original array:");
        for (Month month : monthsArrayList) System.out.println(month);

        System.out.println("\nAdded 'August':");
        monthsArrayList.add(7, new Month("August"));
        for (Month month : monthsArrayList) System.out.println(month);

        System.out.println("\nTrying to add duplicates to HashSet:");
        Set<Month> monthsHashSet = new HashSet<>(monthsArrayList);
        System.out.println("Initial length: " + monthsHashSet.size());
        System.out.println("Add 'January': " + monthsHashSet.add(new Month("January")));
        System.out.println("Add 'February': " + monthsHashSet.add(new Month("February")));
        System.out.println("Final length: " + monthsHashSet.size());

        System.out.println("\nHashSet with Iterator:");
        Iterator<Month> iteratorMonth = monthsHashSet.iterator();
        while (iteratorMonth.hasNext()) System.out.println(iteratorMonth.next());

        System.out.println("\nHashSet with for:");
        for (Month month : monthsHashSet) System.out.println(month);
    }
}
