package com.wordCount.mock;

import java.util.List;

public class DictionaryReaderStub implements TextReaderStub {

    private List<String> _dictionaryWords;

    @Override
    public List<String> read() {
        return _dictionaryWords;
    }

    @Override
    public void setup(List<String> dictionaryWords) {
        _dictionaryWords = dictionaryWords;
    }

}
