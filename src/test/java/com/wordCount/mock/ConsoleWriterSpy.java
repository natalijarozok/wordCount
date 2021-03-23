package com.wordCount.mock;

import com.wordCount.data.wordsStatistic.entity.TestData;
import com.wordcount.writer.ConsoleWriter;

import static com.wordCount.data.wordsStatistic.TestDataSource.errorMessageFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleWriterSpy implements ConsoleWriter {

    private String _actualText;


    @Override
    public void write(String outputText) {
        _actualText = outputText;
    }

    public void shouldWriteText(TestData testData, String expectedOutputText) {
        assertEquals(expectedOutputText, _actualText, errorMessageFor(testData, expectedOutputText));
    }
}
