package net.druidlabs.ajse;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

/**
 * Class that converts a file into an object containing the file's name, file extension, and file contents.
 * Objects can only be created from calling the static {@link #getFile(String, String)}
 *
 * @version 1.0
 * @since 1.0
 * @author Andrew Jones
 */

public class ReadFile extends TextFileOperation {

    private final String fileName;
    private final String contents;
    private final String filePath;

    private ReadFile(String filePath, String fileName) throws IOException {
        this.fileName = fileName;
        this.filePath = filePath;

        contents = TextFileReader.readThisFile(filePath, fileName);
    }

    /**
     * Get the contents of the file read.
     *
     * @return {@code String} of the file contents
     * @since 1.0
     */

    public String getContents() {
        return contents;
    }

    /**
     * Get the name of the file read.
     *
     * @return {@code String} of the file name
     * @since 1.0
     */

    public String getFileName() {
        return fileName;
    }

    /**
     * Get the path of the file read.
     *
     * @return {@code String} of the file's location
     * @since 1.0
     */

    public String getFilePath() {
        return filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReadFile readFile = (ReadFile) o;
        return Objects.equals(fileName, readFile.fileName) && Objects.equals(contents, readFile.contents) && Objects.equals(filePath, readFile.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, contents, filePath);
    }

    /**
     * Create an instance of this class.
     *
     * @return {@code ReadFile} object containing the data of the file passed in.
     * @throws IOException if any input error occurs.
     * @param fileName the name of the file including the file extension.
     * @param filePath the location of the file.
     * @since 1.0
     */

    @Contract(pure = true)
    @NotNull
    public static ReadFile getThisFile(String filePath, String fileName) throws IOException {
        return new ReadFile(filePath, fileName);
    }

}
