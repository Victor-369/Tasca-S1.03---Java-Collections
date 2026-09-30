package com.pruebas.proyecto.nivell1.exercici3.io;

import java.io.FileWriter;
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

    public static void save(String userName, String score) throws IOException {
        validUserName(userName);

        try (FileWriter writer = new FileWriter(CLASSIFICATION_FILE.toFile(), true)) {
            writer.write(userName + ":" + score + "\n");
        } catch (IOException e) {
            e.getMessage();
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
}