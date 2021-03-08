package com.wordcount.controllers;

import com.wordcount.domain.WordCounter;
import com.wordcount.readers.ConsoleTextReader;
import com.wordcount.writers.AnswerWriter;

public class WordCounterController {

    private ConsoleTextReader _reader;
    private AnswerWriter _writer;

    public WordCounterController(ConsoleTextReader reader, AnswerWriter writer) {
        _reader = reader;
        _writer = writer;
    }

    public void countWords() {
        String inputText = readText();
        int wordCount = countWords(inputText);
        writeWordCount(wordCount);
    }

    private String readText() {
        return _reader.read();
    }

    private int countWords(String text) {
        WordCounter wordCounter = new WordCounter(text);
        return wordCounter.count();
    }

    private void writeWordCount(int wordCount) {
        _writer.write(wordCount);
    }
}
