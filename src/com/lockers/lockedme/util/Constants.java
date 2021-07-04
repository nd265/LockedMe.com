package com.lockers.lockedme.util;

public abstract class Constants {
    
    public static final String USER_WELCOME_MESSAGE  = "Hi, \nWelcome to LockedMe.com";
    public static final String LOCKED_ME_DETAILS = "For queries reach out to Navya_Dahiya@dell.com";
    public static final String OPTION_MENU= "Here are couple of things you can do";
    public static final String QUESTION_USER_NAME="How should I address you ?";
    public static final String INVALID_INPUT="Sorry the input you entered is invalid";
    public static final String SERVER_ERROR="Error processing input , please try again";

    public static final String ASK_WORKING_DIRECTORY="Please enter path of the directory, leave blank for current";
    public static final String ASK_RETRY_FOLDER ="Do you want to retry the path ? (y/n)";
    public static final String EMPTY_DIRECTORY ="Empty directory ";
    public static final String DISPLAY_LIST_MESSAGE = "List of files and directories in the specified directory:";
    public static final String DISPLAY_FILE_LIST_MESSAGE = "List of files  in the specified directory:";

    public static final String EXIT_MESSAGE="Exiting application..";
    public static final String[] OPTIONS = new String[]{
            "1. Get all the files in folder",
            "2. Perform file operations",
            "3. Exit"};

    public static final String[] FILE_OPTIONS = new String[]{
            "1. Add files to directory",
            "2. Delete file from directory",
            "3. Search for file",
            "4. Move back to context menu"};

    public static final String ASK_FILENAME="Enter the filename";
    public static final String ACCESS_DENIED_EXCEPTION="Access is denies please run in admin mode";
    public static final String FILE_NOT_FOUND="File not found";
    public static final String FILE_CREATED="File created";
    public static final String FILE_DELETED="File deleted";

    public static final String TASK_EXECUTION_OVER="Task execution over";
    public static final String OPTION_SELECT_MESSAGE= "Please select the number corresponding to the action you want  to perform";
}
