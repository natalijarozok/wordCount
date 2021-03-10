package com.wordCount;

import com.wordCount.data.TestDataStructure;
import com.wordCount.data.TestInput;
import com.wordCount.mock.*;
import com.wordcount.controller.WordsStatisticController;
import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.impl.AnswerWriterImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class WordCounterIntegrationTests {

    private StopWordsReaderStub stopWordsReaderStub;
    private ConsoleWriterSpy consoleWriterSpy;
    private AnswerWriter answerWriter;


    @Test
    public void words_statistic_in_text_from_console() {
        ConsoleTextReaderStub readerStub = new ConsoleTextReaderStub();
        checkThatWordsStatisticIsCorrect(readerStub);
    }

    @Test
    public void words_statistic_in_text_from_file() {
        FileTextReaderReaderStub readerStub = new FileTextReaderReaderStub();
        checkThatWordsStatisticIsCorrect(readerStub);
    }

    private void checkThatWordsStatisticIsCorrect(TextReaderStub readerStub) {
        stopWordsReaderStub = new StopWordsReaderStub();
        consoleWriterSpy = new ConsoleWriterSpy();
        answerWriter = new AnswerWriterImpl(consoleWriterSpy);
        List<TestDataStructure> testInput = new TestInput().get();

        for (TestDataStructure testData : testInput) {
            checkThatWordsStatisticIsCorrect(testData, readerStub);
        }
    }

    private void checkThatWordsStatisticIsCorrect(TestDataStructure testData, TextReaderStub readerStub) {
        readerStub.setup(testData.getInputText());
        stopWordsReaderStub.setup(testData.getStopWords());

        WordsStatisticController sut = new WordsStatisticController(
                readerStub,
                stopWordsReaderStub,
                answerWriter,
                new WordsStatisticOptions(testData.getIncludeWordIndex())
        );
        sut.countWordsStatistic();
        consoleWriterSpy.shouldWriteText(getExpectedAnswer(testData));
    }

    private String getExpectedAnswer(TestDataStructure testData) {
        String expectedAnswer =
                String.format(
                        "Number of words: %d, unique: %d; average word length: %.2f characters",
                        testData.getExpectedWordCount(),
                        testData.getExpectedUniqueWordCount(),
                        testData.getExpectedAverageWordLength()
                );

        if (testData.getIncludeWordIndex() == true) {
            expectedAnswer += "\nIndex:\n";
            for (String word : testData.getExpectedWordIndex()) {
                expectedAnswer += String.format("%s\n", word);
            }
        }
        return expectedAnswer;
    }
}
