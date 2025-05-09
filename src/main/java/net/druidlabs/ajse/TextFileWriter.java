package net.druidlabs.ajse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class that contains methods for writing simple text data to created or existing files.
 *
 * @author Andrew Jones
 * @version 1.0
 * @see TextFileReader
 * @since 0.1
 */

public final class TextFileWriter extends TextFileOperation {

    /**
     * {@code true} by default, there will be notifications in the terminal if a file operation was successful.
     *
     * @since 0.1
     */
    private static boolean operationFeedbackEnabled = true;

    /**
     * Class cannot be instantiated.
     */
    private TextFileWriter() {
    }

    /**
     * This method is there to change whether the operation feedback in the terminal is enabled or not.
     *
     * @param feedbackEnabled is operation feedback enabled? {@code true} for enabled and {@code false} for disabled.
     * @since 0.1
     */

    public static synchronized void toggleOperationFeedback(boolean feedbackEnabled) {
        if (feedbackEnabled != operationFeedbackEnabled) {
            operationFeedbackEnabled = feedbackEnabled;
        }
    }

    /**
     * Creates a simple file with a specified file extension but will be readable by any type of file editor with ease.
     *
     * @param filePath the folder path to which the file will be created. The folder must exist or else problems arise.
     * @param fileName the file name to be created as well its file extension. For example, {@code "Java.txt"}.
     * @return {@code true} if the file was created successfully or {@code false} if the file already exists.
     * @throws IOException if any output error occurs.
     * @since 0.1
     */

    public static synchronized boolean createFile(String filePath, String fileName) throws IOException {
        return getFile(filePath, fileName).createNewFile();
    }

    /**
     * This method attempts to write to a specified file if it exists, and if not,
     * it will attempt to create the file first.
     * Any existing data in the file will be overwritten and be lost forever.
     * <p>
     * If you would like to write to the file and maintain the existing contents,
     * use {@link #addToFile(String, String, String) addToFile()} instead
     *
     * @param filePath    the folder to which the desired file is or is to be created.
     * @param fileName    the file which is to be overwritten or to be created.
     * @param whatToWrite what the program should write to the file.
     * @throws IOException if any output error occurs.
     * @since 0.1
     */

    public static synchronized void overwriteFile(String filePath, String fileName, String whatToWrite) throws IOException {

        File fileToBeWritten = getFile(filePath, fileName);

        if (!fileToBeWritten.exists()) {
            boolean _ = createFile(filePath, fileName);

            if (operationFeedbackEnabled) {
                System.out.println("Created file \"" + fileName + "\" in \"" + filePath + "\"");
            }
        }

        write(fileToBeWritten, whatToWrite);
    }

    /**
     * This method attempts to add to an existing file which means contents will not be lost.
     * If you want to overwrite the file instead, use {@link #overwriteFile(String, String, String) overwriteFile()}.
     *
     * @param filePath  the folder to which the desired file is located.
     * @param fileName  the file which is to be modified.
     * @param whatToAdd what the program should add to the file.
     * @throws IOException if any output error occurs.
     * @since 0.1
     */

    public static synchronized void addToFile(String filePath, String fileName, String whatToAdd) throws IOException {
        File fileToAddTo = getFile(filePath, fileName);

        String existingData = TextFileReader.readThisFile(filePath, fileName);

        write(fileToAddTo, existingData, whatToAdd);
    }

    /**
     * Method responsible for doing all the writing to the files.
     *
     * @param fileToBeWritten the file to which all the writing shall happen.
     * @param whatToWrite     data to be written to the file, can be multiple {@code String} objects.
     * @throws IOException if any output error should occur.
     * @since 0.1
     */

    private static synchronized void write(File fileToBeWritten, String... whatToWrite) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileToBeWritten);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (String toWrite : whatToWrite) {
                writer.write(toWrite);
            }

            if (operationFeedbackEnabled) {
                System.out.println("Successfully wrote to file");
            }
        }
    }

}
