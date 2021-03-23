package com.wordCount;

import com.wordCount.data.wordsStatistic.TestDataSource;
import com.wordCount.data.wordsStatistic.entity.TestData;
import com.wordCount.mock.*;
import com.wordcount.controller.WordsStatisticController;
import com.wordcount.domain.dto.Word;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.impl.AnswerWriterImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordsStatisticCounterIntegrationTests {

    private final StopWordsReaderStub stopWordsReaderStub = new StopWordsReaderStub();
    private final DictionaryReaderStub dictionaryReaderStub = new DictionaryReaderStub();
    private final ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
    private AnswerWriter answerWriter;


    @Test
    public void words_statistic_in_text_from_console() {
        ConsoleTextReaderStub readerStub = new ConsoleTextReaderStub();
        answerWriter = new AnswerWriterImpl(consoleWriterSpy);
        List<TestData> testInput = TestDataSource.getTestData();

        for (TestData testData : testInput) {
            assertWordsStatisticIsCorrect(testData, readerStub);
        }
    }

    @Test
    public void words_statistic_in_text_from_file() {
        FileTextReaderReaderStub readerStub = new FileTextReaderReaderStub();
        answerWriter = new AnswerWriterImpl(consoleWriterSpy);
        List<TestData> testInput = TestDataSource.getTestData();

        for (TestData testData : testInput) {
            assertWordsStatisticIsCorrect(testData, readerStub);
        }
    }

    private void assertWordsStatisticIsCorrect(TestData testData, TextReaderStub readerStub) {
        readerStub.setup(testData.getTestInput().getInputText());
        stopWordsReaderStub.setup(testData.getTestInput().getStopWords());
        dictionaryReaderStub.setup(testData.getTestInput().getDictionaryWords());

        WordsStatisticController sut = new WordsStatisticController(
                readerStub,
                stopWordsReaderStub,
                dictionaryReaderStub,
                answerWriter,
                testData.getTestInput().getIncludeWordIndex()
        );
        sut.execute();
        consoleWriterSpy.shouldWriteText(testData, getExpectedWordsStatistic(testData));
    }

    private String getExpectedWordsStatistic(TestData testData) {
        StringBuilder expectedAnswer = new StringBuilder(
                String.format(
                        "Number of words: %d, unique: %d; average word length: %.2f characters",
                        testData.getExpectedOutput().getExpectedCorrectWordCount(),
                        testData.getExpectedOutput().getExpectedUniqueWordCount(),
                        testData.getExpectedOutput().getExpectedAverageWordLength()
                )
        );

        if (testData.getTestInput().getIncludeWordIndex()) {
            expectedAnswer.append("\nIndex");
            if (testData.getExpectedOutput().getExpectedUnknownWordCount() != null) {
                expectedAnswer.append(String.format(" (unknown: %d)", testData.getExpectedOutput().getExpectedUnknownWordCount()));
            }

            expectedAnswer.append(":\n");

            for (Word word : testData.getExpectedOutput().getExpectedRawWordIndex()) {
                expectedAnswer.append(String.format("%s%s\n", word.getValue(), word.wordIsKnown() ? "" : "*"));
            }
        }

        return expectedAnswer.toString();
    }
}
