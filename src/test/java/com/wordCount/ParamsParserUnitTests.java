package com.wordCount;

import com.wordCount.data.parametersParser.TestDataStructure;
import com.wordCount.data.parametersParser.TestInput;
import com.wordcount.paramsParser.ParamsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamsParserUnitTests {

    @Test
    public void parameters_parsing_is_correct() {
        List<TestDataStructure> testInput = new TestInput().get();
        for (TestDataStructure testData : testInput) {
            checkThatParametersParsingIsCorrect(testData);
        }
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

    private void checkThatParametersParsingIsCorrect(TestDataStructure testData) {
        String[] args = buildArgs(
                testData.getFileName(),
                testData.getIndexOption(),
                testData.getDictionaryOption()
        );

        ParamsParser sut = new ParamsParser(args);
        sut.parse();

        assertEquals(testData.getExpectedTextFileName(), sut.getTextFileName());
        assertEquals(testData.getExpectedIncludeWordsIndex(), sut.getIncludeWordsIndex());
        assertEquals(testData.getExpectedDictionaryFileName(), sut.getDictionaryFileName());
    }

}
