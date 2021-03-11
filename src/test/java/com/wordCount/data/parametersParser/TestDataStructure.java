package com.wordCount.data.parametersParser;

import com.wordcount.domain.dto.WordsStatisticOptions;

public class TestDataStructure {
    private String _fileName;

    public String getFileName() {
        return _fileName;
    }

    private String _indexOption;

    public String getIndexOption() {
        return _indexOption;
    }

    private String _dictionaryOption;

    public String getDictionaryOption() {
        return _dictionaryOption;
    }


    private String _expectedTextFileName;

    public String getExpectedTextFileName() {
        return _expectedTextFileName;
    }


    private WordsStatisticOptions _expectedWordsStatisticOption;

    public WordsStatisticOptions getExpectedWordsStatisticOption() {
        return _expectedWordsStatisticOption;
    }

    private String _expectedDictionaryFileName;

    public String getExpectedDictionaryFileName() {
        return _expectedDictionaryFileName;
    }


    public TestDataStructure(
            String fileName,
            String indexOption,
            String dictionaryOption,
            String expectedTextFileName,
            WordsStatisticOptions expectedWordsStatisticOption,
            String expectedDictionaryFileName
    ) {
        _fileName = fileName;
        _indexOption = indexOption;
        _dictionaryOption = dictionaryOption;
        _expectedTextFileName = expectedTextFileName;
        _expectedWordsStatisticOption = expectedWordsStatisticOption;
        _expectedDictionaryFileName = expectedDictionaryFileName;
    }
}
