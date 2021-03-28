package com.wordcount.inputOutput.input.impl;

import com.wordcount.inputOutput.input.InputReader;
import com.wordcount.inputOutput.input.InputSource;

import java.util.List;

public class InputResourcesReader implements InputReader {

    private final InputSource reader;

    public InputResourcesReader(InputSource reader) {
        this.reader = reader;
    }

    @Override
    public List<String> read() {
        return reader.read();
    }
}
