package net.druidlabs.ajse;

import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * This class houses methods that are used in File I/O operations.
 *
 * @author Andrew Jones
 * @version 1.0
 * @see TextFileReader
 * @see TextFileWriter
 * @since 0.1
 */

abstract class TextFileOperation {

    /**
     * This method checks to see if the file path specified is a valid path and is correctly separated by the correct separator.
     *
     * @param folderPath path to the folder containing the file.
     * @param fileName   the name of the file including the file extension.
     * @return {@code File} with the separator between the file path and the file name.
     * @since 0.1
     */

    protected static File getFile(@NotNull String folderPath, @NotNull String fileName) {
        if (folderPath.endsWith(File.separator)) {
            return new File(folderPath + fileName);
        } else {
            return new File(folderPath + File.separator + fileName);
        }
    }

    /**
     * Checks whether the specified file's path and name equal those of the ones used in testing.
     *
     * @param filePath the folder directory containing the desired file.
     * @param fileName the file's name including the file extension.
     * @return {@code true} if the {@code filePath} is blank and {@code fileName} equals {@code "TestFile1.txt"} or {@code "TestFile2.txt"}.
     * @since 0.1
     */

    protected static boolean isTestFile(String filePath, String fileName) {
        boolean fileIsTestFile = fileName.equals("TestFile1.txt") || fileName.equals("TestFile2.txt");

        return filePath.isBlank() && fileIsTestFile;
    }

}
