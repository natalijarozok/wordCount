package com.wordCount.mocks;

import com.wordcount.readers.InputTextReader;

public class ConsoleTextReaderStub implements InputTextReader {

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
