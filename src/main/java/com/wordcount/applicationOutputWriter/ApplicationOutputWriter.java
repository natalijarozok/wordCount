package com.wordcount.applicationOutputWriter;

import com.wordcount.interfaces.OutputSource;
import com.wordcount.interfaces.OutputWriter;

public class ApplicationOutputWriter implements OutputWriter {

    private final OutputSource writer;

    public ApplicationOutputWriter(OutputSource writer) {
        this.writer = writer;
    }

    @Override
    public void write(String text) {
        writer.write(String.format("Number of words: %s", text));
    }
}
