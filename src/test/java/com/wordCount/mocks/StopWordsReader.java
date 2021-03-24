package com.wordCount.mocks;

import java.util.List;

public class StopWordsReader implements com.wordcount.inputOutput.input.StopWordsReader {

    private List<String> stopWords;

    @Override
    public List<String> read() {
        return stopWords;
    }

    public void contain(List<String> stopWords) {
        this.stopWords = stopWords;
    }
}
