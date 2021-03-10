package com.wordCount.mock;

import com.wordcount.writer.ConsoleWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleWriterSpy implements ConsoleWriter {

    private String _outputText;


    @Override
    public void write(String outputText) {
        _outputText = outputText;
    }

    public void shouldWriteText(String text) {
        assertEquals(text, _outputText);
    }
}
