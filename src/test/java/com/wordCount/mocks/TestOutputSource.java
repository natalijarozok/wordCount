package com.wordCount.mocks;

import com.wordCount.data.entity.TestData;
import com.wordcount.inputOutput.output.OutputSource;

import static com.wordCount.data.DataSource.errorMessageFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOutputSource implements OutputSource {

    private String outputText;
    private TestData testData;

    @Override
    public void write(String outputText) {
        this.outputText = outputText;
    }

    public TestOutputSource forUserInput(TestData testData) {
        this.testData = testData;
        return this;
    }

    public void writes(String expectedOutputText) {
        assertEquals(expectedOutputText, outputText, errorMessageFor(testData, expectedOutputText));
    }
}
