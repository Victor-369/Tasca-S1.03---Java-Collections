package com.pruebas.proyecto.nivell1.exercici3.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ClassificationFileWriter {
    private static final Path CLASSIFICATION_FILE = Path.of(
            "src", "main", "java", "com", "pruebas", "proyecto",
            "nivell1", "exercici3", "file", "classificacio.txt"
    );

    public static void saveOrUpdate(String userName, String score) throws IOException {
        validUserName(userName);
        int newScore = parseScore(score);

        HashMap<String, String> records = new HashMap<>();

        if (Files.exists(CLASSIFICATION_FILE)) {
            try (var reader = Files.newBufferedReader(
                    CLASSIFICATION_FILE, StandardCharsets.UTF_8)) {
                String record;
                int lineNumber = 0;

                while ((record = reader.readLine()) != null) {
                    lineNumber++;

                    if (record.isBlank()) {
                        continue;
                    }

                    String[] fields = record.split(";", -1);
                    if (fields.length != 2 || fields[0].isBlank()) {
                        throw new IOException(
                                "Invalid classification record at line " + lineNumber
                        );
                    }

                    String existingUser = fields[0].trim();
                    if (existingUser.contains("\n") || existingUser.contains("\r")) {
                        throw new IOException(
                                "Invalid user name at line " + lineNumber
                        );
                    }

                    int existingScore;
                    try {
                        existingScore = parseScore(fields[1].trim());
                    } catch (IllegalArgumentException e) {
                        throw new IOException(
                                "Invalid score at line " + lineNumber, e
                        );
                    }

                    records.put(
                            existingUser.toLowerCase(Locale.ROOT),
                            Integer.toString(existingScore)
                    );
                }
            }
        }

        records.put(
                userName.trim().toLowerCase(Locale.ROOT),
                Integer.toString(newScore)
        );

        try (var writer = Files.newBufferedWriter(
                CLASSIFICATION_FILE,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE
        )) {
            for (Map.Entry<String, String> entry : records.entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue());
                writer.newLine();
            }
        }
    }

    private static void validUserName(String userName) {
        if (userName == null
                || userName.isBlank()
                || userName.contains(";")
                || userName.contains("\n")
                || userName.contains("\r")) {
            throw new IllegalArgumentException(
                    "The user name must be non-empty and cannot contain semicolons or line breaks."
            );
        }
    }

    private static int parseScore(String score) {
        final int parsedScore;

        try {
            parsedScore = Integer.parseInt(score);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The score must be an integer between 0 and 10.", e);
        }

        if (parsedScore < 0 || parsedScore > 10) {
            throw new IllegalArgumentException("The score must be between 0 and 10.");
        }

        return parsedScore;
    }
}