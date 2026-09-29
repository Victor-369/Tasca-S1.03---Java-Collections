package com.pruebas.proyecto.nivell1.exercici3.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class CountryFileReader {
    private static final Path COUNTRIES_FILE = Path.of(
            "src", "main", "java", "com", "pruebas", "proyecto",
            "nivell1", "exercici3", "file", "countries.txt"
    );

    public static HashMap<String, String> loadData() throws IOException {
        if (!countriesFileExists()) throw new IOException("File does not exists");

        HashMap<String, String> tmpCountries = new HashMap<>();

        try (var lector = Files.newBufferedReader(COUNTRIES_FILE, StandardCharsets.UTF_8)) {
            String text;
            while ((text = lector.readLine()) != null)  {
                String[] splitted = text.split(" ");
                String country = splitted[0].replace("_", " ");
                String capital = splitted[1].replace("_", " ");
                tmpCountries.put(country, capital);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return tmpCountries;
    }

    private static boolean countriesFileExists() {
        return Files.exists(COUNTRIES_FILE) && Files.isRegularFile(COUNTRIES_FILE);
    }
}
