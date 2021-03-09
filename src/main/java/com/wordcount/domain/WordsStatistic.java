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

    public WordsStatistic(int wordCount, int uniqueWordCount) {
        _wordCount = wordCount;
        _uniqueWordCount = uniqueWordCount;
    }
}
