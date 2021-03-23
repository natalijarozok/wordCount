package com.wordCount.mocks;

import com.wordcount.readers.StopWordsReader;

import java.util.List;

public class StopWordsReaderStub implements StopWordsReader {

    private List<String> stopWords;

    @Override
    public List<String> read() {
        return stopWords;
    }

    public void setup(List<String> stopWords) {
        this.stopWords = stopWords;
    }
}
