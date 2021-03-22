package com.wordCount;

import com.wordCount.mocks.ConsoleWriterSpy;
import com.wordCount.mocks.StopWordsReaderStub;
import com.wordCount.mocks.UserInputReaderStub;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.writers.UserOutputWriter;
import com.wordcount.writers.impl.UserOutputWriterImpl;
import org.junit.jupiter.api.Test;

import static com.wordCount.data.DataSource.getData;

public class WordCounterIntegrationTests {

    @Test
    public void word_counting() {
        UserInputReaderStub readerStub = new UserInputReaderStub();
        StopWordsReaderStub stopWordsReaderStub = new StopWordsReaderStub();
        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
        UserOutputWriter answerWriter = new UserOutputWriterImpl(consoleWriterSpy);

        getData().forEach(testData ->
                {
                    readerStub.setup(testData.getTestInput().getInputText());
                    stopWordsReaderStub.setup(testData.getTestInput().getStopWords());

                    WordCounterController sut = new WordCounterController(
                            readerStub,
                            stopWordsReaderStub,
                            answerWriter
                    );
                    sut.countWords();

                    consoleWriterSpy
                            .withInput(testData.getTestInput())
                            .shouldWrite(
                                    String.format(
                                            "Number of words: %d",
                                            testData.getExpectedOutput().getExpectedWordCount()
                                    )
                            );
                }
        );

    }
}
