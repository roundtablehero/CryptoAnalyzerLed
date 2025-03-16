package com.javarush.kozlov.command;

import com.javarush.kozlov.constant.Alphabet;

import java.util.HashMap;
import java.util.Map;

public class Cipher {
    private final char[] alphabet;
    private static final Map<Character, Integer> map = new HashMap<>();

    public Cipher(){
        this.alphabet = Alphabet.getAlphabet();

            for (int i = 0; i < alphabet.length; i++) {
                map.put(alphabet[i], i);
            }

    }

    public char encryptChar(char c, int key) {
        if (map.containsKey(c)) {
            int i = map.get(c);
            int newIndex = (i + key) % alphabet.length;
            if (newIndex < 0) {
                newIndex += alphabet.length;
            }
            return alphabet[newIndex];

        }
        return c;
    }
}
