package com.wordCount.mocks;

import java.util.List;

public class ConsoleTextReaderStub implements TextReaderStub {

    private List<String> _inputText;

    @Override
    public List<String> read() {
        return _inputText;
    }

    public void setup(List<String> inputText) {
        _inputText = inputText;
    }

}
