package com.wordCount.mocks;

import com.wordcount.readers.UserInputReader;

public class UserInputReaderStub implements UserInputReader {

    private String inputText;

    @Override
    public String read() {
        return inputText;
    }

    public void setup(String inputText) {
        this.inputText = inputText;
    }
}
