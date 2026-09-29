package com.pruebas.proyecto.nivell1.exercici3;

import com.pruebas.proyecto.nivell1.exercici3.io.ClassificationFileWriter;
import com.pruebas.proyecto.nivell1.exercici3.io.CountryFileReader;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final int MAX_QUESTIONS = 10;

        try {
            HashMap<String, String> countries = CountryFileReader.loadData();
            List<Map.Entry<String, String>> ListCountries = new ArrayList<>(countries.entrySet());
            String playerName = ConsoleView.askPlayerName();
            int totalScore = 0;

            Collections.shuffle(ListCountries);
            HashMap<String, String> randomCountries = ListCountries.stream()
                    .limit(MAX_QUESTIONS)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            HashMap::new
                    ));

            Iterator<Map.Entry<String, String>> iteratorRandomCountries = randomCountries.entrySet().iterator();
            int counter = 0;
            while (iteratorRandomCountries.hasNext()) {
                Map.Entry<String, String> record = iteratorRandomCountries.next();
                String country = record.getKey();
                String capital = record.getValue();
                counter++;

                boolean isCorrect = ConsoleView.askCapital(country, counter).equals(capital);
                ConsoleView.showAnswer(isCorrect, capital);
                if(isCorrect) totalScore++;
            }

            ConsoleView.showFinalScore(playerName, totalScore);
            ClassificationFileWriter.saveOrUpdate(playerName, String.valueOf(totalScore));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
