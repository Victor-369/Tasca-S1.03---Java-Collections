package com.pruebas.proyecto.nivell2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> listInteger = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> listIntegerReverse = new ArrayList<>(listInteger).reversed();
        System.out.println("Ordered list: " + listInteger);
        System.out.println("Reversed list: " + listIntegerReverse);

        System.out.println("\nUsing ListIterator to read elements from the first list and add them to the second list (reversed list)");
        ListIterator<Integer> listIteratorInteger = listInteger.listIterator();
        while (listIteratorInteger.hasNext()) listIntegerReverse.add(listIteratorInteger.next());

        System.out.println("Checking the new elements in the reversed list: " + listIntegerReverse);
    }
}
