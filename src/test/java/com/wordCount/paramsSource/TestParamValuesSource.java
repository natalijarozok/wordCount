package com.wordCount.paramsSource;

import java.util.*;

public class TestParamValuesSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    public static HashMap<TestParam, Integer> getTextParamValues() {
        return new HashMap<TestParam, Integer>() {{
            put(new TestParam("Mary had a little lamb", STOP_WORDS_EMPTY), 5);
            put(new TestParam("Mary ", STOP_WORDS_EMPTY), 1);
            put(new TestParam("Mary", STOP_WORDS_EMPTY), 1);
            put(new TestParam("Mary 1", STOP_WORDS_EMPTY), 1);
            put(new TestParam("Mary1", STOP_WORDS_EMPTY), 0);
            put(new TestParam("Mary@", STOP_WORDS_EMPTY), 0);
            put(new TestParam("1 @", STOP_WORDS_EMPTY), 0);
            put(new TestParam("1 ", STOP_WORDS_EMPTY), 0);
            put(new TestParam("1", STOP_WORDS_EMPTY), 0);
            put(new TestParam("@ ", STOP_WORDS_EMPTY), 0);
            put(new TestParam("@", STOP_WORDS_EMPTY), 0);
            put(new TestParam(" ", STOP_WORDS_EMPTY), 0);
            put(new TestParam("", STOP_WORDS_EMPTY), 0);
            put(new TestParam(null, STOP_WORDS_EMPTY), 0);

            put(new TestParam("Mary had a little lamb", STOP_WORDS), 4);
            put(new TestParam("the", STOP_WORDS), 0);
            put(new TestParam("on", STOP_WORDS), 0);
            put(new TestParam("off", STOP_WORDS), 0);
            put(new TestParam("Mary 1", STOP_WORDS), 1);
            put(new TestParam("Mary1", STOP_WORDS), 0);
            put(new TestParam("Mary@", STOP_WORDS), 0);
            put(new TestParam("1 @", STOP_WORDS), 0);
            put(new TestParam("1 ", STOP_WORDS), 0);
            put(new TestParam("1", STOP_WORDS), 0);
            put(new TestParam("@ ", STOP_WORDS), 0);
            put(new TestParam("@", STOP_WORDS), 0);
            put(new TestParam(" ", STOP_WORDS), 0);
            put(new TestParam("", STOP_WORDS), 0);
            put(new TestParam(null, STOP_WORDS), 0);

            put(new TestParam("Mary had a little lamb", null), 5);
            put(new TestParam("Mary ", null), 1);
            put(new TestParam("Mary", null), 1);
            put(new TestParam("Mary 1", null), 1);
            put(new TestParam("Mary1", null), 0);
            put(new TestParam("Mary@", null), 0);
            put(new TestParam("1 @", null), 0);
            put(new TestParam("1 ", null), 0);
            put(new TestParam("1", null), 0);
            put(new TestParam("@ ", null), 0);
            put(new TestParam("@", null), 0);
            put(new TestParam(" ", null), 0);
            put(new TestParam("", null), 0);
            put(new TestParam(null, null), 0);

        }};
    }
}
