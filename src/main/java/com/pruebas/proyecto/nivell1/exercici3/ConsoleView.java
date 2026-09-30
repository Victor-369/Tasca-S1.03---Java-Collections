package com.pruebas.proyecto.nivell1.exercici3;

import java.util.Scanner;

public class ConsoleView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askPlayerName() {
        while (true) {
            System.out.print("Write your name (without semicolons): ");
            String name = scanner.nextLine().trim();

            if (name.isBlank()) {
                System.out.println("The name cannot be empty.");
            } else if (name.contains(";")) {
                System.out.println("The name cannot contain a semicolon (;).");
            } else {
                return name;
            }
        }
    }

    public static String askCapital(String country, int question) {
        System.out.print("Question " + question + ". What is the capital of " + country +"?: ");
        return scanner.nextLine().trim();
    }

    public static void showAnswer(boolean correct, String capital) {
        System.out.println(correct
                ? "Correct!"
                : "Incorrect!. The capital is " + capital + ".");
    }

    public static void showFinalScore(String name, int score) {
        System.out.println(name + " you final score is " + score);
    }
}