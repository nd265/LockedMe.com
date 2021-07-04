package com.lockers.lockedme;

import com.lockers.lockedme.util.Constants;
import com.lockers.lockedme.util.Util;

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

                    

            default:Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
                    askUserForInput();
                    break;

        }
    }

    private static void displayFilesAndFolders()
    {

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
