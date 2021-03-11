package com.wordcount.domain;

import com.wordcount.domain.dto.Word;

import java.util.Comparator;

public class WordSorterCaseInsensitive implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        Word s1 = (Word) o1;
        Word s2 = (Word) o2;
        return s1.getValue().toLowerCase().compareTo(s2.getValue().toLowerCase());
    }
}
