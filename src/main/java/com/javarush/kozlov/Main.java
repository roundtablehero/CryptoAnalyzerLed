package com.javarush.kozlov;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '!', '?', ' '};
    private static final Map<Character, Integer> map = new HashMap<>();

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


    public static void main(String[] args) {
        System.out.println("Длина алфавита: " + ALPHABET.length);
        String test = "привет";
        String encrypted = encrypt(test, 1);
        System.out.println("Encrypted 'привет' with key 1: " + encrypted);
    }
}
