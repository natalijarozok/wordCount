package com.wordcount.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

    private TextParser _textParser;
    private List<String> _stopWords;

    public WordCounter(List<String> text, List<String> stopWords) {
        _textParser = new TextParser(text);
        _stopWords = stopWords != null ? stopWords : Collections.emptyList();
    }

    public WordsStatistic count() {
        List<String> tokens = getTokens();
        return getStatistics(tokens);
    }

    private List<String> getTokens() {
        return _textParser.parse();
    }

    private WordsStatistic getStatistics(List<String> tokens) {
        List<String> words = getWords(tokens);

        int wordCount = countWords(words);
        int uniqueWordCount = countUniqueWords(words);
        return new WordsStatistic(wordCount, uniqueWordCount);
    }

    private List<String> getWords(List<String> tokens) {
        return tokens.stream()
                .filter(token -> (isStringAWord(token) && isWordAllowed(token)))
                .collect(Collectors.toList());
    }

    private int countUniqueWords(List<String> words) {
        return new HashSet<>(words).size();
    }

    private int countWords(List<String> words) {
        return words.size();
    }

    private boolean isStringAWord(String rawString) {
        return rawString.matches("^[a-zA-Z]*$");
    }

    private boolean isWordAllowed(String word) {
        return !_stopWords.contains(word);
    }
}
