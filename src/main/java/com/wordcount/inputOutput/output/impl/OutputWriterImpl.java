package com.wordcount.inputOutput.output.impl;

import com.wordcount.inputOutput.output.OutputSource;
import com.wordcount.inputOutput.output.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    private final OutputSource writer;

    public OutputWriterImpl(OutputSource writer) {
        this.writer = writer;
    }

    @Override
    public void write(String text) {
        writer.write(String.format("Number of words: %s", text));
    }
}
