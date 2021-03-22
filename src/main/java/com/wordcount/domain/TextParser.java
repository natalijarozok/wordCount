package com.wordcount.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser {
    private final String TEXT_DELIMITER = " ";

    public List<String> parse(String text) {
        return Arrays.stream(text.split(TEXT_DELIMITER))
                .filter(wordCandidate -> !wordCandidate.isEmpty())
                .collect(Collectors.toList());
    }
}
