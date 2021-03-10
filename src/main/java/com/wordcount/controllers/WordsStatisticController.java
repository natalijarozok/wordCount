package com.wordcount.controllers;

import com.wordcount.domain.WordsStatistic;
import com.wordcount.domain.WordsStatisticCounter;
import com.wordcount.readers.InputReader;
import com.wordcount.writers.AnswerWriter;

import java.util.List;

public class WordsStatisticController {

    private InputReader _reader;
    private InputReader _stopWordsReader;
    private AnswerWriter _writer;

    public WordsStatisticController(
            InputReader reader,
            InputReader stopWordsReader,
            AnswerWriter writer
    ) {
        _reader = reader;
        _stopWordsReader = stopWordsReader;
        _writer = writer;
    }

    public void countWordsStatistic() {
        List<String> inputText = readText();
        List<String> stopWords = readStopWords();
        WordsStatistic wordsStatistic = countStatistic(inputText, stopWords);
        writeWordCount(wordsStatistic);
    }

    private List<String> readText() {
        return _reader.read();
    }

    private List<String> readStopWords() {
        return _stopWordsReader.read();
    }

    private WordsStatistic countStatistic(List<String> text, List<String> stopWords) {
        WordsStatisticCounter wordsStatisticCounter = new WordsStatisticCounter(text, stopWords);
        return wordsStatisticCounter.count();
    }

    private void writeWordCount(WordsStatistic wordsStatistic) {
        _writer.write(wordsStatistic);
    }
}
