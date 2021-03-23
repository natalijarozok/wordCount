package com.wordCount.data.wordsStatistic;

import com.wordCount.data.wordsStatistic.dataSource.*;
import com.wordCount.data.wordsStatistic.entity.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class TestDataSource {

    private static final List<String> TOKEN_DELIMITERS = Arrays.asList(" ", ".");

    public static List<TestData> getTestData() {
        List<TestData> testData = getWithDelimiterCombinationsAndRequestingToShowWordIndex();
        testData.addAll(getWithDelimiterCombinationsAndNotRequestingToShowWordIndex());
        return testData;
    }

    private static List<TestData> getData() {
        List<TestData> data = new ArrayList<>();

        data.addAll(Empty_Dictionary_Empty_Stop_Words.getData());
        data.addAll(Empty_Dictionary_Filled_Stop_Words.getData());
        data.addAll(Empty_Dictionary_Null_Stop_Words.getData());

        data.addAll(Filled_Dictionary_Empty_Stop_Words.getData());
        data.addAll(Filled_Dictionary_Filled_Stop_Words.getData());
        data.addAll(Filled_Dictionary_Null_Stop_Words.getData());

        data.addAll(Null_Dictionary_Empty_Stop_Words.getData());
        data.addAll(Null_Dictionary_Filled_Stop_Words.getData());
        data.addAll(Null_Dictionary_Null_Stop_Words.getData());

        return data;
    }

    private static List<TestData> getWithDelimitersCombinations() {
        List<String> delimiters = new ArrayList<>(TOKEN_DELIMITERS);
        delimiters.add(String.join("", TOKEN_DELIMITERS));

        return delimiters.stream()
                .map(TestDataSource::getWithDelimiter)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<TestData> getWithDelimiter(String delimiter) {
        List<TestData> testData = getData();
        testData.stream()
                .filter(data -> data.getTestInput().getInputText() != null)
                .forEach(data -> data.getTestInput().putDelimiterIntoText(delimiter));
        return testData;
    }

    private static List<TestData> getWithDelimiterCombinationsAndRequestingToShowWordIndex() {
        List<TestData> testData = getWithDelimitersCombinations();
        testData.forEach(data -> data.getTestInput().setIncludeWordIndex(true));
        return testData;
    }

    private static List<TestData> getWithDelimiterCombinationsAndNotRequestingToShowWordIndex() {
        List<TestData> testData = getWithDelimitersCombinations();
        testData.forEach(data -> {
            data.getTestInput().setIncludeWordIndex(false);
            data.getExpectedOutput().setExpectedRawWordIndex(null);
        });
        return testData;
    }

    public static String errorMessageFor(TestData testData) {
        return format("Input text: '%s' " +
                        "with stopWords '%s' " +
                        "and dictionary '%s' " +
                        "and includeWordIndex '%s' " +
                        "is expected to contain '%d' words " +
                        "and '%d' unique words " +
                        "and '%f' average word length " +
                        "and '%d' unknown words " +
                        "and '%s' word index ",
                testData.getTestInput().getInputText(),
                testData.getTestInput().getStopWords(),
                testData.getTestInput().getDictionaryWords(),
                testData.getTestInput().getIncludeWordIndex(),
                testData.getExpectedOutput().getExpectedCorrectWordCount(),
                testData.getExpectedOutput().getExpectedUniqueWordCount(),
                testData.getExpectedOutput().getExpectedAverageWordLength(),
                testData.getExpectedOutput().getExpectedUnknownWordCount(),
                testData.getExpectedOutput().getExpectedRawWordIndex() != null ?
                        testData.getExpectedOutput().getExpectedRawWordIndex().toString() :
                        testData.getExpectedOutput().getExpectedRawWordIndex()
        );
    }

    public static String errorMessageFor(TestData testData, String expectedOutputText) {
        return format("For given input text: '%s' " +
                        "with stopWords '%s' " +
                        "and dictionary '%s' " +
                        "and includeWordIndex '%s' " +
                        "the following output text is expected: '%s'",
                testData.getTestInput().getInputText(),
                testData.getTestInput().getStopWords(),
                testData.getTestInput().getDictionaryWords(),
                testData.getTestInput().getIncludeWordIndex(),
                expectedOutputText
        );
    }
}
