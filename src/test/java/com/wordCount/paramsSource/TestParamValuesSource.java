package com.wordCount.paramsSource;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TestParamValuesSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    public static HashMap<Pair<String, List<String>>, Integer> getTextParamValues() {
        return new HashMap<Pair<String, List<String>>, Integer>() {{
            put(new Pair<>("Mary had a little lamb", STOP_WORDS_EMPTY), 5);
            put(new Pair<>("Mary ", STOP_WORDS_EMPTY), 1);
            put(new Pair<>("Mary", STOP_WORDS_EMPTY), 1);
            put(new Pair<>("Mary 1", STOP_WORDS_EMPTY), 1);
            put(new Pair<>("Mary1", STOP_WORDS_EMPTY), 0);
            put(new Pair<>("Mary@", STOP_WORDS_EMPTY), 0);
            put(new Pair<>("1 @", STOP_WORDS_EMPTY), 0);
            put(new Pair<>("1 ", STOP_WORDS_EMPTY), 0);
            put(new Pair<>("1", STOP_WORDS_EMPTY), 0);
            put(new Pair<>("@ ", STOP_WORDS_EMPTY), 0);
            put(new Pair<>("@", STOP_WORDS_EMPTY), 0);
            put(new Pair<>(" ", STOP_WORDS_EMPTY), 0);
            put(new Pair<>("", STOP_WORDS_EMPTY), 0);

            put(new Pair<>("Mary had a little lamb", STOP_WORDS), 4);
            put(new Pair<>("the", STOP_WORDS), 0);
            put(new Pair<>("on", STOP_WORDS), 0);
            put(new Pair<>("off", STOP_WORDS), 0);
            put(new Pair<>("Mary 1", STOP_WORDS), 1);
            put(new Pair<>("Mary1", STOP_WORDS), 0);
            put(new Pair<>("Mary@", STOP_WORDS), 0);
            put(new Pair<>("1 @", STOP_WORDS), 0);
            put(new Pair<>("1 ", STOP_WORDS), 0);
            put(new Pair<>("1", STOP_WORDS), 0);
            put(new Pair<>("@ ", STOP_WORDS), 0);
            put(new Pair<>("@", STOP_WORDS), 0);
            put(new Pair<>(" ", STOP_WORDS), 0);
            put(new Pair<>("", STOP_WORDS), 0);

            put(new Pair<>("", null), 0);
        }};
    }
}
