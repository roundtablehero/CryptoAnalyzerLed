package com.javarush.kozlov.command;

public class Decode {
    private static final Cipher cipher = new Cipher();

    public static String decode(String text, int key) { //<<< String to charArray
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(cipher.encryptChar(c, -key));
        }
        return sb.toString();
    }

}
