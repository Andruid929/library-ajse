package net.druidlabs.ajse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class is designed to provide a way to read a file, and instead
 * of the contents being given as a single line,
 * each line is its own String.
 *
 * @author Andrew Jones
 * @version 1.0
 * @see TextFileReader
 * @see ReadFile
 * @since 1.1
 */

public final class FileLineCollector extends TextFileOperation {

    private FileLineCollector() {
    }

    /**
     * Get an unsorted {@code Set<String>} containing all available lines in the file.
     *
     * @param folderPath location of the file to be read.
     * @param fileName   name of the file to be read and the file extension.
     * @return {@code HashSet} of strings where each element is a random line from the file.
     * @throws IOException if any input error occurs.
     */

    public static Set<String> collectUnsortedLines(String folderPath, String fileName) throws IOException {
        File file;

        if (isTestFile(folderPath, fileName)) {
            file = new File(fileName);
        } else {
            file = getFile(folderPath, fileName);
        }

        Set<String> lines = new HashSet<>();

        populateCollection(lines, file);

        return lines;
    }

    /**
     * Get an unsorted {@code List<String>} containing all available lines in the file.
     *
     * @param folderPath location of the file to be read.
     * @param fileName   name of the file to be read and the file extension.
     * @return {@code ArrayList} of strings where each element is a random line from the file.
     * @throws IOException if any input error occurs.
     */

    public static List<String> collectSortedLines(String folderPath, String fileName) throws IOException {
        File file;

        if (isTestFile(folderPath, fileName)) {
            file = new File(fileName);
        } else {
            file = getFile(folderPath, fileName);
        }

        List<String> lines = new ArrayList<>();

        populateCollection(lines, file);

        return lines;
    }

    public static Collection<String> collectLines(String folderPath, String fileName, Collection<String> linesCollector) throws IOException {
        File file;

        if (isTestFile(folderPath, fileName)) {
            file = new File(fileName);
        } else {
            file = getFile(folderPath, fileName);
        }

        populateCollection(linesCollector, file);

        return linesCollector;
    }

    /**
     * Populate the given collections with the lines in the file.
     *
     * @param linesCollection any collection object, for example, {@code List}, {@code Set}, {@code Queue}.
     * @param file            file object to be read.
     * @throws IOException if any input error occurs.
     */

    static void populateCollection(Collection<String> linesCollection, File file) throws IOException {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;

            while ((line = reader.readLine()) != null) {
                linesCollection.add(line);
            }
        }
    }

}
