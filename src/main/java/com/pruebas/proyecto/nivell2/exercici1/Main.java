package com.pruebas.proyecto.nivell2.exercici1;

import com.pruebas.proyecto.nivell2.exercici1.model.Restaurant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Restaurant> listRestaurants = new ArrayList<>();
        listRestaurants.add(new Restaurant("Michelin", 5));
        listRestaurants.add(new Restaurant("Michelin", 5));
        listRestaurants.add(new Restaurant("Michelin", 5));
        listRestaurants.add(new Restaurant("Michelin", 3));
        listRestaurants.add(new Restaurant("Michelin", 2));
        listRestaurants.add(new Restaurant("La Tasca", 4));
        listRestaurants.add(new Restaurant("El Racó", 2));

        System.out.println("Data ready to be added to the HashSet:");
        System.out.println(listRestaurants);
        System.out.println("Total: " + listRestaurants.size());

        HashSet<Restaurant> hashSetRestaurants = new HashSet<>();
        for (Restaurant rest : listRestaurants) hashSetRestaurants.add(rest);
        System.out.println("\nData added to the HashSet (no duplicate name-and-score pairs):");
        System.out.println(hashSetRestaurants);
        System.out.println("Total: " + hashSetRestaurants.size());
    }
}
