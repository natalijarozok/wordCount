package com.wordCount.paramsSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TestParamValuesSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    public static HashMap<TestParam, Integer> getTextParamValues() {
        return new HashMap<TestParam, Integer>() {{
            put(new TestParam(Arrays.asList("Mary had a little lamb"), STOP_WORDS_EMPTY), 5);
            put(new TestParam(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS_EMPTY), 5);
            put(new TestParam(Arrays.asList("Mary "), STOP_WORDS_EMPTY), 1);
            put(new TestParam(Arrays.asList("Mary"), STOP_WORDS_EMPTY), 1);
            put(new TestParam(Arrays.asList("Mary 1"), STOP_WORDS_EMPTY), 1);
            put(new TestParam(Arrays.asList("Mary1"), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList("Mary @"), STOP_WORDS_EMPTY), 1);
            put(new TestParam(Arrays.asList("Mary@"), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList("1 @"), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList("1 "), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList("1"), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList("@ "), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList("@"), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList(" "), STOP_WORDS_EMPTY), 0);
            put(new TestParam(Arrays.asList(""), STOP_WORDS_EMPTY), 0);
            put(new TestParam(null, STOP_WORDS_EMPTY), 0);

            put(new TestParam(Arrays.asList("Mary had a little lamb"), STOP_WORDS), 4);
            put(new TestParam(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS), 4);
            put(new TestParam(Arrays.asList("the"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("on"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("off"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("Mary 1"), STOP_WORDS), 1);
            put(new TestParam(Arrays.asList("Mary1"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("Mary @"), STOP_WORDS), 1);
            put(new TestParam(Arrays.asList("Mary@"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("1 @"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("1 "), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("1"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("@ "), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList("@"), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList(" "), STOP_WORDS), 0);
            put(new TestParam(Arrays.asList(""), STOP_WORDS), 0);
            put(new TestParam(null, STOP_WORDS), 0);

            put(new TestParam(Arrays.asList("Mary had a little lamb"), null), 5);
            put(new TestParam(Arrays.asList("Mary had", "a little", "lamb"), null), 5);
            put(new TestParam(Arrays.asList("Mary "), null), 1);
            put(new TestParam(Arrays.asList("Mary"), null), 1);
            put(new TestParam(Arrays.asList("Mary 1"), null), 1);
            put(new TestParam(Arrays.asList("Mary1"), null), 0);
            put(new TestParam(Arrays.asList("Mary @"), null), 1);
            put(new TestParam(Arrays.asList("Mary@"), null), 0);
            put(new TestParam(Arrays.asList("1 @"), null), 0);
            put(new TestParam(Arrays.asList("1 "), null), 0);
            put(new TestParam(Arrays.asList("1"), null), 0);
            put(new TestParam(Arrays.asList("@ "), null), 0);
            put(new TestParam(Arrays.asList("@"), null), 0);
            put(new TestParam(Arrays.asList(" "), null), 0);
            put(new TestParam(Arrays.asList(""), null), 0);
            put(new TestParam(null, null), 0);

        }};
    }
}
