package com.wordCount;

import com.wordCount.mock.*;
import com.wordCount.paramsSource.TestInput;
import com.wordCount.paramsSource.TestInputValuesSource;
import com.wordcount.controller.WordsStatisticController;
import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.impl.AnswerWriterImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCounterIntegrationTests {

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
        List<String> text;
        List<String> stopWords;
        int wordCount;
        int uniqueWordCount;
        float averageWordLength;

        StopWordsReaderStub stopWordsReaderStub = new StopWordsReaderStub();
        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriterSpy);

        List<TestInput> params = TestInputValuesSource.getTestInputValues();

        for (TestInput param : params) {
            text = param.getInputText();
            stopWords = param.getStopWords();
            wordCount = param.getCorrectWordCount();
            uniqueWordCount = param.getUniqueWordCount();
            averageWordLength = param.getAverageWordLength();

            readerStub.setup(text);
            stopWordsReaderStub.setup(stopWords);

            WordsStatisticController sut = new WordsStatisticController(
                    readerStub,
                    stopWordsReaderStub,
                    answerWriter,
                    new WordsStatisticOptions()
            );
            sut.countWordsStatistic();

            consoleWriterSpy.shouldWriteText(String.format(
                    "Number of words: %d, unique: %d; average word length: %.2f characters",
                    wordCount,
                    uniqueWordCount,
                    averageWordLength
            ));
        }
    }
}
