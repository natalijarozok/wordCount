package com.wordCount;

import com.wordCount.mocks.*;
import com.wordCount.paramsSource.TestInput;
import com.wordCount.paramsSource.TestInputValuesSource;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.impl.AnswerWriterImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WordCounterIntegrationTests {

    @Test
    public void word_counting_in_text_from_console() {
        ConsoleTextReaderStub readerStub = new ConsoleTextReaderStub();
        word_counting(readerStub);
    }

    @Test
    public void word_counting_in_text_from_file() {
        FileTextReaderReaderStub readerStub = new FileTextReaderReaderStub();
        word_counting(readerStub);
    }

    private void word_counting(TextReaderStub readerStub) {
        List<String> text;
        List<String> stopWords;
        int wordCount;
        int uniqueWordCount;
        float averageWordLength;

        StopWordsReaderStub stopWordsReaderStub = new StopWordsReaderStub();
        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriterSpy);

        List<TestInput> params = TestInputValuesSource.getTestInputValuesWithDelimiters();

        for (TestInput param : params) {
            text = param.getInputText();
            stopWords = param.getStopWords();
            wordCount = param.getCorrectWordCount();
            uniqueWordCount = param.getUniqueWordCount();
            averageWordLength = param.getAverageWordLength();

            readerStub.setup(text);
            stopWordsReaderStub.setup(stopWords);

            WordCounterController sut = new WordCounterController(readerStub, stopWordsReaderStub, answerWriter);
            sut.countWords();

            consoleWriterSpy.shouldWriteText(String.format(
                    "Number of words: %d, unique: %d; average word length: %.2f characters",
                    wordCount,
                    uniqueWordCount,
                    averageWordLength
            ));
        }
    }
}
