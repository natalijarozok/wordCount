package com.wordCount;

import com.wordCount.mocks.ConsoleTextReaderStub;
import com.wordCount.mocks.ConsoleWriterSpy;
import com.wordCount.paramsSource.TestParamValuesSource;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.impl.AnswerWriterImpl;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCounterIntegrationTests {

    @Test
    public void word_counting_in_a_text_made_of_words_only_is_correct() {

        ConsoleTextReaderStub readerStub = new ConsoleTextReaderStub();
        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriterSpy);

        HashMap<String, Integer> params = TestParamValuesSource.getWordsOnlyParamValues();

        for (Map.Entry<String, Integer> param : params.entrySet()) {
            readerStub.setup(param.getKey());

            WordCounterController sut = new WordCounterController(readerStub, answerWriter);
            sut.countWords();

            consoleWriterSpy.shouldWriteText(String.format("Number of words: %d", param.getValue()));
        }
    }

    @Test
    public void word_counting_in_a_text_made_not_of_words_only_is_correct() {

        ConsoleTextReaderStub readerStub = new ConsoleTextReaderStub();
        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriterSpy);

        HashMap<String, Integer> params = TestParamValuesSource.getNonWordsParamValues();

        for (Map.Entry<String, Integer> param : params.entrySet()) {
            readerStub.setup(param.getKey());

            WordCounterController sut = new WordCounterController(readerStub, answerWriter);
            sut.countWords();

            consoleWriterSpy.shouldWriteText(String.format("Number of words: %d", param.getValue()));
        }
    }
}
