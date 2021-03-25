package com.wordCount.data.entity;

import java.util.Collections;
import java.util.List;

public class TestData {
    private final TestInput testInput;

    public List<String> inputText() {
        return Collections.singletonList(testInput.getInputText());
    }

    public List<String> stopWords() {
        return testInput.getStopWords();
    }

    private final ExpectedOutput expectedOutput;

    public long expectedWordCount() {
        return expectedOutput.getExpectedWordCount();
    }

    public TestData(TestInput input, ExpectedOutput expectedOutput) {
        this.testInput = input;
        this.expectedOutput = expectedOutput;
    }
}
