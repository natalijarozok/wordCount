package com.wordCount.paramsSource;

import java.util.List;

public class TestParam {
    private String _inputText;

    public String getInputText() {
        return _inputText;
    }

    private List<String> _stopWords;

    public List<String> getStopWords() {
        return _stopWords;
    }

    public TestParam(String inputText, List<String> stopWords) {
        _inputText = inputText;
        _stopWords = stopWords;
    }
}
