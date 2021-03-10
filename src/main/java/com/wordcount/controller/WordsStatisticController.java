package com.wordcount.controller;

import com.wordcount.domain.WordsStatisticCounter;
import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.reader.InputReader;
import com.wordcount.writer.AnswerWriter;

import java.util.List;

public class WordsStatisticController {

    private InputReader _reader;
    private InputReader _stopWordsReader;
    private AnswerWriter _writer;
    private WordsStatisticOptions _wordsStatisticOptions;

    public WordsStatisticController(
            InputReader reader,
            InputReader stopWordsReader,
            AnswerWriter writer,
            WordsStatisticOptions wordsStatisticOptions
    ) {
        _reader = reader;
        _stopWordsReader = stopWordsReader;
        _writer = writer;
        _wordsStatisticOptions = wordsStatisticOptions;
    }

    public void countWordsStatistic() {
        List<String> inputText = readText();
        List<String> stopWords = readStopWords();
        WordsStatistic wordsStatistic = countStatistic(inputText, stopWords, _wordsStatisticOptions);
        writeWordCount(wordsStatistic);
    }

    private List<String> readText() {
        return _reader.read();
    }

    private List<String> readStopWords() {
        return _stopWordsReader.read();
    }

    private WordsStatistic countStatistic(
            List<String> text,
            List<String> stopWords,
            WordsStatisticOptions wordsStatisticOptions
    ) {
        WordsStatisticCounter wordsStatisticCounter = new WordsStatisticCounter(
                text,
                stopWords,
                wordsStatisticOptions
        );
        return wordsStatisticCounter.count();
    }

    private void writeWordCount(WordsStatistic wordsStatistic) {
        _writer.write(wordsStatistic);
    }
}
