package com.wordCount.mock;

import java.util.List;

public class FileTextReaderReaderStub implements TextReaderStub {

    private List<String> _stopWords;

    @Override
    public List<String> read() {
        return _stopWords;
    }

    public void setup(List<String> stopWords) {
        _stopWords = stopWords;
    }

}
