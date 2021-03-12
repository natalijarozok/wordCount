package com.wordCount.data.wordsStatistic.dataSource;

import com.wordCount.data.wordsStatistic.TestDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.wordCount.data.wordsStatistic.dataSource.TestDataSource.data;

public class Empty_Dictionary_Null_Stop_Words {

    public static List<TestDataStructure> getData() {
        return new ArrayList<TestDataStructure>() {
            {
                add(data(Arrays.asList("Mary had a little lamb"), null, DICTIONARY_EMPTY, 5, 5, 3.6f, 0, Arrays.asList("a", "had", "lamb", "little", "Mary")));
                add(data(Arrays.asList("Mary had", "a little", "lamb"), null, DICTIONARY_EMPTY, 5, 5, 3.6f, 0, Arrays.asList("a", "had", "lamb", "little", "Mary")));
                add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), null, DICTIONARY_EMPTY, 10, 8, 4.9f, 0, Arrays.asList("a", "a", "fall", "great", "had", "Humpty-Dumpty", "Humpty-Dumpty", "on", "sat", "wall")));
                add(data(Arrays.asList("Mary "), null, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary"), null, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary- "), null, DICTIONARY_EMPTY, 1, 1, 5f, 0, Arrays.asList("Mary-")));
                add(data(Arrays.asList("Mary-"), null, DICTIONARY_EMPTY, 1, 1, 5f, 0, Arrays.asList("Mary-")));
                add(data(Arrays.asList("- "), null, DICTIONARY_EMPTY, 1, 1, 1f, 0, Arrays.asList("-")));
                add(data(Arrays.asList("-"), null, DICTIONARY_EMPTY, 1, 1, 1f, 0, Arrays.asList("-")));
                add(data(Arrays.asList("Mary 1"), null, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary1"), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("Mary @"), null, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary@"), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("1 @"), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("1 "), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("1"), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("@ "), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("@"), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList(" "), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList(""), null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(null, null, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            }
        };
    }

}
