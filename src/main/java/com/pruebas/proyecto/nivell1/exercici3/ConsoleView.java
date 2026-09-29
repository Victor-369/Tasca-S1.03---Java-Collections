package com.pruebas.proyecto.nivell1.exercici3;

import java.util.Scanner;

public class ConsoleView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askPlayerName() {
        String name;
        do {
            System.out.print("Write your name: ");
            name = scanner.nextLine().trim();
        } while (name.isBlank());

        return name;
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