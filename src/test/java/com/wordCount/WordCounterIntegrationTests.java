package com.wordCount;

import com.wordCount.mocks.*;
import com.wordCount.paramsSource.TestParam;
import com.wordCount.paramsSource.TestParamValuesSource;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.impl.AnswerWriterImpl;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        StopWordsReaderStub stopWordsReaderStub = new StopWordsReaderStub();
        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriterSpy);

        HashMap<TestParam, Integer> params = TestParamValuesSource.getTextParamValues();

        for (Map.Entry<TestParam, Integer> param : params.entrySet()) {
            text = param.getKey().getInputText();
            stopWords = param.getKey().getStopWords();
            wordCount = param.getValue();

            readerStub.setup(text);
            stopWordsReaderStub.setup(stopWords);

            WordCounterController sut = new WordCounterController(readerStub, stopWordsReaderStub, answerWriter);
            sut.countWords();

            consoleWriterSpy.shouldWriteText(String.format("Number of words: %d", wordCount));
        }
    }
}
