package com.wordcount.domain;

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

    public WordsStatistic(int wordCount, int uniqueWordCount, float averageWordLength) {
        _wordCount = wordCount;
        _uniqueWordCount = uniqueWordCount;
        _averageWordLength = averageWordLength;
    }
}
