package com.pruebas.proyecto.nivell1.exercici2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> listInteger = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> listIntegerReverse = new ArrayList<>();

        System.out.println("Ordered list: " + listInteger);

        ListIterator<Integer> listIteratorInteger = listInteger.listIterator(listInteger.size());
        while (listIteratorInteger.hasPrevious()) listIntegerReverse.add(listIteratorInteger.previous());

        System.out.println("Reversed list: " + listIntegerReverse);
    }
}
