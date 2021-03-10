package com.wordCount.paramsSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestInput {
    private List<String> _inputText;

    public List<String> getInputText() {
        return _inputText;
    }

    private List<String> _stopWords;

    public List<String> getStopWords() {
        return _stopWords;
    }

    private int _correctWordCount;

    public int getCorrectWordCount() {
        return _correctWordCount;
    }

    private int _uniqueWordCount;

    public int getUniqueWordCount() {
        return _uniqueWordCount;
    }

    private float _averageWordLength;

    public float getAverageWordLength() {
        return _averageWordLength;
    }

    private List<String> _wordIndex;

    public List<String> getWordIndex() {
        return _wordIndex;
    }

    public TestInput(
            List<String> inputText,
            List<String> stopWords,
            int wordCount,
            int uniqueWordCount
    ) {
        _inputText = inputText;
        _stopWords = stopWords;
        _correctWordCount = wordCount;
        _uniqueWordCount = uniqueWordCount;
        _averageWordLength = 0f;
        _wordIndex = Collections.emptyList();
    }

    public TestInput(
            List<String> inputText,
            List<String> stopWords,
            int correctWordCount,
            int uniqueWordCount,
            float averageWordLength,
            List<String> wordIndex
    ) {
        _inputText = inputText;
        _stopWords = stopWords;
        _correctWordCount = correctWordCount;
        _uniqueWordCount = uniqueWordCount;
        _averageWordLength = averageWordLength;
        _wordIndex = wordIndex;
    }

    public void putDelimiterIntoText(String delimiter) {
        List<String> delimitedText = new ArrayList<>();
        for (String line : _inputText) {
            delimitedText.add(line.replace(" ", delimiter));
        }
        _inputText = delimitedText;
    }

    public TestInput clone() {
        return new TestInput(
                this._inputText,
                this._stopWords,
                this._correctWordCount,
                this._uniqueWordCount,
                this._averageWordLength,
                this._wordIndex
        );
    }
}
