package com.lockers.lockedme.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Util {

    public static int getIntegerUserInput(String message) throws IOException {
        return Integer.parseInt(getUserInput(message));
    }

    public static String getStringUserInput(String message) throws IOException {
        return getUserInput(message);
    }

    private static String getUserInput(String message) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        displayMessage(message);
        return bufferedReader.readLine();
    }

    public static void displayMessage(String message)
    {
        System.out.println(message);
    }
}
