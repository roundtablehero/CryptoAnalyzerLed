package com.javarush.kozlov;

import com.javarush.kozlov.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }

    //int key = 123; // <<<< args
    //String text = "Привет медвед!"; // <<<< args
    //String result = "......"; // <<<< args
}
