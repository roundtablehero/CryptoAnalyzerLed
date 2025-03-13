package com.javarush.kozlov.constants;

public class Constants {
    private static final String russian = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String english = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String digit = "0123456789";
    private static final String symbols = "!@#$%^&*(){}[],. ";
    private static final String alphabet = russian + english + russian.toLowerCase() +
            english.toLowerCase() + digit + symbols;

}
