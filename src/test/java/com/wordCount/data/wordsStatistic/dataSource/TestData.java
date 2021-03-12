package com.wordCount.data.wordsStatistic.dataSource;

import com.wordCount.data.wordsStatistic.TestDataStructure;
import com.wordcount.domain.dto.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestDataSource {
    private static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    private static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    private static final List<String> DICTIONARY_EMPTY = Collections.emptyList();
    private static final List<String> DICTIONARY = Arrays.asList("big", "small", "little", "cat", "dog", "have", "has", "had");

    public static List<TestDataStructure> getData() {
        return new ArrayList<TestDataStructure>() {{
            //Dictionary Empty
            add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 5, 5, 3.6f, 0, Arrays.asList("a", "had", "lamb", "little", "Mary")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 5, 5, 3.6f, 0, Arrays.asList("a", "had", "lamb", "little", "Mary")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 10, 8, 4.9f, 0, Arrays.asList("a", "a", "fall", "great", "had", "Humpty-Dumpty", "Humpty-Dumpty", "on", "sat", "wall")));
            add(data(Arrays.asList("Mary "), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 5f, 0, Arrays.asList("Mary-")));
            add(data(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 5f, 0, Arrays.asList("Mary-")));
            add(data(Arrays.asList("- "), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 1f, 0, Arrays.asList("-")));
            add(data(Arrays.asList("-"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 1f, 0, Arrays.asList("-")));
            add(data(Arrays.asList("Mary 1"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary1"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("Mary @"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary@"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0f, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 @"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 "), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@ "), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@"), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(" "), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(""), STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(null, STOP_WORDS_EMPTY, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));

            add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS, DICTIONARY_EMPTY, 4, 4, 4.25f, 0, Arrays.asList("had", "lamb", "little", "Mary")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS, DICTIONARY_EMPTY, 4, 4, 4.25f, 0, Arrays.asList("had", "lamb", "little", "Mary")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS, DICTIONARY_EMPTY, 7, 6, 6.43f, 0, Arrays.asList("fall", "great", "had", "Humpty-Dumpty", "Humpty-Dumpty", "sat", "wall")));
            add(data(Arrays.asList("Mary "), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary"), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary- "), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 5f, 0, Arrays.asList("Mary-")));
            add(data(Arrays.asList("Mary-"), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 5f, 0, Arrays.asList("Mary-")));
            add(data(Arrays.asList("- "), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 1f, 0, Arrays.asList("-")));
            add(data(Arrays.asList("-"), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 1f, 0, Arrays.asList("-")));
            add(data(Arrays.asList("Mary 1"), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary1"), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("Mary @"), STOP_WORDS, DICTIONARY_EMPTY, 1, 1, 4f, 0, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary@"), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 @"), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 "), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1"), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@ "), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@"), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(" "), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(""), STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(null, STOP_WORDS, DICTIONARY_EMPTY, 0, 0, 0, 0, Collections.emptyList()));

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


            //Dictionary NULL
            add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS_EMPTY, null, 5, 5, 3.6f, null, Arrays.asList("a", "had", "lamb", "little", "Mary")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS_EMPTY, null, 5, 5, 3.6f, null, Arrays.asList("a", "had", "lamb", "little", "Mary")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS_EMPTY, null, 10, 8, 4.9f, null, Arrays.asList("a", "a", "fall", "great", "had", "Humpty-Dumpty", "Humpty-Dumpty", "on", "sat", "wall")));
            add(data(Arrays.asList("Mary "), STOP_WORDS_EMPTY, null, 1, 1, 4f, null, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary"), STOP_WORDS_EMPTY, null, 1, 1, 4f, null, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, null, 1, 1, 5f, null, Arrays.asList("Mary-")));
            add(data(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, null, 1, 1, 5f, null, Arrays.asList("Mary-")));
            add(data(Arrays.asList("- "), STOP_WORDS_EMPTY, null, 1, 1, 1f, null, Arrays.asList("-")));
            add(data(Arrays.asList("-"), STOP_WORDS_EMPTY, null, 1, 1, 1f, null, Arrays.asList("-")));
            add(data(Arrays.asList("Mary 1"), STOP_WORDS_EMPTY, null, 1, 1, 4f, null, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary1"), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(Arrays.asList("Mary @"), STOP_WORDS_EMPTY, null, 1, 1, 4f, null, Arrays.asList("Mary")));
            add(data(Arrays.asList("Mary@"), STOP_WORDS_EMPTY, null, 0, 0, 0f, null, Collections.emptyList()));
            add(data(Arrays.asList("1 @"), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(Arrays.asList("1 "), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(Arrays.asList("1"), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(Arrays.asList("@ "), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(Arrays.asList("@"), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(Arrays.asList(" "), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(Arrays.asList(""), STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));
            add(data(null, STOP_WORDS_EMPTY, null, 0, 0, 0, null, Collections.emptyList()));

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

            //Dictionary filled
            add(data(Arrays.asList("Mary had a little lamb"), STOP_WORDS_EMPTY, DICTIONARY, 5, 5, 3.6f, 3, Arrays.asList("a*", "had", "lamb*", "little", "Mary*")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), STOP_WORDS_EMPTY, DICTIONARY, 5, 5, 3.6f, 3, Arrays.asList("a*", "had", "lamb*", "little", "Mary*")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), STOP_WORDS_EMPTY, DICTIONARY, 10, 8, 4.9f, 9, Arrays.asList("a*", "a*", "fall*", "great*", "had", "Humpty-Dumpty*", "Humpty-Dumpty*", "on*", "sat*", "wall*")));
            add(data(Arrays.asList("Mary "), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary"), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary- "), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 5f, 1, Arrays.asList("Mary-*")));
            add(data(Arrays.asList("Mary-"), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 5f, 1, Arrays.asList("Mary-*")));
            add(data(Arrays.asList("- "), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 1f, 1, Arrays.asList("-*")));
            add(data(Arrays.asList("-"), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 1f, 1, Arrays.asList("-*")));
            add(data(Arrays.asList("Mary 1"), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary1"), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("Mary @"), STOP_WORDS_EMPTY, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary@"), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0f, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 @"), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 "), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1"), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@ "), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@"), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(" "), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(""), STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(null, STOP_WORDS_EMPTY, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));

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

            add(data(Arrays.asList("Mary had a little lamb"), null, DICTIONARY, 5, 5, 3.6f, 3, Arrays.asList("a*", "had", "lamb*", "little", "Mary*")));
            add(data(Arrays.asList("Mary had", "a little", "lamb"), null, DICTIONARY, 5, 5, 3.6f, 3, Arrays.asList("a*", "had", "lamb*", "little", "Mary*")));
            add(data(Arrays.asList("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall."), null, DICTIONARY, 10, 8, 4.9f, 9, Arrays.asList("a*", "a*", "fall*", "great*", "had", "Humpty-Dumpty*", "Humpty-Dumpty*", "on*", "sat*", "wall*")));
            add(data(Arrays.asList("Mary "), null, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary"), null, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary- "), null, DICTIONARY, 1, 1, 5f, 1, Arrays.asList("Mary-*")));
            add(data(Arrays.asList("Mary-"), null, DICTIONARY, 1, 1, 5f, 1, Arrays.asList("Mary-*")));
            add(data(Arrays.asList("- "), null, DICTIONARY, 1, 1, 1f, 1, Arrays.asList("-*")));
            add(data(Arrays.asList("-"), null, DICTIONARY, 1, 1, 1f, 1, Arrays.asList("-*")));
            add(data(Arrays.asList("Mary 1"), null, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary1"), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("Mary @"), null, DICTIONARY, 1, 1, 4f, 1, Arrays.asList("Mary*")));
            add(data(Arrays.asList("Mary@"), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 @"), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1 "), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("1"), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@ "), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList("@"), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(" "), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(Arrays.asList(""), null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
            add(data(null, null, DICTIONARY, 0, 0, 0, 0, Collections.emptyList()));
        }};
    }

    private static TestDataStructure data(
            List<String> inputText,
            List<String> stopWords,
            List<String> dictionaryWords,
            int expectedWordCount,
            int expectedUniqueWordCount
    ) {
        return new TestDataStructure(
                inputText,
                stopWords,
                dictionaryWords,
                expectedWordCount,
                expectedUniqueWordCount
        );
    }

    private static TestDataStructure data(
            List<String> inputText,
            List<String> stopWords,
            List<String> dictionaryWords,
            int expectedCorrectWordCount,
            int expectedUniqueWordCount,
            float expectedAverageWordLength,
            Integer expectedUnknownWordCount,
            List<String> expectedRawWordIndex
    ) {
        return new TestDataStructure(
                inputText,
                stopWords,
                dictionaryWords,
                expectedCorrectWordCount,
                expectedUniqueWordCount,
                expectedAverageWordLength,
                expectedUnknownWordCount,
                toWords(expectedRawWordIndex)
        );
    }

    private static List<Word> toWords(List<String> wordData) {
        return wordData.stream().map(word -> toWord(word)).collect(Collectors.toList());
    }

    private static Word toWord(String word) {
        boolean isKnown = !word.contains("*");
        return new Word(word.replace("*", ""), isKnown);
    }
}
