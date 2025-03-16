package com.javarush.kozlov.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PathBuilder {
    public String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("ERROR reading file: " + e.getMessage());
        }
        return sb.toString();
    }

    public void writeFile(String filePath, String sb) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
            writer.write(sb);
        } catch (IOException e) {
            throw new RuntimeException("ERROR writing file: " + e.getMessage());
        }
    }
}
