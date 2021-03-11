package com.wordcount.domain.dto;

public class WordsStatisticOptions {
    private boolean _showWordsIndex;

    public WordsStatisticOptions(boolean showWordsIndex) {
        _showWordsIndex = showWordsIndex;
    }

    public void showWordsIndex() {
        _showWordsIndex = true;
    }

    public boolean isWordIndexRequired() {
        return _showWordsIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordsStatisticOptions that = (WordsStatisticOptions) o;
        return _showWordsIndex == that._showWordsIndex;
    }
}
