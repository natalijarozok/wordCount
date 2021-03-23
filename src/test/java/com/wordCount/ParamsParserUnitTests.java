package com.wordCount;

import com.wordCount.data.parametersParser.TestDataSource;
import com.wordCount.data.parametersParser.entity.TestData;
import com.wordcount.paramsParser.ParamsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamsParserUnitTests {

    @Test
    public void parameters_parsing() {
        TestDataSource.getTestData().forEach(this::assertParametersParsingIsCorrect);
    }

    private String[] buildArgs(String fileName, String indexOption, String dictionaryOption) {
        List<String> args = new ArrayList<>();
        if (fileName != null)
            args.add(fileName);
        if (indexOption != null)
            args.add(indexOption);
        if (dictionaryOption != null)
            args.add(dictionaryOption);
        return args.stream().toArray(String[]::new);
    }

    private void assertParametersParsingIsCorrect(TestData testData) {
        String[] args = buildArgs(
                testData.getTestInput().getFileName(),
                testData.getTestInput().getIndexOption(),
                testData.getTestInput().getDictionaryOption()
        );

        ParamsParser sut = new ParamsParser(args);
        sut.parse();

        assertEquals(testData.getExpectedOutput().getExpectedTextFileName(), sut.getTextFileName());
        assertEquals(testData.getExpectedOutput().getExpectedIncludeWordsIndex(), sut.getIncludeWordsIndex());
        assertEquals(testData.getExpectedOutput().getExpectedDictionaryFileName(), sut.getDictionaryFileName());
    }

}
