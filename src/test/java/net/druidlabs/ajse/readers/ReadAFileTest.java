package net.druidlabs.ajse.readers;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadAFileTest {

    @Test
    void readThisFile() throws IOException {
        String fileText = ReadAFile.readThisFile("C:\\Users\\Andruid929\\Desktop", "Mooks.txt");

        System.out.println(fileText);

        assertEquals("I am a gunch", fileText.substring(0, 12));
    }

    @Test
    void readTheseFiles() throws IOException {
        File file1 = new File("C:\\Users\\Andruid929\\Desktop\\Mooks.txt");
        File file2 = new File("C:\\Users\\Andruid929\\Desktop\\Milks.txt");

        assertEquals(2, ReadAFile.readTheseFiles(file1, file2).size());

        ReadAFile.readTheseFiles(file1, file2).forEach(System.out::print);
    }

}