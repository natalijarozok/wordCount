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

    private List<Word> _wordsIndex;

    public List<Word> getWordsIndex() {
        return _wordsIndex;
    }

    private Integer _unknownWordCount;

    public Integer getUnknownWordCount() {
        return _unknownWordCount;
    }

    public WordsStatistic(
            int wordCount,
            int uniqueWordCount,
            float averageWordLength
    ) {
        this(wordCount, uniqueWordCount, averageWordLength, null, null);
    }

    public WordsStatistic(
            int wordCount,
            int uniqueWordCount,
            float averageWordLength,
            Integer unknownWordCount,
            List<Word> wordsIndex
    ) {
        _wordCount = wordCount;
        _uniqueWordCount = uniqueWordCount;
        _averageWordLength = averageWordLength;
        _wordsIndex = wordsIndex;
        _unknownWordCount = unknownWordCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordsStatistic that = (WordsStatistic) o;
        return _wordCount == that._wordCount &&
                _uniqueWordCount == that._uniqueWordCount &&
                _averageWordLength == that._averageWordLength &&
                _unknownWordCount == that._unknownWordCount &&
                ((_wordsIndex == null && that._wordsIndex == null) || _wordsIndex.equals(that._wordsIndex));
    }
}
