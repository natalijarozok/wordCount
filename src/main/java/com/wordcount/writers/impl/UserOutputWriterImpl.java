package com.wordcount.writers.impl;

import com.wordcount.writers.UserOutputWriter;
import com.wordcount.writers.ConsoleWriter;

public class UserOutputWriterImpl implements UserOutputWriter {

    private ConsoleWriter writer;

    public UserOutputWriterImpl(ConsoleWriter writer) {
        this.writer = writer;
    }

    @Override
    public void write(long wordCount) {
        writer.write(String.format("Number of words: %d", wordCount));
    }
}
