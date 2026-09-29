package com.pruebas.proyecto.nivell1.exercici3.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ClassificationFileWriter {
    private static final Path CLASSIFICATION_FILE = Path.of(
            "src", "main", "java", "com", "pruebas", "proyecto",
            "nivell1", "exercici3", "file", "classificacio.txt"
    );

    public static void saveOrUpdate(String userName, String score) throws IOException {
        validUserName(userName);
        validScore(score);

        HashMap<String, String> records = new HashMap<>();
        if (Files.exists(CLASSIFICATION_FILE)) {
            try (var reader = Files.newBufferedReader(CLASSIFICATION_FILE, StandardCharsets.UTF_8)) {
                String record;
                while ((record = reader.readLine()) != null) {
                    String[] splitted = record.split(" ");

                    String user = splitted[0].toLowerCase();
                    String points = splitted[1];

                    records.put(user, points);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            records.put(userName.toLowerCase(), score);

            try (var writer = Files.newBufferedWriter(CLASSIFICATION_FILE, StandardCharsets.UTF_8)) {
                for (var entry : records.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validUserName(String userName) {
        if (userName == null || userName.isBlank() || userName.contains(",")
                || userName.contains("\n") || userName.contains("\r")) {
            throw new IllegalArgumentException("The user name must be non-empty and cannot contain commas or line breaks.");
        }
    }

    private static void validScore(String score) {
        if (Integer.parseInt(score) < 0) throw new IllegalArgumentException("The score cannot be negative.");
    }
}
