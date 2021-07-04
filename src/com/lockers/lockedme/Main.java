package com.lockers.lockedme;

import com.lockers.lockedme.util.Constants;
import com.lockers.lockedme.util.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Util.displayMessage(Constants.TASK_EXECUTION_OVER);
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

            if(option<=0 || option > Constants.FILE_OPTIONS.length)
            {
                throw new Exception(Constants.INVALID_INPUT);
            }
            else if(option==Constants.FILE_OPTIONS.length)
            {
                askUserForInput();
            }
            else
                performFileAction(option);

        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
            performFileOperation();
        }
    }

    private static void performFileAction(int action)
    {


        File directoryPath = new File(navigateToWorkingDirectory());
        String contents[] = directoryPath.list();

        if(contents==null)
        {
            Util.displayMessage(Constants.INVALID_INPUT+" , you entered an invalid path");
            performFileAction(action);
        }
        else
        {
            switch (action)
            {
                case 1: createNewFile(directoryPath);
                        break;
                case 2: deleteFileFromDirectory(directoryPath);
                        break;
                case 3: searchForFileName(directoryPath);
                        break;
                default: Util.displayMessage(Constants.INVALID_INPUT);
                        break;
            }

        }

    }

    private static void createNewFile(File directory) {
        String filename = getFileName();

        try {

           if(!new File(directory.getAbsolutePath(),filename).createNewFile())
           {
               throw new Exception("Duplicate resource");
           }
           else
               Util.displayMessage(Constants.FILE_CREATED);
        }
        catch (IOException e)
        {
            Util.displayMessage(Constants.ACCESS_DENIED_EXCEPTION);
        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.SERVER_ERROR+" , unable to create file make sure file doesn't exist");
        }

    }

    private static void deleteFileFromDirectory(File directory)
    {

        String filename = getFileName();
        try {

            if(!new File(directory.getAbsolutePath(),filename).delete())
            {
                Util.displayMessage(Constants.FILE_NOT_FOUND);
            }
            else
                Util.displayMessage(Constants.FILE_DELETED);
        } catch (Exception e)
        {
            Util.displayMessage(Constants.SERVER_ERROR);
        }
    }

    private static void searchForFileName(File directory)
    {
        String filename = getFileName();

        File[] contents = directory.listFiles();

        List<String> macthingFiles = new ArrayList<>();

        for(File file : contents)
        {
            if(file.isFile() && file.getName().startsWith(filename))
            {
                macthingFiles.add(file.getName());
            }
        }

        Util.displayMessage(Constants.DISPLAY_FILE_LIST_MESSAGE);

        for(String file: macthingFiles)
        {
            Util.displayMessage(file);
        }

    }

    private static String getFileName()
    {
        try {
            return Util.getStringUserInput(Constants.ASK_FILENAME);
        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.SERVER_ERROR);
            return getFileName();
        }
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
            Util.displayMessage(Constants.INVALID_INPUT+" , you entered an invalid path");
            askForRetryPathName();
        }
        else if(contents.length==0)
        {
            Util.displayMessage(Constants.EMPTY_DIRECTORY);
        }
        else
        {
            Util.displayMessage(Constants.DISPLAY_LIST_MESSAGE);

            Arrays.sort(contents);

            for(int i=0; i<contents.length; i++) {
                Util.displayMessage(contents[i]);
            }
        }
        Util.displayMessage("\n");
    }

    private static void askForRetryPathName()
    {
        try {

            String option = Util.getStringUserInput(Constants.ASK_RETRY_FOLDER);

            if(option.equals("y")||option.equals("Y"))
            {
                displayFilesAndFolders();
            }

        }
        catch (Exception e)
        {
            askForRetryPathName();
        }


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
