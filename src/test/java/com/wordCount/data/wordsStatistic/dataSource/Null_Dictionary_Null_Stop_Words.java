package com.wordCount.data.wordsStatistic.dataSource;

import com.wordCount.data.wordsStatistic.TestDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.wordCount.data.wordsStatistic.dataSource.TestDataSource.data;

public class Null_Dictionary_Filled_Stop_Words {

    public static List<TestDataStructure> getData() {
        return new ArrayList<TestDataStructure>() {
            {
                add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS, null, 4, 4, 4.25f, null, Arrays.asList("had", "lamb", "little", "Mary")));
                add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS, null, 4, 4, 4.25f, null, Arrays.asList("had", "lamb", "little", "Mary")));
                add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS, null, 7, 6, 6.43f, null, Arrays.asList("fall", "great", "had", "Humpty-Dumpty", "Humpty-Dumpty", "sat", "wall")));
                add(data(Arrays.asList("Mary "), STOP_WORDS, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary"), STOP_WORDS, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary- "), STOP_WORDS, null, 1, 1, 5f, null, Arrays.asList("Mary-")));
                add(data(Arrays.asList("Mary-"), STOP_WORDS, null, 1, 1, 5f, null, Arrays.asList("Mary-")));
                add(data(Arrays.asList("- "), STOP_WORDS, null, 1, 1, 1f, null, Arrays.asList("-")));
                add(data(Arrays.asList("-"), STOP_WORDS, null, 1, 1, 1f, null, Arrays.asList("-")));
                add(data(Arrays.asList("Mary 1"), STOP_WORDS, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary1"), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("Mary @"), STOP_WORDS, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary@"), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("1 @"), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("1 "), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("1"), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("@ "), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("@"), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList(" "), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList(""), STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(null, STOP_WORDS, null, 0, 0, 0, null, Collections.emptyList()));
            }
        };
    }

}
