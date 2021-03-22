package com.wordcount.domain;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private final TextParser textParser = new TextParser();
    private final List<String> stopWords;

    private final Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords != null ? stopWords : Collections.emptyList();
    }

    public long countWords(String text) {
        List<String> wordCandidates = parse(text);
        return countWords(wordCandidates);
    }

    private List<String> parse(String text) {
        return textParser.parse(text);
    }

    private long countWords(List<String> wordCandidates) {
        return wordCandidates.stream()
                .filter(this::isAnAllowedWord)
                .count();
    }

    private boolean isAnAllowedWord(String wordCandidate) {
        return isAWord(wordCandidate) && isAllowed(wordCandidate);
    }

    private boolean isAWord(String wordCandidate) {
        return pattern.matcher(wordCandidate).matches();
    }

    private boolean isAllowed(String word) {
        return !stopWords.contains(word);
    }
}
