package com.wordCount.data.parametersParser;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestDataSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    private static final List<String> DICTIONARY_EMPTY = Collections.emptyList();
    private static final List<String> DICTIONARY = Arrays.asList("big", "small", "little", "cat", "dog", "have", "has", "had");

    public static List<TestDataStructure> getData() {
        return new ArrayList<TestDataStructure>() {{
            add(data(null, null, null, "", false, null));
            add(data(null, "-index", null, "", true, null));
            add(data(null, "-index", "-dictionary", "", true, null));
            add(data(null, "-index", "-dictionary=", "", true, null));
            add(data(null, null, "-dictionary", "", false, null));
            add(data(null, null, "-dictionary=", "", false, null));
            add(data(null, null, "-dictionary=dic.txt", "", false, "dic.txt"));
            add(data("mytext.txt", null, null, "mytext.txt", false, null));
            add(data("mytext.txt", "-index", null, "mytext.txt", true, null));
            add(data("mytext.txt", "-index", "-dictionary", "mytext.txt", true, null));
            add(data("mytext.txt", "-index", "-dictionary=", "mytext.txt", true, null));
            add(data("mytext.txt", "-index", "-dictionary=dic.txt", "mytext.txt", true, "dic.txt"));
            add(data("mytext.txt", null, "-dictionary", "mytext.txt", false, null));
            add(data("mytext.txt", null, "-dictionary=", "mytext.txt", false, null));
            add(data("mytext.txt", null, "-dictionary=dic.txt", "mytext.txt", false, "dic.txt"));
        }};
    }

    private static TestDataStructure data(
            String fileName,
            String indexOption,
            String dictionaryOption,
            String expectedTextFileName,
            boolean expectedIncludeWordsIndex,
            String expectedDictionaryFileName
    ) {
        return new TestDataStructure(
                fileName,
                indexOption,
                dictionaryOption,
                expectedTextFileName,
                expectedIncludeWordsIndex,
                expectedDictionaryFileName
        );
    }
}
