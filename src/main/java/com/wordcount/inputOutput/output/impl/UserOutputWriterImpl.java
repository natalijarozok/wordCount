package com.wordcount.inputOutput.output.impl;

import com.wordcount.inputOutput.output.UserOutputSource;
import com.wordcount.inputOutput.output.UserOutputWriter;

public class UserOutputWriterImpl implements UserOutputWriter {

    private UserOutputSource writer;

    public UserOutputWriterImpl(UserOutputSource writer) {
        this.writer = writer;
    }

    @Override
    public void write(String text) {
        writer.write(String.format("Number of words: %s", text));
    }
}
