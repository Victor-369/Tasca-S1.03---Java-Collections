package com.pruebas.proyecto.nivell2.exercici2;

import com.pruebas.proyecto.nivell2.exercici2.model.Restaurant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("El Celler de Can Roca", 6));
        restaurants.add(new Restaurant("Disfrutar", 9));
        restaurants.add(new Restaurant("DiverXO", 4));
        restaurants.add(new Restaurant("DiverXO", 4));
        restaurants.add(new Restaurant("Asador Etxebarri", 8));
        restaurants.add(new Restaurant("Asador Etxebarri", 8));
        restaurants.add(new Restaurant("Asador Etxebarri", 8));
        restaurants.add(new Restaurant("Arzak", 3));
        restaurants.add(new Restaurant("Tickets", 7));
        restaurants.add(new Restaurant("Martín Berasategui", 5));
        restaurants.add(new Restaurant("Azurmendi", 10));
        restaurants.add(new Restaurant("Quique Dacosta", 2));
        restaurants.add(new Restaurant("Mugaritz", 6));

        System.out.println("Actual list of restaurants: ");
        System.out.println(restaurants);

        HashSet<Restaurant> hashSetRestaurants = new HashSet<>(restaurants);
        List<Restaurant> orderedRestaurants = new ArrayList<>(hashSetRestaurants);
        orderedRestaurants.sort(
                Comparator.comparing(Restaurant::getName)
                        .thenComparing(Restaurant::getScore, Comparator.reverseOrder())
        );

        System.out.println("\nRestaurants without duplicates, ordered by name and score:");
        System.out.println(orderedRestaurants);
    }
}
