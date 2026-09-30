package com.pruebas.proyecto.nivell1.exercici3;

import com.pruebas.proyecto.nivell1.exercici3.exception.NeedMoreCountriesException;
import com.pruebas.proyecto.nivell1.exercici3.io.ClassificationFileWriter;
import com.pruebas.proyecto.nivell1.exercici3.io.CountryFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final int MAX_QUESTIONS = 10;

    public static void main(String[] args) {
        try {
            playGame();
        } catch (IOException | NeedMoreCountriesException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame() throws IOException, NeedMoreCountriesException {
        HashMap<String, String> countries = CountryFileReader.loadData();
        List<Map.Entry<String, String>> countryEntries = new ArrayList<>(countries.entrySet());
        String playerName = ConsoleView.askPlayerName();
        ensureEnoughCountries(countries);

        HashMap<String, String> selectedCountries = selectRandomCountries(countryEntries);
        int score = askQuestions(selectedCountries);

        ConsoleView.showFinalScore(playerName, score);
        ClassificationFileWriter.save(playerName, String.valueOf(score));
    }

    private static void ensureEnoughCountries(HashMap<String, String> countries)
            throws NeedMoreCountriesException {
        if (countries.size() < MAX_QUESTIONS) {
            throw new NeedMoreCountriesException("Need at least ten countries.");
        }
    }

    private static HashMap<String, String> selectRandomCountries(
            List<Map.Entry<String, String>> countryEntries) {
        Collections.shuffle(countryEntries);
        return countryEntries.stream()
                .limit(MAX_QUESTIONS)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (first, second) -> first,
                        HashMap::new
                ));
    }

    private static int askQuestions(HashMap<String, String> countries) {
        Iterator<Map.Entry<String, String>> countryIterator = countries.entrySet().iterator();
        int score = 0;
        int questionNumber = 0;

        while (countryIterator.hasNext()) {
            Map.Entry<String, String> country = countryIterator.next();
            questionNumber++;
            boolean isCorrect = ConsoleView.askCapital(country.getKey(), questionNumber)
                    .equalsIgnoreCase(country.getValue());

            ConsoleView.showAnswer(isCorrect, country.getValue());
            if (isCorrect) score++;
        }

        return score;
    }
}
