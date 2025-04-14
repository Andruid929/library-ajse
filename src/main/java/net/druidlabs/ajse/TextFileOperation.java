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

}
