package com.javarush.kozlov.command;

public class Encode {
    private static final Cipher cipher = new Cipher();

    public static String encode(String text, int key) { //<<< String to charArray
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(cipher.encryptChar(c, key));
        }
        return sb.toString();
    }

}
