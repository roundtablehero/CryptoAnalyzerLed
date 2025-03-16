package com.javarush.kozlov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '!', '?', ' '};
    private static final Map<Character, Integer> map = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);


    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            map.put(ALPHABET[i], i);
        }
    }

    private static char encryptChar(char c, int key) {
        if (map.containsKey(c)) {
            int i = map.get(c);
            int newIndex = (i + key) % ALPHABET.length;
            if (newIndex < 0) {
                newIndex += ALPHABET.length;
            }
            return ALPHABET[newIndex];

        }
        return c;
    }

    private static String encrypt(String text, int key) { //<<< String to charArray
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(encryptChar(c, key));
        }
        return sb.toString();
    }

    private static String decrypt(String text, int key) { //<<< String to charArray
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(encryptChar(c, -key));
        }
        return sb.toString();
    }

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
                    int keyEncrypt = getKey();
                    String textEncrypt = readFile("text/text.txt");
                    String encrypted = encrypt(textEncrypt, keyEncrypt);
                    writeFile("text/text_encrypted.txt", encrypted);
                    System.out.println("Encrypted text saved to text/text_encrypted.txt");
                    break;
                case 2:
                    int keyDecrypt = getKey();
                    String textDecrypt = readFile("text/text_encrypted.txt");
                    String decrypted = decrypt(textDecrypt, keyDecrypt);
                    writeFile("text/text_decrypted.txt", decrypted);
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
