package com.wordcount.controllers;

import com.wordcount.domain.WordCounter;
import com.wordcount.domain.WordsStatistic;
import com.wordcount.readers.InputReader;
import com.wordcount.writers.AnswerWriter;

import java.util.List;

public class WordCounterController {

    private InputReader _reader;
    private InputReader _stopWordsReader;
    private AnswerWriter _writer;

    public WordCounterController(
            InputReader reader,
            InputReader stopWordsReader,
            AnswerWriter writer
    ) {
        _reader = reader;
        _stopWordsReader = stopWordsReader;
        _writer = writer;
    }

    public void countWords() {
        List<String> inputText = readText();
        List<String> stopWords = readStopWords();
        WordsStatistic wordStatistics = countStatistics(inputText, stopWords);
        writeWordCount(wordStatistics);
    }

    private List<String> readText() {
        return _reader.read();
    }

    private List<String> readStopWords() {
        return _stopWordsReader.read();
    }

    private WordsStatistic countStatistics(List<String> text, List<String> stopWords) {
        WordCounter wordCounter = new WordCounter(text, stopWords);
        return wordCounter.count();
    }

    private void writeWordCount(WordsStatistic wordStatistics) {
        _writer.write(wordStatistics);
    }
}
