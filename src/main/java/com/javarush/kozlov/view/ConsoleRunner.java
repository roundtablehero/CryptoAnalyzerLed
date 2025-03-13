package com.javarush.kozlov.view;

import java.util.Arrays;

public class ConsoleRunner {
    public static void main(String[] args) {
        String russian = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String english = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digit = "0123456789";
        String symbols = "!@#$%^&*(){}[],.";
        String alphabet = russian + english + russian.toLowerCase() +
                english.toLowerCase() + digit + symbols;

        int key = 123; // <<<< args
        String text = "Привет медвед!"; // <<<< args
        String result = "......"; // <<<< args



        System.out.println(Arrays.toString(args));
    }
}
