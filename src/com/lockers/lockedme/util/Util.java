package com.lockers.lockedme.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public abstract class Util {

    // Maps 1,2,3 to Code readable enum
    public enum MainContextOption{
        DISPLAY_FILES_AND_FOLDERS,
        FILE_MANIPULATION,
        EXIT_APPLICATION
    }
    // Maps 1,2,3 to Code readable enum
    public enum FileManipulationOption{
        CREATE_FILE,
        DELETE_FILE,
        SEARCH_FILE,
        BACK_TO_MAIN_CONTEXT
    }

    // Map containing mapping of 1,2,3 to enum value
    public static HashMap<Integer, MainContextOption> mainContextOptionHashMap;
    // Map containing mapping of 1,2,3 to enum value
    public static HashMap<Integer, FileManipulationOption> fileManipulationOptionHashMap;

    // Gets integer input from user
    public static int getIntegerUserInput(String message) throws IOException {
        return Integer.parseInt(getUserInput(message));
    }

    // Gets string input from user
    public static String getStringUserInput(String message) throws IOException {
        return getUserInput(message);
    }

    // wrapper function to get user input in string format
    private static String getUserInput(String message) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        displayMessage(message);
        return bufferedReader.readLine();
    }

    // Utility function to display message
    public static void displayMessage(String message)
    {
        System.out.println(message);
    }

    // regex to check the user name contains only alphabet
    public static boolean isStringOnlyAlphabet(String str)
    {
        return ((!str.equals(""))
                && (str != null)
                && (str.matches("^[a-zA-Z]*$")));
    }

}
