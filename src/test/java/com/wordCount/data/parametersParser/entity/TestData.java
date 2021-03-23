package com.wordCount.data.parametersParser.entity;


public class TestData implements Cloneable {

    private TestInput testInput;

    public TestInput getTestInput() {
        return testInput;
    }

    private ExpectedOutput expectedOutput;

    public ExpectedOutput getExpectedOutput() {
        return expectedOutput;
    }


    public TestData(TestInput testInput, ExpectedOutput expectedOutput) {
        this.testInput = testInput;
        this.expectedOutput = expectedOutput;
    }


    public static TestData data(
            String fileName,
            String indexOption,
            String dictionaryOption,
            String expectedTextFileName,
            boolean expectedIncludeWordsIndex,
            String expectedDictionaryFileName
    ) {
        return new TestData(
                new TestInput(
                        fileName,
                        indexOption,
                        dictionaryOption
                ),
                new ExpectedOutput(
                        expectedTextFileName,
                        expectedIncludeWordsIndex,
                        expectedDictionaryFileName
                )
        );
    }
}
