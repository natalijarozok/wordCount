package com.wordcount.controller;

import com.wordcount.ActionQueue;
import com.wordcount.domain.WordsStatisticCounter;
import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.domain.enums.ActionType;
import com.wordcount.reader.InputReader;
import com.wordcount.writer.AnswerWriter;

import java.util.List;

public class WordsStatisticController {

    private final InputReader _reader;
    private final InputReader _stopWordsReader;
    private final InputReader _dictionaryReader;
    private final AnswerWriter _writer;
    private final WordsStatisticOptions _wordsStatisticOptions;

    private List<String> _inputText;
    private List<String> _stopWords;
    private List<String> _dictionaryWords;

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

    public void execute() {
        do {
            ActionQueue.getInstance().executeAction();
            readData();
            ActionQueue.getInstance().executeActionIfEqualsTo(ActionType.TERMINATE);
            countAndShowStatistic();
        }
        while (ActionQueue.getInstance().isNotEmpty());
    }

    public void countAndShowStatistic() {
        countStatistic();
        writeStatistic(countStatistic());
    }

    private void readData() {
        _inputText = readText();
        _stopWords = readStopWords();
        _dictionaryWords = readDictionary();
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

    private WordsStatistic countStatistic() {
        WordsStatisticCounter wordsStatisticCounter = new WordsStatisticCounter(
                _inputText,
                _stopWords,
                _dictionaryWords,
                _wordsStatisticOptions
        );
        return wordsStatisticCounter.count();
    }

    private void writeStatistic(WordsStatistic wordsStatistic) {
        _writer.write(wordsStatistic);
    }
}
