package com.wordCount.mocks;

import com.wordcount.readers.ConsoleTextReader;

public class ConsoleTextReaderStub implements ConsoleTextReader {

    private String _inputText;

    @Override
    public String read() {
        return _inputText;
    }

    public void setup(String inputText) {
        _inputText = inputText;
    }

    ;
}
