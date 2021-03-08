package com.wordCount.paramsSource;

import java.util.List;

public class TestParam {
    private List<String> _inputText;

    public List<String> getInputText() {
        return _inputText;
    }

    private List<String> _stopWords;

    public List<String> getStopWords() {
        return _stopWords;
    }

    public TestParam(List<String> inputText, List<String> stopWords) {
        _inputText = inputText;
        _stopWords = stopWords;
    }
}
