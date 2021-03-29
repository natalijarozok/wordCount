package com.wordcount.mainApp.controller;

import com.wordcount.interfaces.InputReader;
import com.wordcount.interfaces.UserInterface;
import com.wordcount.mainApp.domain.WordCounter;

import java.util.List;

public class WordCounterController {

    private final UserInterface userCommunicator;
    private final InputReader stopWordsReader;

    public WordCounterController(
            UserInterface userCommunicator,
            InputReader stopWordsReader
    ) {
        this.userCommunicator = userCommunicator;
        this.stopWordsReader = stopWordsReader;
    }

    public void countWords() {
        List<String> inputText = readText();
        List<String> stopWords = readStopWords();
        long wordCount = countWords(inputText, stopWords);
        writeWordCount(wordCount);
    }

    private List<String> readText() {
        return userCommunicator.read();
    }

    private List<String> readStopWords() {
        return stopWordsReader.read();
    }

    private long countWords(List<String> text, List<String> stopWords) {
        WordCounter wordCounter = new WordCounter(stopWords);
        return wordCounter.countWords(text);
    }

    private void writeWordCount(long wordCount) {
        userCommunicator.write(String.valueOf(wordCount));
    }
}
