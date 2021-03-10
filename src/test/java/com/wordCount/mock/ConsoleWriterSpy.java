package com.wordCount.mock;

import com.wordcount.writer.ConsoleWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleWriterSpy implements ConsoleWriter {

    private String _actualText;


    @Override
    public void write(String outputText) {
        _actualText = outputText;
    }

    public void shouldWriteText(String expectedText) {
        assertEquals(expectedText, _actualText);
    }
}
