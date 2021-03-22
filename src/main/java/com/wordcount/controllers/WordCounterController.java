package com.wordcount.controllers;

import com.wordcount.domain.WordCounter;
import com.wordcount.readers.StopWordsReader;
import com.wordcount.readers.UserInputReader;
import com.wordcount.writers.UserOutputWriter;

import java.util.List;

public class WordCounterController {

    private final UserInputReader reader;
    private final StopWordsReader stopWordsReader;
    private final UserOutputWriter writer;

    public WordCounterController(
            UserInputReader reader,
            StopWordsReader stopWordsreader,
            UserOutputWriter writer
    ) {
        this.reader = reader;
        stopWordsReader = stopWordsreader;
        this.writer = writer;
    }

    public void countWords() {
        String inputText = readText();
        List<String> stopWords = readStopWords();
        long wordCount = countWords(inputText, stopWords);
        writeWordCount(wordCount);
    }

    private String readText() {
        return reader.read();
    }

    private List<String> readStopWords() {
        return stopWordsReader.read();
    }

    private long countWords(String text, List<String> stopWords) {
        WordCounter wordCounter = new WordCounter(stopWords);
        return wordCounter.countWords(text);
    }

    private void writeWordCount(long wordCount) {
        writer.write(wordCount);
    }
}
