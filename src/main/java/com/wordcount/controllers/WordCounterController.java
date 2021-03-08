package com.wordcount.controllers;

import com.wordcount.domain.WordCounter;
import com.wordcount.readers.InputTextReader;
import com.wordcount.readers.StopWordsReader;
import com.wordcount.writers.AnswerWriter;

import java.util.List;

public class WordCounterController {

    private InputTextReader _reader;
    private StopWordsReader _stopWordsReader;
    private AnswerWriter _writer;

    public WordCounterController(
            InputTextReader reader,
            StopWordsReader stopWordsreader,
            AnswerWriter writer
    ) {
        _reader = reader;
        _stopWordsReader = stopWordsreader;
        _writer = writer;
    }

    public void countWords() {
        String inputText = readText();
        List<String> stopWords = readStopWords();
        int wordCount = countWords(inputText, stopWords);
        writeWordCount(wordCount);
    }

    private String readText() {
        return _reader.read();
    }

    private List<String> readStopWords() {
        return _stopWordsReader.read();
    }

    private int countWords(String text, List<String> stopWords) {
        WordCounter wordCounter = new WordCounter(text, stopWords);
        return wordCounter.count();
    }

    private void writeWordCount(int wordCount) {
        _writer.write(wordCount);
    }
}
