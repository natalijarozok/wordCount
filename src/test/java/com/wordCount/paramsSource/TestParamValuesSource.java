package com.wordCount.paramsSource;

import java.util.HashMap;

public class TestParamValuesSource {
    public static HashMap<String, Integer> getWordsOnlyParamValues() {
        return new HashMap<String, Integer>() {{
            put("Mary had a little lamb", 5);
            put("Mary ", 1);
            put("Mary", 1);
        }};
    }

    public static HashMap<String, Integer> getNonWordsParamValues() {
        return new HashMap<String, Integer>() {{
            put("Mary 1", 1);
            put("Mary1", 0);
            put("Mary@", 0);
            put("1 @", 0);
            put("1 ", 0);
            put("1", 0);
            put("@ ", 0);
            put("@", 0);
            put(" ", 0);
            put("", 0);
            put(null, 0);
        }};
    }
}
