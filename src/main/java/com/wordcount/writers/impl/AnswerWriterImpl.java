package com.wordcount.writers.impl;

import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.ConsoleWriter;

public class AnswerWriterImpl implements AnswerWriter {

    private ConsoleWriter _writer = new ConsoleWriterImpl();

    public AnswerWriterImpl(ConsoleWriter writer) {
        _writer = writer;
    }

    @Override
    public void write(int wordCount) {
        _writer.write(String.format("Number of words: %d", wordCount));
    }
}
