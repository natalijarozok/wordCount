package com.wordCount.paramsSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestInputValuesSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    private static final List<String> TOKEN_DELIMITERS = Arrays.asList(" ", ".");

    public static List<TestInput> getTestInputValuesWithDelimiters() {
        List<TestInput> resultInputs = new ArrayList<>();

        for (String delimiter : TOKEN_DELIMITERS) {
            resultInputs.addAll(getTestInputValuesWithDelimiter(delimiter));
        }

        String joinedDelimiter = String.join("", TOKEN_DELIMITERS);
        resultInputs.addAll(getTestInputValuesWithDelimiter(joinedDelimiter));

        return resultInputs;
    }

    private static List<TestInput> getTestInputValuesWithDelimiter(String delimiter) {
        List<TestInput> baseInputs = getBaseTestInputValues();
        List<TestInput> resultInputs = new ArrayList<>();
        TestInput inputCloned;

        for (TestInput input : baseInputs) {
            inputCloned = input.clone();
            if (input.getInputText() != null) {
                inputCloned.putDelimiterIntoText(delimiter);
            }
            resultInputs.add(inputCloned);
        }
        return resultInputs;
    }

    public static List<TestInput> getBaseTestInputValues() {
        return new ArrayList<TestInput>() {{
            add(new TestInput(Arrays.asList("Mary had a little lamb"), STOP_WORDS_EMPTY, 5, 5, 3.6f));
            add(new TestInput(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS_EMPTY, 5, 5, 3.6f));
            add(new TestInput(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS_EMPTY, 10, 8, 4.9f));
            add(new TestInput(Arrays.asList("Mary "), STOP_WORDS_EMPTY, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary"), STOP_WORDS_EMPTY, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, 1, 1, 5f));
            add(new TestInput(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, 1, 1, 5f));
            add(new TestInput(Arrays.asList("- "), STOP_WORDS_EMPTY, 1, 1, 1f));
            add(new TestInput(Arrays.asList("-"), STOP_WORDS_EMPTY, 1, 1, 1f));
            add(new TestInput(Arrays.asList("Mary 1"), STOP_WORDS_EMPTY, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary1"), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList("Mary @"), STOP_WORDS_EMPTY, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary@"), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList("1 @"), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList("1 "), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList("1"), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList("@ "), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList("@"), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList(" "), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(Arrays.asList(""), STOP_WORDS_EMPTY, 0, 0));
            add(new TestInput(null, STOP_WORDS_EMPTY, 0, 0));

            add(new TestInput(Arrays.asList("Mary had a little lamb"), STOP_WORDS, 4, 4, 4.25f));
            add(new TestInput(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS, 4, 4, 4.25f));
            add(new TestInput(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS, 7, 6, 6.43f));
            add(new TestInput(Arrays.asList("Mary "), STOP_WORDS, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary"), STOP_WORDS, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, 1, 1, 5f));
            add(new TestInput(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, 1, 1, 5f));
            add(new TestInput(Arrays.asList("- "), STOP_WORDS_EMPTY, 1, 1, 1f));
            add(new TestInput(Arrays.asList("-"), STOP_WORDS_EMPTY, 1, 1, 1f));
            add(new TestInput(Arrays.asList("Mary 1"), STOP_WORDS, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary1"), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList("Mary @"), STOP_WORDS, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary@"), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList("1 @"), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList("1 "), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList("1"), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList("@ "), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList("@"), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList(" "), STOP_WORDS, 0, 0));
            add(new TestInput(Arrays.asList(""), STOP_WORDS, 0, 0));
            add(new TestInput(null, STOP_WORDS, 0, 0));

            add(new TestInput(Arrays.asList("Mary had a little lamb"), null, 5, 5, 3.6f));
            add(new TestInput(Arrays.asList("Mary had", "a little", "lamb"), null, 5, 5, 3.6f));
            add(new TestInput(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), null, 10, 8, 4.9f));
            add(new TestInput(Arrays.asList("Mary "), null, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary"), null, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, 1, 1, 5f));
            add(new TestInput(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, 1, 1, 5f));
            add(new TestInput(Arrays.asList("- "), STOP_WORDS_EMPTY, 1, 1, 1f));
            add(new TestInput(Arrays.asList("-"), STOP_WORDS_EMPTY, 1, 1, 1f));
            add(new TestInput(Arrays.asList("Mary 1"), null, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary1"), null, 0, 0));
            add(new TestInput(Arrays.asList("Mary @"), null, 1, 1, 4f));
            add(new TestInput(Arrays.asList("Mary@"), null, 0, 0));
            add(new TestInput(Arrays.asList("1 @"), null, 0, 0));
            add(new TestInput(Arrays.asList("1 "), null, 0, 0));
            add(new TestInput(Arrays.asList("1"), null, 0, 0));
            add(new TestInput(Arrays.asList("@ "), null, 0, 0));
            add(new TestInput(Arrays.asList("@"), null, 0, 0));
            add(new TestInput(Arrays.asList(" "), null, 0, 0));
            add(new TestInput(Arrays.asList(""), null, 0, 0));
            add(new TestInput(null, null, 0, 0));
        }};
    }
}
