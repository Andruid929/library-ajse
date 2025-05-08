package net.druidlabs.ajse;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class FileLineCollectorTest {

    @Test
    void collectUnsortedLines() throws IOException {
        FileLineCollector.collectUnsortedLines("", "TestFile3.txt");
    }

    @Test
    void collectSortedLines() {
    }

    @Test
    void collectLines() {
    }
}