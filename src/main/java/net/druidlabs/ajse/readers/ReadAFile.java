package net.druidlabs.ajse.readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * This is a utility class that gives the ability to read from simple text files and the contents returned as {@code String} values.
 *
 * @author Andrew Jones
 * @since 24
 */

public final class ReadAFile {

    private ReadAFile() {
    }

    /**
     * This method reads given files and each file's contents are collected.
     *
     * @param files {@code File} objects separated by commas to be read and contents collected.
     * @return {@code Set<String>} containing all file contents.
     * @throws IOException if the file path given is not a file or file does not exist.
     */

    public static Set<String> readTheseFiles(File... files) throws IOException {
        Set<String> strings = new TreeSet<>();

        for (File file : files) {
            String filePath = file.getParentFile().getPath();
            String fileName = file.getName();


            strings.add(readThisFile(filePath, fileName));
        }

        return strings;
    }

    /**
     * Reads from a specified file and returns the contents of the file.
     * <p>For example, if a file named "Java.txt" is on a Windows desktop, the path will be
     * {@systemProperty C:\Users\USERNAME\Desktop} and the file name {@systemProperty Java.txt}
     * <p>If you want to read multiple files, use {@link #readTheseFiles(File...) readTheseFiles()} instead
     *
     * @param filePath the path to the file's parent folder.
     * @param fileName the name of the desired file including the file extension.
     * @return {@code String} of the contents in the file.
     * @throws IOException if the file path given is invalid or the file does not exist.
     */

    public static String readThisFile(String filePath, String fileName) throws IOException {
        File fileToRead = new File(filePath + File.separator + fileName);

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
            builder.append(line).append("\n");
        }

        return builder;
    }

}
