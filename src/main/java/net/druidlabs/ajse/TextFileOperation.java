package net.druidlabs.ajse;

import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * This class houses methods that are used in File I/O operations.
 *
 * @since 24
 * @see TextFileReader
 * @see TextFileWriter
 * @author Andrew Jones
 * */

abstract class TextFileOperation {

    /**
     * This method checks to see if the file path specified is a valid path and is correctly separated by the correct separator.
     * @return {@code File} with the separator between the file path and the file name.
     * @param folderPath path to the folder containing the file.
     * @param fileName the name of the file including the file extension.
     * */

    protected static File getFile(@NotNull String folderPath,@NotNull String fileName) {
        if (folderPath.endsWith(File.separator)) {
            return new File(folderPath + fileName);
        } else {
            return new File(folderPath + File.separator + fileName);
        }
    }

}
