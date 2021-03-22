package com.wordCount.mocks;

import com.wordCount.data.entity.TestInput;
import com.wordcount.writers.ConsoleWriter;

import static com.wordCount.data.DataSource.errorMessageFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleWriterSpy implements ConsoleWriter {

    private String outputText;
    private TestInput testInput;

    @Override
    public void write(String outputText) {
        this.outputText = outputText;
    }

    public ConsoleWriterSpy withInput(TestInput testInput) {
        this.testInput = testInput;
        return this;
    }

    public void shouldWrite(String expectedOutputText) {
        assertEquals(expectedOutputText, outputText, errorMessageFor(testInput, expectedOutputText));
    }
}
