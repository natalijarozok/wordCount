package com.wordCount.data.parametersParser.entity;

public class ExpectedOutput {

    private String expectedTextFileName;

    public String getExpectedTextFileName() {
        return expectedTextFileName;
    }

    private boolean expectedIncludeWordsIndex;

    public boolean getExpectedIncludeWordsIndex() {
        return expectedIncludeWordsIndex;
    }

    private String expectedDictionaryFileName;

    public String getExpectedDictionaryFileName() {
        return expectedDictionaryFileName;
    }

    public ExpectedOutput(
            String expectedTextFileName,
            boolean expectedIncludeWordsIndex,
            String expectedDictionaryFileName
    ) {
        this.expectedTextFileName = expectedTextFileName;
        this.expectedIncludeWordsIndex = expectedIncludeWordsIndex;
        this.expectedDictionaryFileName = expectedDictionaryFileName;

    }
}
