package net.druidlabs.ajse;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TextFileReaderTest {

    /**
     * Test for the {@code TextFileReader.readThisFile()}
     */

    @Test
    void readThisFile() throws IOException {
        String readContents = TextFileReader.readThisFile("", "TestFile2.txt");

        assertEquals("I am the", readContents.substring(0, 8));
    }

    /**
     * Test for the {@code TextFileReader.readTheseFiles()}
     */

    @Test
    void readTheseFiles() throws IOException {
        File file1 = new File(" \\TestFile1.txt");
        File file2 = new File(" \\TestFile2.txt");

        assertEquals("I am the", TextFileReader.readTheseFiles(file1, file2).stream().toList().getFirst().substring(0, 8));
    }

    /**
     * Second test for the {@code TextFileReader.readTheseFiles()}
     */

    @Test
    void readTheseFilesTestTwo() throws IOException {
        File file1 = new File(" \\TestFile1.txt");
        File file2 = new File(" \\TestFile2.txt");

        assertEquals("This is ", TextFileReader.readTheseFiles(file1, file2).stream().toList().getLast().substring(0, 8));
    }

    /**
     * Test for the {@code TextFileReader.getTheseFiles()}
     */

    @Test
    void getTheseFilesTest() throws IOException {
        File file1 = new File(" \\TestFile1.txt");
        File file2 = new File(" \\TestFile2.txt");

        assertEquals("I am the", TextFileReader.getTheseFiles(file1, file2).get("TestFile2.txt").substring(0, 8));
    }

}