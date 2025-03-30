package net.druidlabs.ajse.writers;

import net.druidlabs.ajse.readers.ReadAFile;

import java.io.*;

public final class WriteAFile {

    private static boolean operationFeedbackEnabled = true;

    private WriteAFile() {
    }

    public static synchronized void toggleOperationFeedback(boolean feedbackEnabled) {
        if (feedbackEnabled != operationFeedbackEnabled) {
            operationFeedbackEnabled = feedbackEnabled;
        }
    }

    public static boolean createFile(String filePath, String fileName) throws IOException {
        return new File(filePath + File.separator + fileName).createNewFile();
    }

    public static void overwriteFIle(String filePath, String fileName, String whatToWrite) throws IOException {
        if (createFile(filePath, fileName)) {
            if (operationFeedbackEnabled) {
                System.out.println("Successfully created file");
            }

            overwriteFIle(filePath, fileName, whatToWrite);
        }

        File fileToBeWritten = new File(filePath + File.separator + fileName);

        write(fileToBeWritten, whatToWrite);
    }

    public static void addToFile(String filePath, String fileName, String whatToAdd) throws IOException {
        File fileToAddTo = new File(filePath + File.separator + fileName);

        String existingData = ReadAFile.readThisFile(filePath, fileName);

        write(fileToAddTo, existingData, whatToAdd);
    }

    private static void write(File fileToBeWritten, String... whatToWrite) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileToBeWritten);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (String toWrite : whatToWrite) {
                writer.write(toWrite + "\n");
            }

            if (operationFeedbackEnabled) {
                System.out.println("Successfully wrote to file");
            }
        }
    }

}
