package com.lockers.lockedme.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public abstract class Util {

    public enum MainContextOption{
        DISPLAY_FILES_AND_FOLDERS,
        FILE_MANIPULATION,
        EXIT_APPLICATION
    }

    public enum FileManipulationOption{
        CREATE_FILE,
        DELETE_FILE,
        SEARCH_FILE,
        BACK_TO_MAIN_CONTEXT
    }

    public static HashMap<Integer, MainContextOption> mainContextOptionHashMap;
    public static HashMap<Integer, FileManipulationOption> fileManipulationOptionHashMap;

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

    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }

}
