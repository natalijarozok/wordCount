package com.wordcount.inputOutput.input.impl;

import com.wordcount.inputOutput.input.UserInputReader;
import com.wordcount.inputOutput.input.UserInputSource;

public class UserInputReaderImpl implements UserInputReader {

    private UserInputSource reader;

    public UserInputReaderImpl(UserInputSource reader) {
        this.reader = reader;
    }

    @Override
    public String read() {
        return reader.read();
    }
}
