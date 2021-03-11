package com.wordCount;

import com.wordCount.data.wordsStatistic.TestDataStructure;
import com.wordCount.data.wordsStatistic.TestInput;
import com.wordCount.mock.*;
import com.wordcount.controller.WordsStatisticController;
import com.wordcount.domain.dto.Word;
import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.impl.AnswerWriterImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordsStatisticCounterIntegrationTests {

    private StopWordsReaderStub stopWordsReaderStub = new StopWordsReaderStub();
    private DictionaryReaderStub dictionaryReaderStub = new DictionaryReaderStub();
    private ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
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
        answerWriter = new AnswerWriterImpl(consoleWriterSpy);
        List<TestDataStructure> testInput = new TestInput().get();

        for (TestDataStructure testData : testInput) {
            checkThatWordsStatisticIsCorrect(testData, readerStub);
        }
    }

    private void checkThatWordsStatisticIsCorrect(TestDataStructure testData, TextReaderStub readerStub) {
        readerStub.setup(testData.getInputText());
        stopWordsReaderStub.setup(testData.getStopWords());
        dictionaryReaderStub.setup(testData.getDictionaryWords());

        WordsStatisticController sut = new WordsStatisticController(
                readerStub,
                stopWordsReaderStub,
                dictionaryReaderStub,
                answerWriter,
                new WordsStatisticOptions(testData.getIncludeWordIndex())
        );
        sut.countWordsStatistic();
        consoleWriterSpy.shouldWriteText(getExpectedAnswer(testData));
    }

    private String getExpectedAnswer(TestDataStructure testData) {
        StringBuilder expectedAnswer = new StringBuilder(
                String.format(
                        "Number of words: %d, unique: %d; average word length: %.2f characters",
                        testData.getExpectedWordCount(),
                        testData.getExpectedUniqueWordCount(),
                        testData.getExpectedAverageWordLength()
                )
        );

        if (testData.getIncludeWordIndex()) {
            expectedAnswer.append("\nIndex");
            if (testData.getUnknownWordCount() != null) {
                expectedAnswer.append(String.format(" (unknown: %d)", testData.getUnknownWordCount()));
            }

            expectedAnswer.append(":\n");

            for (Word word : testData.getExpectedWordIndex()) {
                expectedAnswer.append(String.format("%s%s\n", word.getValue(), word.wordIsKnown() ? "" : "*"));
            }
        }

        return expectedAnswer.toString();
    }
}
