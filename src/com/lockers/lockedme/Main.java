package com.lockers.lockedme;

import com.lockers.lockedme.util.Constants;
import com.lockers.lockedme.util.Util;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Util.displayMessage(Constants.USER_WELCOME_MESSAGE);
        Util.displayMessage(Constants.LOCKED_ME_DETAILS);
        getUserDetails();
        askUserForInput();

    }

    private static void askUserForInput()
    {
        Util.displayMessage(Constants.OPTION_MENU);

        for(String option: Constants.OPTIONS)
        {
            Util.displayMessage(option);
        }

        try
        {
            int option = Util.getIntegerUserInput(Constants.OPTION_SELECT_MESSAGE);

            if(option<=0 || option > Constants.OPTIONS.length)
            {
                throw new Exception(Constants.INVALID_INPUT);
            }

            performAction(option);

        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
            askUserForInput();
        }

    }

    private static void performAction(int option)
    {
        switch (option)
        {
            case 1: displayFilesAndFolders();
                    break;

            case 2: performFileOperation();
                    break;
            case 3: shutdownApplication();
                    break;
            default:Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
                    askUserForInput();
                    break;
        }
        askUserForInput();
    }

    private static void performFileOperation()
    {
        for(String option: Constants.FILE_OPTIONS)
        {
            Util.displayMessage(option);
        }

        try
        {
            int option = Util.getIntegerUserInput(Constants.OPTION_SELECT_MESSAGE);

            if(option<=0 || option > Constants.OPTIONS.length)
            {
                throw new Exception(Constants.INVALID_INPUT);
            }

            performFileAction(option);

        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
            askUserForInput();
        }
    }

    private static void performFileAction(int action)
    {

    }


    private static void shutdownApplication()
    {
        Util.displayMessage(Constants.EXIT_MESSAGE);
        System.exit(0);
    }

    private static void displayFilesAndFolders()
    {

        File directoryPath = new File(navigateToWorkingDirectory());
        String contents[] = directoryPath.list();

        if(contents==null)
        {
            Util.displayMessage(Constants.INVALID_INPUT+" , you entered invalid path");
        }
        else if(contents.length==0)
        {
            Util.displayMessage(Constants.EMPTY_DIRECTORY);
        }
        else
        {
            Util.displayMessage(Constants.DISPLAY_MESSAGE);

            Arrays.sort(contents);

            for(int i=0; i<contents.length; i++) {
                Util.displayMessage(contents[i]);
            }
        }
        Util.displayMessage("\n");
    }

    private static String navigateToWorkingDirectory()
    {
        try
        {
            String workingDirectory = Util.getStringUserInput(Constants.ASK_WORKING_DIRECTORY+", ex:-"+System.getProperty("user.dir"));
            return workingDirectory.isEmpty()? System.getProperty("user.dir"): workingDirectory;
        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.SERVER_ERROR);
            return navigateToWorkingDirectory();
        }

    }



    public static void getUserDetails()
    {
        try
        {
            String username = Util.getStringUserInput(Constants.QUESTION_USER_NAME);

            if(Util.isStringOnlyAlphabet(username))
            {
                displayUserInformation(username);
            }
            else
            {
                Util.displayMessage(Constants.INVALID_INPUT + ", name should only contain alphabets");
                getUserDetails();
            }
        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.SERVER_ERROR);
            getUserDetails();
        }

    }

    private static void displayUserInformation(String username)
    {
        StringBuilder userInformation = new StringBuilder();
        userInformation.append("Hi , ").append(username);
        Util.displayMessage(userInformation.toString());
    }

}
