package net.druidlabs.ajse;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileLineCollectorTest {

    private final String testFileName = "TestFile3.txt";

    @Test
    void collectUnsortedLines() throws IOException {
        Set<String> lines = FileLineCollector.collectUnsortedLines("", testFileName);

        assertTrue(lines.contains("Will be collected"));
    }

    @Test
    void collectSortedLines() throws IOException {
        List<String> lines = FileLineCollector.collectSortedLines("", testFileName);

        assertEquals("Seeing if the lines", lines.get(1));
    }

}