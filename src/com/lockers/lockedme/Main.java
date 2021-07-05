package com.lockers.lockedme;

import com.lockers.lockedme.util.Constants;
import com.lockers.lockedme.util.Util;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        // Create the enum maps to map user input to appropriate enum
        createUserInputEnumMapping();
        // Greet the user !
        Util.displayMessage(Constants.USER_WELCOME_MESSAGE);
        // Display application details
        Util.displayMessage(Constants.LOCKED_ME_DETAILS);
        // Get the user name might be redundant
        getUserDetails();
        // Provide options to the user to use the application
        askUserForInput();

    }

    // Created a mapping to map numbers to human readable enum for better code understanding
    private static void createUserInputEnumMapping()
    {
        Util.mainContextOptionHashMap = new HashMap<>();
        Util.fileManipulationOptionHashMap = new HashMap<>();

        Util.mainContextOptionHashMap.put(1, Util.MainContextOption.DISPLAY_FILES_AND_FOLDERS);
        Util.mainContextOptionHashMap.put(2, Util.MainContextOption.FILE_MANIPULATION);
        Util.mainContextOptionHashMap.put(3, Util.MainContextOption.EXIT_APPLICATION);

        Util.fileManipulationOptionHashMap.put(1, Util.FileManipulationOption.CREATE_FILE);
        Util.fileManipulationOptionHashMap.put(2, Util.FileManipulationOption.DELETE_FILE);
        Util.fileManipulationOptionHashMap.put(3, Util.FileManipulationOption.SEARCH_FILE);
        Util.fileManipulationOptionHashMap.put(4, Util.FileManipulationOption.BACK_TO_MAIN_CONTEXT);

    }

    // Show th context menu to the user
    private static void askUserForInput()
    {

        Util.displayMessage(Constants.OPTION_MENU);

        // Populate all the options in command line
        for(String option: Constants.OPTIONS)
        {
            Util.displayMessage(option);
        }

        try
        {
            int option = Util.getIntegerUserInput(Constants.OPTION_SELECT_MESSAGE);

            // throw exception if invalid input
            if(option<=0 || option > Constants.OPTIONS.length)
            {
                throw new Exception(Constants.INVALID_INPUT);
            }
            // Get the corresponding enum and perform the action
            performAction(Util.mainContextOptionHashMap.get(option));

        }
        catch (Exception e)
        {
            // If user inputs invalid Integer option
            Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
            askUserForInput();
        }

    }

    // Performs the operation based on the option selected in the context menu
    private static void performAction(Util.MainContextOption option)
    {
        switch (option)
        {
            case DISPLAY_FILES_AND_FOLDERS: displayFilesAndFolders();
                    break;
            case FILE_MANIPULATION: performFileOperation();
                    break;
            case EXIT_APPLICATION: shutdownApplication();
                    break;
            default:Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
                    askUserForInput();
                    break;
        }
        Util.displayMessage(Constants.TASK_EXECUTION_OVER);
        // Instead of exiting the application we ask user if we want to continue using the application
        askUserForInput();
    }

    private static void performFileOperation()
    {
        // Display all file related operations
        for(String option: Constants.FILE_OPTIONS)
        {
            Util.displayMessage(option);
        }

        try
        {
            int option = Util.getIntegerUserInput(Constants.OPTION_SELECT_MESSAGE);

            // Throw exception if invalid integer input
            if(option<=0 || option > Constants.FILE_OPTIONS.length)
            {
                throw new Exception(Constants.INVALID_INPUT);
            }
            // Special case where we don't require the working directory and user just wants to go back to main context
            else if(Util.fileManipulationOptionHashMap.get(option)==Util.FileManipulationOption.BACK_TO_MAIN_CONTEXT)
            {
                askUserForInput();
            }
            // Any valid option perform the corresponding file manipulation action
            else
                performFileAction(Util.fileManipulationOptionHashMap.get(option));

        }
        catch (Exception e)
        {
            // Handles invalid user option selected
            Util.displayMessage(Constants.INVALID_INPUT+", select a valid option");
            performFileOperation();
        }
    }

    private static void performFileAction(Util.FileManipulationOption action)
    {
        // Gets the root directory from the user if left blank assumes the current working directory
        File directoryPath = new File(getRootDirectory());
        String contents[] = directoryPath.list();

        // Check to ensure that the path entered is indeed valid
        if(contents==null)
        {
            Util.displayMessage(Constants.INVALID_INPUT+" , you entered an invalid path");
            performFileAction(action);
        }
        else
        {
            // All good and based on the action the functions are invoked
            switch (action)
            {
                case CREATE_FILE: createNewFile(directoryPath);
                        break;
                case DELETE_FILE: deleteFileFromDirectory(directoryPath);
                        break;
                case SEARCH_FILE: searchForFileName(directoryPath);
                        break;
                default: Util.displayMessage(Constants.INVALID_INPUT);
                        break;
            }

        }

    }

    // Creates a new file in the directory provided by the user with the name they input
    private static void createNewFile(File directory) {

        // Get the file name
        String filename = getFileName();
        try {
           // Create the file object and tries to create if success returns true if failed file name might already exist
           if(!new File(directory.getAbsolutePath(),filename).createNewFile())
           {
               throw new Exception("Duplicate resource");
           }
           else
               Util.displayMessage(Constants.FILE_CREATED);
        }
        // If file creation is not allowed to normal user we need to run the program in admin mode
        catch (IOException e)
        {
            Util.displayMessage(Constants.ACCESS_DENIED_EXCEPTION);
        }
        // Any other exception is handled here
        catch (Exception e)
        {
            Util.displayMessage(Constants.SERVER_ERROR+" , unable to create file make sure file doesn't exist");
        }

    }

    // Deletes the files in the directory provided matching the file name they input
    private static void deleteFileFromDirectory(File directory)
    {
        // Gets the file name to be deleted
        String filename = getFileName();
        try {
            // We delete the file only if it's a exact match we might have files with same name and diff extension
            if(!new File(directory.getAbsolutePath(),filename).delete())
            {
                // If delete operation is unsuccessful the file might not be present and we notify the user in that case
                Util.displayMessage(Constants.FILE_NOT_FOUND);
            }
            // Successful operation
            else
                Util.displayMessage(Constants.FILE_DELETED);
        } catch (Exception e)
        {
            // Any other issues that might occur during the deletion event
            Util.displayMessage(Constants.SERVER_ERROR);
        }
    }

    // Search for a file name in the directory provided by the user . The user might not remember the
    // exact file name and so we show all the file names with the prefix that user provides
    private static void searchForFileName(File directory)
    {
        String filename = getFileName();

        File[] contents = directory.listFiles();

        List<String> macthingFiles = new ArrayList<>();

        for(File file : contents)
        {
            // Since we want to show only the files and not the directories which start with the name user provides
            // Linear search
            if(file.isFile() && file.getName().startsWith(filename))
            {
                macthingFiles.add(file.getName());
            }
        }

        if(macthingFiles.isEmpty())
        {
            Util.displayMessage(Constants.EMPTY_MATCH_LIST);
            return;
        }


        Util.displayMessage(Constants.DISPLAY_FILE_LIST_MESSAGE);
        // We want to display the files in the ascending order
        Collections.sort(macthingFiles);
        // Display all the files one by one
        for(String file: macthingFiles)
        {
            Util.displayMessage(file);
        }

    }

    // Helper function to ask user for the file name
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

    // Shuts the program with exit code 0 meaning normal termination
    private static void shutdownApplication()
    {
        Util.displayMessage(Constants.EXIT_MESSAGE);
        System.exit(0);
    }

    // Takes the working directory and displays everything inside that folder in ascending order
    private static void displayFilesAndFolders()
    {

        File directoryPath = new File(getRootDirectory());
        String contents[] = directoryPath.list();

        // If path is invalid user must have made a typo and we want to ask if they want to retry ,
        // if no retry we send them back to main context
        if(contents==null)
        {
            Util.displayMessage(Constants.INVALID_INPUT+" , you entered an invalid path");
            askForRetryPathName();
        }
        // If the directory is empty we simply inform the user of the same
        else if(contents.length==0)
        {
            Util.displayMessage(Constants.EMPTY_DIRECTORY);
        }
        else
        {
            Util.displayMessage(Constants.DISPLAY_LIST_MESSAGE);
            // We sort the files and directories according to their name and display them
            Arrays.sort(contents);

            for(int i=0; i<contents.length; i++) {
                Util.displayMessage(contents[i]);
            }
        }
        Util.displayMessage("\n");
    }

    // Retry to check if user wants to retry the input again
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
            // Recursion we basically want to ask the user again shouldn't be an issue
            askForRetryPathName();
        }


    }

    // Gets the root directory where the user wants to perform their operation by default returns current working dir
    private static String getRootDirectory()
    {
        try
        {
            String workingDirectory = Util.getStringUserInput(Constants.ASK_WORKING_DIRECTORY+", ex:-"+System.getProperty("user.dir"));
            return workingDirectory.isEmpty()? System.getProperty("user.dir"): workingDirectory;
        }
        catch (Exception e)
        {
            Util.displayMessage(Constants.SERVER_ERROR);
            return getRootDirectory();
        }

    }

    // Gets user input and greets them . Can we worked upon or removed
    public static void getUserDetails()
    {
        try
        {
            String username = Util.getStringUserInput(Constants.QUESTION_USER_NAME);

            // Perform a check on the input user based on regex since names can have only alphabets
            if(Util.isStringOnlyAlphabet(username))
            {
                displayUserInformation(username);
            }
            // Invalid user input and ask them again
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

    // Greets the user !
    private static void displayUserInformation(String username)
    {
        StringBuilder userInformation = new StringBuilder();
        userInformation.append("Hi , ").append(username);
        Util.displayMessage(userInformation.toString());
    }

}
