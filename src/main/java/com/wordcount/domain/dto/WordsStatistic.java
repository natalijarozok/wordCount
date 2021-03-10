package com.wordcount.domain.dto;

import java.util.List;

public class WordsStatistic {
    private int _wordCount;

    public int getWordCount() {
        return _wordCount;
    }

    private int _uniqueWordCount;

    public int getUniqueWordCount() {
        return _uniqueWordCount;
    }

    private float _averageWordLength;

    public float getAverageWordLength() {
        return _averageWordLength;
    }

    private List<String> _wordsIndex;

    public List<String> getWordsIndex() {
        return _wordsIndex;
    }

    public WordsStatistic(
            int wordCount,
            int uniqueWordCount,
            float averageWordLength
    ) {
        this(wordCount, uniqueWordCount, averageWordLength, null);
    }
    public WordsStatistic(
            int wordCount,
            int uniqueWordCount,
            float averageWordLength,
            List<String> wordsIndex
    ) {
        _wordCount = wordCount;
        _uniqueWordCount = uniqueWordCount;
        _averageWordLength = averageWordLength;
        _wordsIndex = wordsIndex;
    }
}
