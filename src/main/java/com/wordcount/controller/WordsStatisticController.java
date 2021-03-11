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
    private InputReader _dictionaryReader;
    private AnswerWriter _writer;
    private WordsStatisticOptions _wordsStatisticOptions;

    public WordsStatisticController(
            InputReader reader,
            InputReader stopWordsReader,
            InputReader dictionaryReader,
            AnswerWriter writer,
            WordsStatisticOptions wordsStatisticOptions
    ) {
        _reader = reader;
        _stopWordsReader = stopWordsReader;
        _dictionaryReader = dictionaryReader;
        _writer = writer;
        _wordsStatisticOptions = wordsStatisticOptions;
    }

    public void countWordsStatistic() {
        List<String> inputText = readText();
        List<String> stopWords = readStopWords();
        List<String> dictionaryWords = readDictionary();
        WordsStatistic wordsStatistic = countStatistic(
                inputText,
                stopWords,
                dictionaryWords,
                _wordsStatisticOptions
        );
        writeWordCount(wordsStatistic);
    }

    private List<String> readText() {
        return _reader.read();
    }

    private List<String> readStopWords() {
        return _stopWordsReader.read();
    }

    private List<String> readDictionary() {
        return _dictionaryReader == null ? null : _dictionaryReader.read();
    }

    private WordsStatistic countStatistic(
            List<String> text,
            List<String> stopWords,
            List<String> dictionaryWords,
            WordsStatisticOptions wordsStatisticOptions
    ) {
        WordsStatisticCounter wordsStatisticCounter = new WordsStatisticCounter(
                text,
                stopWords,
                dictionaryWords,
                wordsStatisticOptions
        );
        return wordsStatisticCounter.count();
    }

    private void writeWordCount(WordsStatistic wordsStatistic) {
        _writer.write(wordsStatistic);
    }
}
