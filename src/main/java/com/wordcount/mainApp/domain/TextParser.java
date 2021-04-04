package com.wordcount.mainApp.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser {
    private final String TEXT_DELIMITER = " ";

    public List<String> parse(List<String> text) {
        return text.stream()
                .map(this::parse)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<String> parse(String text) {
        return Arrays.stream(text.split(TEXT_DELIMITER))
                .filter(wordCandidate -> !wordCandidate.isEmpty())
                .collect(Collectors.toList());
    }
}
