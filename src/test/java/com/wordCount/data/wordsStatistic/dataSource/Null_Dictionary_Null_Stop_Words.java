package com.wordCount.data.wordsStatistic.dataSource;

import com.wordCount.data.wordsStatistic.entity.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.wordCount.data.wordsStatistic.entity.TestData.data;

public class Null_Dictionary_Null_Stop_Words {

    public static List<TestData> getData() {
        return new ArrayList<TestData>() {
            {
                add(data(Arrays.asList("Mary had a little lamb"), null, null, 5, 5, 3.6f, null, Arrays.asList("a", "had", "lamb", "little", "Mary")));
                add(data(Arrays.asList("Mary had", "a little", "lamb"), null, null, 5, 5, 3.6f, null, Arrays.asList("a", "had", "lamb", "little", "Mary")));
                add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), null, null, 10, 8, 4.9f, null, Arrays.asList("a", "a", "fall", "great", "had", "Humpty-Dumpty", "Humpty-Dumpty", "on", "sat", "wall")));
                add(data(Arrays.asList("Mary "), null, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary"), null, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary- "), null, null, 1, 1, 5f, null, Arrays.asList("Mary-")));
                add(data(Arrays.asList("Mary-"), null, null, 1, 1, 5f, null, Arrays.asList("Mary-")));
                add(data(Arrays.asList("- "), null, null, 1, 1, 1f, null, Arrays.asList("-")));
                add(data(Arrays.asList("-"), null, null, 1, 1, 1f, null, Arrays.asList("-")));
                add(data(Arrays.asList("Mary 1"), null, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary1"), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("Mary @"), null, null, 1, 1, 4f, null, Arrays.asList("Mary")));
                add(data(Arrays.asList("Mary@"), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("1 @"), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("1 "), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("1"), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("@ "), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList("@"), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList(" "), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(Arrays.asList(""), null, null, 0, 0, 0, null, Collections.emptyList()));
                add(data(null, null, null, 0, 0, 0, null, Collections.emptyList()));
            }
        };
    }

}
