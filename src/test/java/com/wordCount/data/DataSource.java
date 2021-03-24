package com.wordCount.data;

import com.wordCount.data.entity.ExpectedOutput;
import com.wordCount.data.entity.TestData;
import com.wordCount.data.entity.TestInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class DataSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    public static List<TestData> getData() {
        return new ArrayList<TestData>() {{
            add(testData("Mary had a little lamb", STOP_WORDS_EMPTY, 5));
            add(testData("Mary ", STOP_WORDS_EMPTY, 1));
            add(testData("Mary", STOP_WORDS_EMPTY, 1));
            add(testData("Mary 1", STOP_WORDS_EMPTY, 1));
            add(testData("Mary1", STOP_WORDS_EMPTY, 0));
            add(testData("Mary@", STOP_WORDS_EMPTY, 0));
            add(testData("1 @", STOP_WORDS_EMPTY, 0));
            add(testData("1 ", STOP_WORDS_EMPTY, 0));
            add(testData("1", STOP_WORDS_EMPTY, 0));
            add(testData("@ ", STOP_WORDS_EMPTY, 0));
            add(testData("@", STOP_WORDS_EMPTY, 0));
            add(testData(" ", STOP_WORDS_EMPTY, 0));
            add(testData("", STOP_WORDS_EMPTY, 0));

            add(testData("Mary had a little lamb", STOP_WORDS, 4));
            add(testData("the", STOP_WORDS, 0));
            add(testData("on", STOP_WORDS, 0));
            add(testData("off", STOP_WORDS, 0));
            add(testData("Mary 1", STOP_WORDS, 1));
            add(testData("Mary1", STOP_WORDS, 0));
            add(testData("Mary@", STOP_WORDS, 0));
            add(testData("1 @", STOP_WORDS, 0));
            add(testData("1 ", STOP_WORDS, 0));
            add(testData("1", STOP_WORDS, 0));
            add(testData("@ ", STOP_WORDS, 0));
            add(testData("@", STOP_WORDS, 0));
            add(testData(" ", STOP_WORDS, 0));
            add(testData("", STOP_WORDS, 0));

            add(testData("Mary had a little lamb", null, 5));
            add(testData("Mary ", null, 1));
            add(testData("Mary", null, 1));
            add(testData("Mary 1", null, 1));
            add(testData("Mary1", null, 0));
            add(testData("Mary@", null, 0));
            add(testData("1 @", null, 0));
            add(testData("1 ", null, 0));
            add(testData("1", null, 0));
            add(testData("@ ", null, 0));
            add(testData("@", null, 0));
            add(testData(" ", null, 0));
            add(testData("", null, 0));

        }};
    }

    private static TestData testData(String inputText, List<String> stopWords, long expectedWordCount) {
        return new TestData(
                new TestInput(inputText, stopWords),
                new ExpectedOutput(expectedWordCount)
        );
    }

    public static String errorMessageFor(TestData testData) {
        return format("Input text: '%s' with stopWords '%s' is expected to contain '%d' words",
                testData.inputText(),
                testData.stopWords(),
                testData.expectedWordCount()
        );
    }

    public static String errorMessageFor(TestData testData, String expectedOutputText) {
        return format("For given input text: '%s' with stopWords '%s' following output text: '%s' is expected",
                testData.inputText(),
                testData.stopWords(),
                expectedOutputText
        );
    }
}
