package com.wordCount.data.entity;

import java.util.List;

public class TestInput {
    private final String inputText;

    public final String getInputText() {
        return inputText;
    }

    private final List<String> stopWords;

    public List<String> getStopWords() {
        return stopWords;
    }

    public TestInput(String inputText, List<String> stopWords) {
        this.inputText = inputText;
        this.stopWords = stopWords;
    }
}
