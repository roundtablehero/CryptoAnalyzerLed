package com.javarush.kozlov.view;

import com.javarush.kozlov.command.Cipher;
import com.javarush.kozlov.command.Decode;
import com.javarush.kozlov.command.Encode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConsoleRunner {
    private static final Scanner scanner = new Scanner(System.in);


    private static String readFile(String filePath) {
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

    private static void writeFile(String filePath, String sb) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8)) {
            writer.write(sb);
        } catch (IOException e) {
            throw new RuntimeException("ERROR writing file: " + e.getMessage());
        }
    }

    private static int getKey() {
        System.out.println("Enter Key: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid key value! Default key set to 1.");
            return 1;
        }
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.println("Choose and option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    int keyEncode = getKey();
                    String textEncode = readFile("text/text.txt");
                    String encoded = Encode.encode(textEncode, keyEncode);
                    writeFile("text/text_encrypted.txt", encoded);
                    System.out.println("Encrypted text saved to text/text_encrypted.txt");
                    break;
                case 2:
                    int keyDecode = getKey();
                    String textDecode = readFile("text/text_encrypted.txt");
                    String decoded = Decode.decode(textDecode, keyDecode);
                    writeFile("text/text_decrypted.txt", decoded);
                    System.out.println("Decrypted text saved to text/text_decrypted.txt");
                    break;
                case 3:
                    System.out.println("Application closed.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } scanner.close();

    }

}
