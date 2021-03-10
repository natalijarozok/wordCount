package com.wordcount.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordsStatisticCounter {

    private TextParser _textParser;
    private List<String> _stopWords;

    public WordsStatisticCounter(List<String> text, List<String> stopWords) {
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
        float averageWordLength = countAverageWordLength(words);
        return new WordsStatistic(wordCount, uniqueWordCount, averageWordLength);
    }

    private List<String> getWords(List<String> tokens) {
        return tokens.stream()
                .filter(token -> (isStringAWord(token) && isWordAllowed(token)))
                .collect(Collectors.toList());
    }

    private float countAverageWordLength(List<String> words) {
        long totalWordsLength = words.stream().mapToLong(word -> word.length()).sum();
        float averageWordLength = (float) totalWordsLength / ((words.size() > 0) ? words.size() : 1f);
        return round(averageWordLength, 2);
    }

    public static float round(float floatValue, int decimalPlace) {
        return BigDecimal.valueOf(floatValue).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    private int countUniqueWords(List<String> words) {
        return new HashSet<>(words).size();
    }

    private int countWords(List<String> words) {
        return words.size();
    }

    private boolean isStringAWord(String rawString) {
        return rawString.matches("^[a-zA-Z-]*$");
    }

    private boolean isWordAllowed(String word) {
        return !_stopWords.contains(word);
    }
}
