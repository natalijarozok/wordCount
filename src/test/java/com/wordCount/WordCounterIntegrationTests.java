package com.wordCount;

import com.wordCount.mocks.ConsoleUserInput;
import com.wordCount.mocks.ConsoleUserOutput;
import com.wordCount.mocks.StopWordsReader;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.inputOutput.IOCommunicator;
import com.wordcount.inputOutput.impl.IOCommunicatorImpl;
import com.wordcount.inputOutput.input.UserInputReader;
import com.wordcount.inputOutput.input.impl.UserInputReaderImpl;
import com.wordcount.inputOutput.output.UserOutputWriter;
import com.wordcount.inputOutput.output.impl.UserOutputWriterImpl;
import org.junit.jupiter.api.Test;

import static com.wordCount.data.DataSource.getData;

public class WordCounterIntegrationTests {

    @Test
    public void word_counting() {
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
}
