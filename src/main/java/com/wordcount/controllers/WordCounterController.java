package com.wordcount.controllers;

import com.wordcount.domain.WordCounter;
import com.wordcount.inputOutput.IOCommunicator;
import com.wordcount.inputOutput.input.StopWordsReader;

import java.util.List;

public class WordCounterController {

    private final IOCommunicator userCommunicator;
    private final StopWordsReader stopWordsReader;

    public WordCounterController(
            IOCommunicator userCommunicator,
            StopWordsReader stopWordsreader
    ) {
        this.userCommunicator = userCommunicator;
        stopWordsReader = stopWordsreader;
    }

    public void countWords() {
        String inputText = readText();
        List<String> stopWords = readStopWords();
        long wordCount = countWords(inputText, stopWords);
        writeWordCount(wordCount);
    }

    private String readText() {
        return userCommunicator.read();
    }

    private List<String> readStopWords() {
        return stopWordsReader.read();
    }

    private long countWords(String text, List<String> stopWords) {
        WordCounter wordCounter = new WordCounter(stopWords);
        return wordCounter.countWords(text);
    }

    private void writeWordCount(long wordCount) {
        userCommunicator.write(String.valueOf(wordCount));
    }
}
