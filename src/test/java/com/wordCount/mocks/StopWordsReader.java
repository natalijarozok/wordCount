package com.wordCount.mocks;


import com.wordcount.interfaces.InputReader;

import java.util.List;

public class StopWordsReader implements InputReader {

    private List<String> stopWords;

    @Override
    public List<String> read() {
        return stopWords;
    }

    public void contain(List<String> stopWords) {
        this.stopWords = stopWords;
    }
}
