package com.wordCount.data.parametersParser.entity;

public class TestInput {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    private String indexOption;

    public String getIndexOption() {
        return indexOption;
    }

    private String dictionaryOption;

    public String getDictionaryOption() {
        return dictionaryOption;
    }


    public TestInput(
            String fileName,
            String indexOption,
            String dictionaryOption
    ) {
        this.fileName = fileName;
        this.indexOption = indexOption;
        this.dictionaryOption = dictionaryOption;
    }
}
