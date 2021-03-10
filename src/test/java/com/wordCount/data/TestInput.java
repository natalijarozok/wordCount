package com.wordCount.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestInput {

    private static final List<String> TOKEN_DELIMITERS = Arrays.asList(" ", ".");

    public List<TestDataStructure> get() {
        List<TestDataStructure> testDataCollection = TestDataSource.getData();
        testDataCollection = getTestDataCollectionWithDelimitersCombinations(testDataCollection);
        testDataCollection = getTestDataCollectionWithIncludeWordIndex(testDataCollection, true);
        testDataCollection = getTestDataCollectionWithIncludeWordIndex(testDataCollection, false);
        return testDataCollection;
    }

    private static List<TestDataStructure> getTestDataCollectionWithDelimitersCombinations(
            List<TestDataStructure> testDataCollection
    ) {
        List<TestDataStructure> result = new ArrayList<>();

        for (String delimiter : TOKEN_DELIMITERS) {
            result.addAll(getTestDataCollectionWithDelimiter(testDataCollection, delimiter));
        }

        String joinedDelimiter = String.join("", TOKEN_DELIMITERS);
        result.addAll(getTestDataCollectionWithDelimiter(testDataCollection, joinedDelimiter));

        return result;
    }

    private static List<TestDataStructure> getTestDataCollectionWithDelimiter(
            List<TestDataStructure> testDataCollection,
            String delimiter
    ) {
        List<TestDataStructure> result = new ArrayList<>();
        TestDataStructure testDataCloned;

        for (TestDataStructure testData : testDataCollection) {
            testDataCloned = testData.clone();
            if (testDataCloned.getInputText() != null) {
                testDataCloned.putDelimiterIntoText(delimiter);
            }
            result.add(testDataCloned);
        }
        return result;
    }

    private static List<TestDataStructure> getTestDataCollectionWithIncludeWordIndex(
            List<TestDataStructure> testDataCollection,
            boolean includeWordIndex
    ) {
        List<TestDataStructure> result = new ArrayList<>();
        TestDataStructure testDataCloned;

        for (TestDataStructure testData : testDataCollection) {
            testDataCloned = testData.clone();
            testDataCloned.setIncludeWordIndex(includeWordIndex);
            result.add(testDataCloned);
        }
        return result;
    }
}
