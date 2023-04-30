package ua.lviv.iot.algo.part1.lab5.readers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    Reader reader = new Reader();
    @Test
    void readFromConsole() {
        String expected = "text to test input from console";
        InputStream in = new ByteArrayInputStream(expected.getBytes());
        System.setIn(in);

        String actual = reader.readFromConsole();
        assertEquals(expected, actual);
    }
}
