package com.wordCount.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestDataSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    public static List<TestDataStructure> getData() {
        return new ArrayList<TestDataStructure>() {{
            add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS_EMPTY, 5, 5, 3.6f, Arrays.asList("Mary", "had", "a", "little", "lamb")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS_EMPTY, 5, 5, 3.6f, Arrays.asList("Mary", "had", "a", "little", "lamb")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS_EMPTY, 10, 8, 4.9f, Arrays.asList("Humpty-Dumpty", "sat", "on", "a", "wall", "Humpty-Dumpty", "had", "a", "great", "fall")));
            add(data(Arrays.asList("Mary "), STOP_WORDS_EMPTY, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary"), STOP_WORDS_EMPTY, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, 1, 1, 5f, Arrays.asList("Mary-")));
            add(data(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, 1, 1, 5f, Arrays.asList("Mary-")));
            add(data(Arrays.asList("- "), STOP_WORDS_EMPTY, 1, 1, 1f, Arrays.asList("-")));
            add(data(Arrays.asList("-"), STOP_WORDS_EMPTY, 1, 1, 1f, Arrays.asList("-")));
            add(data(Arrays.asList("Mary 1"), STOP_WORDS_EMPTY, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary1"), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList("Mary @"), STOP_WORDS_EMPTY, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary@"), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList("1 @"), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList("1 "), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList("1"), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList("@ "), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList("@"), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList(" "), STOP_WORDS_EMPTY, 0, 0));
            add(data(Arrays.asList(""), STOP_WORDS_EMPTY, 0, 0));
            add(data(null, STOP_WORDS_EMPTY, 0, 0));

            add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS, 4, 4, 4.25f, Arrays.asList("Mary", "had", "little", "lamb")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS, 4, 4, 4.25f, Arrays.asList("Mary", "had", "little", "lamb")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS, 7, 6, 6.43f, Arrays.asList("Humpty-Dumpty", "sat", "wall", "Humpty-Dumpty", "had", "great", "fall")));
            add(data(Arrays.asList("Mary "), STOP_WORDS, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary"), STOP_WORDS, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, 1, 1, 5f, Arrays.asList("Mary-")));
            add(data(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, 1, 1, 5f, Arrays.asList("Mary-")));
            add(data(Arrays.asList("- "), STOP_WORDS_EMPTY, 1, 1, 1f, Arrays.asList("-")));
            add(data(Arrays.asList("-"), STOP_WORDS_EMPTY, 1, 1, 1f, Arrays.asList("-")));
            add(data(Arrays.asList("Mary 1"), STOP_WORDS, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary1"), STOP_WORDS, 0, 0));
            add(data(Arrays.asList("Mary @"), STOP_WORDS, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary@"), STOP_WORDS, 0, 0));
            add(data(Arrays.asList("1 @"), STOP_WORDS, 0, 0));
            add(data(Arrays.asList("1 "), STOP_WORDS, 0, 0));
            add(data(Arrays.asList("1"), STOP_WORDS, 0, 0));
            add(data(Arrays.asList("@ "), STOP_WORDS, 0, 0));
            add(data(Arrays.asList("@"), STOP_WORDS, 0, 0));
            add(data(Arrays.asList(" "), STOP_WORDS, 0, 0));
            add(data(Arrays.asList(""), STOP_WORDS, 0, 0));
            add(data(null, STOP_WORDS, 0, 0));

            add(data(Arrays.asList("Mary had a little lamb"), null, 5, 5, 3.6f, Arrays.asList("Mary", "had", "a", "little", "lamb")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), null, 5, 5, 3.6f, Arrays.asList("Mary", "had", "a", "little", "lamb")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), null, 10, 8, 4.9f, Arrays.asList("Humpty-Dumpty", "sat", "on", "a", "wall", "Humpty-Dumpty", "had", "a", "great", "fall")));
            add(data(Arrays.asList("Mary "), null, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary"), null, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, 1, 1, 5f, Arrays.asList("Mary-")));
            add(data(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, 1, 1, 5f, Arrays.asList("Mary-")));
            add(data(Arrays.asList("- "), STOP_WORDS_EMPTY, 1, 1, 1f, Arrays.asList("-")));
            add(data(Arrays.asList("-"), STOP_WORDS_EMPTY, 1, 1, 1f, Arrays.asList("-")));
            add(data(Arrays.asList("Mary 1"), null, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary1"), null, 0, 0));
            add(data(Arrays.asList("Mary @"), null, 1, 1, 4f, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary@"), null, 0, 0));
            add(data(Arrays.asList("1 @"), null, 0, 0));
            add(data(Arrays.asList("1 "), null, 0, 0));
            add(data(Arrays.asList("1"), null, 0, 0));
            add(data(Arrays.asList("@ "), null, 0, 0));
            add(data(Arrays.asList("@"), null, 0, 0));
            add(data(Arrays.asList(" "), null, 0, 0));
            add(data(Arrays.asList(""), null, 0, 0));
            add(new TestDataStructure(null, null, 0, 0));
        }};
    }

    private static TestDataStructure data(
            List<String> inputText,
            List<String> stopWords,
            int correctWordCount,
            int uniqueWordCount
    ) {
        return new TestDataStructure(
                inputText,
                stopWords,
                correctWordCount,
                uniqueWordCount,
                0f,
                null
        );
    }

    private static TestDataStructure data(
            List<String> inputText,
            List<String> stopWords,
            int correctWordCount,
            int uniqueWordCount,
            float averageWordLength,
            List<String> wordIndex
    ) {
        return new TestDataStructure(
                inputText,
                stopWords,
                correctWordCount,
                uniqueWordCount,
                averageWordLength,
                wordIndex
        );
    }
}
