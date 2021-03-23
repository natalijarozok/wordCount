package com.wordcount.readers.impl;

import com.wordcount.readers.ConsoleReader;
import com.wordcount.readers.UserInputReader;

public class UserInputReaderImpl implements UserInputReader {

    private ConsoleReader reader;

    public UserInputReaderImpl(ConsoleReader reader) {
        this.reader = reader;
    }

    @Override
    public String read() {
        return reader.read();
    }
}
