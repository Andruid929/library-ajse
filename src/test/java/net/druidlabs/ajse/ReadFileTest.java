package net.druidlabs.ajse;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the {@link ReadFile} class
 *
 * @version 1.0
 * @since 1.0
 * @author Andrew Jones
 */

class ReadFileTest {

    private final ReadFile readFile = ReadFile.getThisFile(" ", "TestFile1.txt");

    ReadFileTest() throws IOException {
    }

    /**
     * Testing {@code ReadFile#getFileName}
     */

    @Test
    void getFileName() {
        assertEquals("TestFile1.txt", readFile.getFileName());
    }

    /**
     * Testing {@code ReadFile#getFilepath}
     */

    @Test
    void getFilePath() {
        assertEquals(" ", readFile.getFilePath());
    }

    /**
     * Testing {@code ReadFile#getFileName}
     */

    @Test
    void getFileContents() {
        assertEquals("This is the first test file\r\n", readFile.getContents());
    }

}