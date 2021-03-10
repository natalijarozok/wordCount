package com.wordCount.mock;

import java.util.List;

public class StopWordsReaderStub implements TextReaderStub {

    private List<String> _stopWords;

    @Override
    public List<String> read() {
        return _stopWords;
    }

    @Override
    public void setup(List<String> stopWords) {
        _stopWords = stopWords;
    }

}
