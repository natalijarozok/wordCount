package com.wordcount.controllers;

import com.wordcount.domain.WordCounter;
import com.wordcount.readers.InputReader;
import com.wordcount.writers.AnswerWriter;

import java.util.List;

public class WordCounterController {

    private InputReader _reader;
    private InputReader _stopWordsReader;
    private AnswerWriter _writer;

    public WordCounterController(
            InputReader reader,
            InputReader stopWordsreader,
            AnswerWriter writer
    ) {
        _reader = reader;
        _stopWordsReader = stopWordsreader;
        _writer = writer;
    }

    public void countWords() {
        List<String> inputText = readText();
        List<String> stopWords = readStopWords();
        int wordCount = countWords(inputText, stopWords);
        writeWordCount(wordCount);
    }

    private List<String> readText() {

        return _reader.read();
    }

    private List<String> readStopWords() {
        return _stopWordsReader.read();
    }

    private int countWords(List<String> text, List<String> stopWords) {
        WordCounter wordCounter = new WordCounter(text, stopWords);
        return wordCounter.count();
    }

    private void writeWordCount(int wordCount) {
        _writer.write(wordCount);
    }
}
