package com.wordCount.mocks;

import com.wordcount.readers.StopWordsReader;

import java.util.List;

public class StopWordsReaderStub implements StopWordsReader {

    private List<String> _stopWords;

    @Override
    public List<String> read() {
        return _stopWords;
    }

    public void setup(List<String> stopWords) {
        _stopWords = stopWords;
    }

    ;
}
