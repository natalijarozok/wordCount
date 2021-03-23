package com.wordCount.data.entity;

public class TestData {
    private final TestInput testInput;

    public TestInput getTestInput() {
        return testInput;
    }

    private final ExpectedOutput expectedOutput;

    public ExpectedOutput getExpectedOutput() {
        return expectedOutput;
    }

    public TestData(TestInput input, ExpectedOutput expectedOutput) {
        this.testInput = input;
        this.expectedOutput = expectedOutput;
    }
}
