package com.wordCount.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDataStructure {
    private List<String> _inputText;

    public List<String> getInputText() {
        return _inputText;
    }

    private List<String> _stopWords;

    public List<String> getStopWords() {
        return _stopWords;
    }

    private boolean _includeWordIndex;

    public boolean getIncludeWordIndex() {
        return _includeWordIndex;
    }

    public void setIncludeWordIndex(boolean newIncludeWordIndex) {
        this._includeWordIndex = newIncludeWordIndex;
    }

    private int _expectedWordCount;

    public int getExpectedWordCount() {
        return _expectedWordCount;
    }

    private int _expectedUniqueWordCount;

    public int getExpectedUniqueWordCount() {
        return _expectedUniqueWordCount;
    }

    private float _expectedAverageWordLength;

    public float getExpectedAverageWordLength() {
        return _expectedAverageWordLength;
    }

    private List<String> _expectedWordIndex;

    public void setExpectedWordIndex(List<String> newExpectedWordIndex) {
        this._expectedWordIndex = newExpectedWordIndex;
    }

    public List<String> getExpectedWordIndex() {
        return _expectedWordIndex;
    }

    public TestDataStructure(
            List<String> inputText,
            List<String> stopWords,
            int wordCount,
            int uniqueWordCount
    ) {
        _inputText = inputText;
        _stopWords = stopWords;
        _expectedWordCount = wordCount;
        _expectedUniqueWordCount = uniqueWordCount;
        _expectedAverageWordLength = 0f;
        _expectedWordIndex = Collections.emptyList();
    }

    public TestDataStructure(
            List<String> inputText,
            List<String> stopWords,
            int expectedWordCount,
            int expectedUniqueWordCount,
            float expectedAverageWordLength,
            List<String> wordIndex
    ) {
        _inputText = inputText;
        _stopWords = stopWords;
        _expectedWordCount = expectedWordCount;
        _expectedUniqueWordCount = expectedUniqueWordCount;
        _expectedAverageWordLength = expectedAverageWordLength;
        _expectedWordIndex = wordIndex;
    }

    public void putDelimiterIntoText(String delimiter) {
        List<String> delimitedText = new ArrayList<>();
        for (String line : _inputText) {
            delimitedText.add(line.replace(" ", delimiter));
        }
        _inputText = delimitedText;
    }

    public TestDataStructure clone() {
        return new TestDataStructure(
                this._inputText,
                this._stopWords,
                this._expectedWordCount,
                this._expectedUniqueWordCount,
                this._expectedAverageWordLength,
                this._expectedWordIndex
        );
    }
}
