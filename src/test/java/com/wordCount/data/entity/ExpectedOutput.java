package com.wordCount.data.entity;

public class ExpectedOutput {
    private final Long expectedWordCount;

    public Long getExpectedWordCount() {
        return expectedWordCount;
    }

    public ExpectedOutput(Long expectedWordCount) {
        this.expectedWordCount = expectedWordCount;
    }
}
