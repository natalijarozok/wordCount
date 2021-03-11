package com.wordcount.domain.dto;

public class WordsStatisticOptions {
    private boolean _showWordsIndex;

    public WordsStatisticOptions() {
        this(false);
    }

    public WordsStatisticOptions(boolean showWordsIndex) {
        _showWordsIndex = showWordsIndex;
    }

    public void showWordsIndex() {
        _showWordsIndex = true;
    }

    public boolean isWordIndexRequired() {
        return _showWordsIndex;
    }
}
