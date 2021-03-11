package com.wordCount.data.wordsStatistic;

import com.wordcount.domain.dto.Word;

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


    private List<String> _dictionaryWords;

    public List<String> getDictionaryWords() {
        return _dictionaryWords;
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


    private Integer _expectedUnknownWordCount;

    public Integer getUnknownWordCount() {
        return _expectedUnknownWordCount;
    }


    private List<Word> _expectedWordIndex;

    public void setExpectedWordIndex(List<Word> newExpectedWordIndex) {
        this._expectedWordIndex = newExpectedWordIndex;
    }

    public List<Word> getExpectedWordIndex() {
        return _expectedWordIndex;
    }

    public TestDataStructure(
            List<String> inputText,
            List<String> stopWords,
            List<String> dictionaryWords,
            int expectedWordCount,
            int expectedUniqueWordCount
    ) {
        _inputText = inputText;
        _stopWords = stopWords;
        _dictionaryWords = dictionaryWords;
        _expectedWordCount = expectedWordCount;
        _expectedUniqueWordCount = expectedUniqueWordCount;
        _expectedAverageWordLength = 0f;
        _expectedWordIndex = Collections.emptyList();
    }

    public TestDataStructure(
            List<String> inputText,
            List<String> stopWords,
            List<String> dictionaryWords,
            int expectedWordCount,
            int expectedUniqueWordCount,
            float expectedAverageWordLength,
            Integer expectedUnknownWordCount,
            List<Word> expectedWordIndex
    ) {
        _inputText = inputText;
        _stopWords = stopWords;
        _dictionaryWords = dictionaryWords;
        _expectedWordCount = expectedWordCount;
        _expectedUniqueWordCount = expectedUniqueWordCount;
        _expectedAverageWordLength = expectedAverageWordLength;
        _expectedUnknownWordCount = expectedUnknownWordCount;
        _expectedWordIndex = expectedWordIndex;
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
                this._dictionaryWords,
                this._expectedWordCount,
                this._expectedUniqueWordCount,
                this._expectedAverageWordLength,
                this._expectedUnknownWordCount,
                this._expectedWordIndex
        );
    }
}
