package com.wordCount;

import com.wordcount.mainApp.WordCount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterIntegrationTests {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setupConsoleOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideConsoleInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String actualConsoleOutput() {
        String outputStartText = "Enter text: ";
        return testOut.toString().replace(outputStartText, "");
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void count_words_from_console_with_existing_stop_words_file() {
        String inputText = "Mary had a little lamb";
        provideConsoleInput(inputText);
        String expectedOutput = String.format("Number of words: %d\n", 4);

        String[] inputParams = new String[0];
        WordCount.STOP_WORDS_FILE_NAME = "stopwords.txt";
        WordCount.main(inputParams);

        assertEquals(expectedOutput, actualConsoleOutput());
    }

    @Test
    public void count_words_from_console_with_empty_stop_words_file() {
        String inputText = "Mary had a little lamb";
        provideConsoleInput(inputText);
        String expectedOutput = String.format("Number of words: %d\n", 5);

        String[] inputParams = new String[0];
        WordCount.STOP_WORDS_FILE_NAME = "stop_words_empty.txt";
        WordCount.main(inputParams);

        assertEquals(expectedOutput, actualConsoleOutput());
    }

    @Test
    public void count_words_from_console_with_missing_stop_words_file() {
        String inputText = "Mary had a little lamb";
        provideConsoleInput(inputText);
        String expectedOutput = String.format("Number of words: %d\n", 5);

        String[] inputParams = new String[0];
        WordCount.STOP_WORDS_FILE_NAME = "missing_stop_words_file.txt";
        WordCount.main(inputParams);

        assertEquals(expectedOutput, actualConsoleOutput());
    }

    @Test
    public void count_words_from_file_with_existing_stop_words_file() {
        String expectedOutput = String.format("Number of words: %d\n", 4);

        String[] inputParams = {"mytext.txt"};
        WordCount.STOP_WORDS_FILE_NAME = "stopwords.txt";
        WordCount.main(inputParams);

        assertEquals(expectedOutput, actualConsoleOutput());
    }

    @Test
    public void count_words_from_file_with_empty_stop_words_file() {
        String expectedOutput = String.format("Number of words: %d\n", 5);

        String[] inputParams = {"mytext.txt"};
        WordCount.STOP_WORDS_FILE_NAME = "stop_words_empty.txt";
        WordCount.main(inputParams);

        assertEquals(expectedOutput, actualConsoleOutput());
    }

    @Test
    public void count_words_from_file_with_missing_stop_words_file() {
        String expectedOutput = String.format("Number of words: %d\n", 5);

        String[] inputParams = {"mytext.txt"};
        WordCount.STOP_WORDS_FILE_NAME = "missing_stop_words_file.txt";
        WordCount.main(inputParams);

        assertEquals(expectedOutput, actualConsoleOutput());
    }
}
