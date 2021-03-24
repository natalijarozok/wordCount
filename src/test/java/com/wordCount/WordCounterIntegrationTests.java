package com.wordCount;

import com.wordCount.mocks.ConsoleUserInput;
import com.wordCount.mocks.ConsoleUserOutput;
import com.wordCount.mocks.StopWordsReader;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.inputOutput.IOCommunicator;
import com.wordcount.inputOutput.impl.IOCommunicatorImpl;
import com.wordcount.inputOutput.input.UserInputReader;
import com.wordcount.inputOutput.input.impl.StopWordsReaderImpl;
import com.wordcount.inputOutput.input.impl.UserInputReaderImpl;
import com.wordcount.inputOutput.output.UserOutputWriter;
import com.wordcount.inputOutput.output.impl.UserOutputWriterImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static com.wordCount.data.DataSource.getData;
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
    public void count_words() {
        ConsoleUserInput consoleInput = new ConsoleUserInput();
        UserInputReader inputReader = new UserInputReaderImpl(consoleInput);

        ConsoleUserOutput consoleOutput = new ConsoleUserOutput();
        UserOutputWriter outputWriter = new UserOutputWriterImpl(consoleOutput);

        IOCommunicator ioCommunicator = new IOCommunicatorImpl(inputReader, outputWriter);

        StopWordsReader stopWords = new StopWordsReader();

        getData().forEach(testData ->
                {
                    consoleInput.returns(testData.inputText());
                    stopWords.contain(testData.stopWords());

                    WordCounterController sut = new WordCounterController(
                            ioCommunicator,
                            stopWords
                    );
                    sut.countWords();

                    consoleOutput
                            .forUserInput(testData)
                            .writes(
                                    String.format(
                                            "Number of words: %d",
                                            testData.expectedWordCount()
                                    )
                            );
                }
        );

    }

    @Test
    public void count_words_from_console() {
        String inputText = "Mary had a little lamb";
        String expectedOutput = String.format("Number of words: %d\n", 4);
        com.wordcount.inputOutput.input.StopWordsReader stopWords = new StopWordsReaderImpl();
        assertInputWordCountEqualsToExpectedWordCount(
                inputText,
                stopWords,
                expectedOutput
        );
    }

    @Test
    public void count_words_from_console_with_not_existing_stop_words_file() {
        String inputText = "Mary had a little lamb";
        String expectedOutput = String.format("Number of words: %d\n", 5);
        com.wordcount.inputOutput.input.StopWordsReader stopWords = new StopWordsReaderImpl("not_existing_stop_words_file.txt");
        assertInputWordCountEqualsToExpectedWordCount(
                inputText,
                stopWords,
                expectedOutput
        );
    }

    @Test
    public void count_words_from_console_with_empty_stop_words_file() {
        String inputText = "Mary had a little lamb";
        String expectedOutput = String.format("Number of words: %d\n", 5);
        com.wordcount.inputOutput.input.StopWordsReader stopWords = new StopWordsReaderImpl("stop_words_empty.txt");
        assertInputWordCountEqualsToExpectedWordCount(
                inputText,
                stopWords,
                expectedOutput
        );
    }

    private void assertInputWordCountEqualsToExpectedWordCount(
            String inputText,
            com.wordcount.inputOutput.input.StopWordsReader stopWords,
            String expectedOutput
    ) {
        provideConsoleInput(inputText);

        com.wordcount.inputOutput.input.impl.ConsoleUserInput consoleInput = new com.wordcount.inputOutput.input.impl.ConsoleUserInput();
        UserInputReader inputReader = new UserInputReaderImpl(consoleInput);

        com.wordcount.inputOutput.output.impl.ConsoleUserOutput consoleOutput = new com.wordcount.inputOutput.output.impl.ConsoleUserOutput();
        UserOutputWriter outputWriter = new UserOutputWriterImpl(consoleOutput);

        IOCommunicator ioCommunicator = new IOCommunicatorImpl(inputReader, outputWriter);

        WordCounterController sut = new WordCounterController(ioCommunicator, stopWords);
        sut.countWords();

        assertEquals(expectedOutput, actualConsoleOutput());
    }
}
