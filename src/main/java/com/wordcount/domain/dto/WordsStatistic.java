package com.wordcount.domain.dto;

import java.util.List;

public class WordsStatistic {
    private final int _wordCount;

    public int getWordCount() {
        return _wordCount;
    }

    private final int _uniqueWordCount;

    public int getUniqueWordCount() {
        return _uniqueWordCount;
    }

    private final float _averageWordLength;

    public float getAverageWordLength() {
        return _averageWordLength;
    }

    private final List<Word> _wordsIndex;

    public List<Word> getWordsIndex() {
        return _wordsIndex;
    }

    private final Integer _unknownWordCount;

    public Integer getUnknownWordCount() {
        return _unknownWordCount;
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
                ((_unknownWordCount == null && that._unknownWordCount == null) || _unknownWordCount.equals(that._unknownWordCount)) &&
                ((_wordsIndex == null && that._wordsIndex == null) || _wordsIndex.equals(that._wordsIndex));
    }
}
