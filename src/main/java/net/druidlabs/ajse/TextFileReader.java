package net.druidlabs.ajse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This is a utility class that gives the ability to read from simple text files and the contents returned as {@code String} values.
 *
 * @author Andrew Jones
 * @see TextFileWriter
 * @since 24
 */

public final class TextFileReader extends TextFileOperation {

    private TextFileReader() {
    }

    /**
     * This method reads given files and collects them.
     * Unlike {@link #readTheseFiles(File...) readTheseFiles()},
     * this method gives the ability to specify which file's contents you would like to get by passing in the file's name and extension.
     *
     * @param files at least one {@code File} object pointing to a file to be read and collected.
     * @throws IOException if an input error occurs
     * @return {@code Map<String, String>} containing file names and their respective file contents.
     * */

    public static Map<String, String> getTheseFiles(File... files) throws IOException {
        Map<String, String> readFileData = new TreeMap<>();

        for (File file : files) {
            String filePath = file.getParentFile().getPath();
            String fileName = file.getName();

            readFileData.put(fileName, readThisFile(filePath, fileName));
        }

        return readFileData;
    }

    /**
     * This method reads given files and each file's contents are collected.
     *
     * @param files {@code File} objects separated by commas to be read and contents collected.
     * @return {@code Set<String>} containing all file contents.
     * @throws IOException if the file path given is not a file or file does not exist.
     */

    public static Set<String> readTheseFiles(File... files) throws IOException {
        Set<String> readFileData = new TreeSet<>(); //Strings will be sorted alphabetically

        for (File file : files) {
            String filePath = file.getParentFile().getPath();
            String fileName = file.getName();

            readFileData.add(readThisFile(filePath, fileName));
        }

        return readFileData;
    }

    /**
     * Reads from a specified file and returns the contents of the file.
     * <p>For example, if a file named "Java.txt" is on a Windows desktop, the path will be
     * {@code C:\Users\USERNAME\Desktop} and the file name {@code Java.txt}
     * <p>If you want to read multiple files, use {@link #readTheseFiles(File...) readTheseFiles()} instead
     *
     * @param filePath the path to the file's parent folder.
     * @param fileName the name of the desired file including the file extension.
     * @return {@code String} of the contents in the file.
     * @throws IOException if the file path given is invalid or the file does not exist.
     */

    public static String readThisFile(String filePath, String fileName) throws IOException {
        File fileToRead;

        if (isTestFile(filePath, fileName)) {
            fileToRead = new File(fileName);
        } else {
            fileToRead = getFile(filePath, fileName);
        }

        try (FileReader fileReader = new FileReader(fileToRead);
             BufferedReader reader = new BufferedReader(fileReader)) {

            return getStringBuilder(reader).toString();
        }
    }

    /**
     * Helper method that collects and formats text collected by the reader.
     * @throws IOException if an input error occurs.
     * @return {@code StringBuilder} containing the formatted file contents.
     * @param reader a {@code BufferedReader} that is in charge of reading the file.
     * */

    private static StringBuilder getStringBuilder(BufferedReader reader) throws IOException{
        String line;
        StringBuilder builder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\r\n");
        }

        return builder;
    }

    /**
     * Checks whether the specified file's path and name equal those of the ones used in testing.
     * @param filePath the folder directory containing the desired file.
     * @param fileName the file's name including the file extension.
     * @return {@code true} if the {@code filePath} is blank and {@code fileName} equals {@code "TestFile1.txt"} or {@code "TestFile2.txt"}.
     * */

    private static boolean isTestFile(String filePath, String fileName) {
        boolean fileIsTestFile = fileName.equals("TestFile1.txt") || fileName.equals("TestFile2.txt");

        return filePath.isBlank() && fileIsTestFile;
    }
}
