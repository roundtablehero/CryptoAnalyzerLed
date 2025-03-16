package com.javarush.kozlov.view;

import com.javarush.kozlov.command.Decode;
import com.javarush.kozlov.command.Encode;
import com.javarush.kozlov.util.PathBuilder;

import java.util.Scanner;

public class ConsoleRunner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PathBuilder pathbuilder = new PathBuilder();



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
                    String textEncode = pathbuilder.readFile("text/text.txt");
                    String encoded = Encode.encode(textEncode, keyEncode);
                    pathbuilder.writeFile("text/text_encrypted.txt", encoded);
                    System.out.println("Encrypted text saved to text/text_encrypted.txt");
                    break;
                case 2:
                    int keyDecode = getKey();
                    String textDecode = pathbuilder.readFile("text/text_encrypted.txt");
                    String decoded = Decode.decode(textDecode, keyDecode);
                    pathbuilder.writeFile("text/text_decrypted.txt", decoded);
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
