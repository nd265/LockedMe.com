package com.lockers.lockedme;

import com.lockers.lockedme.util.Constants;
import com.lockers.lockedme.util.Util;

public class Main {

    public static void main(String[] args) {

        Util.displayMessage(Constants.USER_WELCOME_MESSAGE);
        Util.displayMessage(Constants.LOCKED_ME_DETAILS);
        getUserDetails();
        Util.displayMessage(Constants.OPTION_MENU);

    }

    public static void getUserDetails()
    {
        try
        {
            String username = Util.getStringUserInput(Constants.QUESTION_USER_NAME);
            displayUserInformation(username);
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
