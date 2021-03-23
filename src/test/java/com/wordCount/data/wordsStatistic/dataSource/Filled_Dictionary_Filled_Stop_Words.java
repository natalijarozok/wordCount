package com.wordCount.data.wordsStatistic.dataSource;

import com.wordCount.data.wordsStatistic.entity.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.wordCount.data.wordsStatistic.entity.TestData.*;

public class Filled_Dictionary_Filled_Stop_Words {

    public static List<TestData> getData() {
        return new ArrayList<TestData>() {
            {
                add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS, DICTIONARY, 4, 4, 4.25f, 2, Arrays.asList("had", "lamb*", "little", "Mary*")));
                add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS, DICTIONARY, 4, 4, 4.25f, 2, Arrays.asList("had", "lamb*", "little", "Mary*")));
                add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS, DICTIONARY, 7, 6, 6.43f, 6, Arrays.asList("fall*", "great*", "had", "Humpty-Dumpty*", "Humpty-Dumpty*", "sat*", "wall*")));
                add(data(Arrays.asList("Mary "), STOP_WORDS, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
                add(data(Arrays.asList("Mary"), STOP_WORDS, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
                add(data(Arrays.asList("Mary- "), STOP_WORDS, DICTIONARY, 1, 1, 5f, 1, Arrays.asList("Mary-*")));
                add(data(Arrays.asList("Mary-"), STOP_WORDS, DICTIONARY, 1, 1, 5f, 1, Arrays.asList("Mary-*")));
                add(data(Arrays.asList("- "), STOP_WORDS, DICTIONARY, 1, 1, 1f, 1, Arrays.asList("-*")));
                add(data(Arrays.asList("-"), STOP_WORDS, DICTIONARY, 1, 1, 1f, 1, Arrays.asList("-*")));
                add(data(Arrays.asList("Mary 1"), STOP_WORDS, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
                add(data(Arrays.asList("Mary1"), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("Mary @"), STOP_WORDS, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
                add(data(Arrays.asList("Mary@"), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("1 @"), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("1 "), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("1"), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("@ "), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList("@"), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList(" "), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(Arrays.asList(""), STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
                add(data(null, STOP_WORDS, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            }
        };
    }

}
