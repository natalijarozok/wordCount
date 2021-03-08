package com.wordCount;

import com.wordCount.mocks.ConsoleTextReaderStub;
import com.wordCount.mocks.ConsoleWriterSpy;
import com.wordCount.paramsSource.TestParamValuesSource;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.readers.StopWordsReader;
import com.wordcount.readers.impl.StopWordsReaderImpl;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.impl.AnswerWriterImpl;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounterIntegrationTests {

//    @Test
//    public void word_counting() {
//
//        String text;
//        int wordCount;
//
//        ConsoleTextReaderStub readerStub = new ConsoleTextReaderStub();
//        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
//        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriterSpy);
//
//        HashMap<String, Integer> params = TestParamValuesSource.getTextParamValues();
//
//        for (Map.Entry<String, Integer> param : params.entrySet()) {
//            text = param.getKey();
//            wordCount = param.getValue().intValue();
//
//            readerStub.setup(text);
//
//            WordCounterController sut = new WordCounterController(readerStub, answerWriter);
//            sut.countWords();
//
//            consoleWriterSpy.shouldWriteText(String.format("Number of words: %d", wordCount));
//        }
//    }

    @Test
    public void word_counting() {

        String text;
        List<String> stopWords;
        int wordCount;

        ConsoleTextReaderStub readerStub = new ConsoleTextReaderStub();
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();
        ConsoleWriterSpy consoleWriterSpy = new ConsoleWriterSpy();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriterSpy);

        HashMap<Pair<String, List<String>>, Integer> params = TestParamValuesSource.getTextParamValues();

        for (Map.Entry<Pair<String, List<String>>, Integer> param : params.entrySet()) {
            text = param.getKey().getKey();
            stopWords = param.getKey().getValue();

            readerStub.setup(text);

            WordCounterController sut = new WordCounterController(readerStub, stopWordsReader, answerWriter);
            sut.countWords();

            consoleWriterSpy.shouldWriteText(String.format("Number of words: %d", param.getValue()));
        }
    }
}
