package com.wordcount.domain.dto;

public class WordsStatisticOptions {
    private boolean _includeWordIndex;

    public boolean getIncludeWordIndex() {
        return _includeWordIndex;
    }

    public WordsStatisticOptions() {
        this(false);
    }

    public WordsStatisticOptions(boolean includeWordIndex) {
        _includeWordIndex = includeWordIndex;
    }
}
