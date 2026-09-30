package com.pruebas.proyecto.nivell1.exercici3.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class CountryFileReader {
    private static final Path COUNTRIES_FILE = Path.of(
            "src", "main", "java", "com", "pruebas", "proyecto",
            "nivell1", "exercici3", "file", "countries.txt"
    );

    public static HashMap<String, String> loadData() throws IOException {
        if (!countriesFileExists()) {
            throw new IOException("Countries file does not exist: " + COUNTRIES_FILE);
        }

        HashMap<String, String> countries = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(COUNTRIES_FILE)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.isBlank()) {
                    continue;
                }

                String[] fields = line.split(",", -1);
                if (fields.length != 2
                        || fields[0].isBlank()
                        || fields[1].isBlank()) {
                    throw new IOException(
                            "Invalid country record at line " + lineNumber
                                    + ". Expected: country,capital"
                    );
                }

                String country = fields[0].trim().replace("_", " ");
                String capital = fields[1].trim().replace("_", " ");

                countries.put(country, capital);
            }
        }

        return countries;
    }

    private static boolean countriesFileExists() {
        return Files.exists(COUNTRIES_FILE) && Files.isRegularFile(COUNTRIES_FILE);
    }
}
