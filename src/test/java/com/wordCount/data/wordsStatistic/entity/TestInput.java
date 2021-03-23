package com.wordCount.data.wordsStatistic.entity;

import java.util.List;

public class TestInput implements Cloneable {

    private List<String> inputText;

    public List<String> getInputText() {
        return inputText;
    }

    private List<String> stopWords;

    public List<String> getStopWords() {
        return stopWords;
    }

    private List<String> dictionaryWords;

    public List<String> getDictionaryWords() {
        return dictionaryWords;
    }

    private boolean includeWordIndex;

    public boolean getIncludeWordIndex() {
        return includeWordIndex;
    }

    public void setIncludeWordIndex(boolean includeWordIndex) {
        this.includeWordIndex = includeWordIndex;
    }

    public TestInput(List<String> inputText, List<String> stopWords, List<String> dictionaryWords) {
        this.inputText = inputText;
        this.stopWords = stopWords;
        this.dictionaryWords = dictionaryWords;
    }


    public void putDelimiterIntoText(String delimiter) {
        for (int i = 0; i < inputText.size(); i++) {
            inputText.set(i, inputText.get(i).replace(" ", delimiter));
        }
    }
}
