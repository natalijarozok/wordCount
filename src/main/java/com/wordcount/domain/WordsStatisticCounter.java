package com.wordcount.domain;

import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.domain.dto.WordsStatisticOptions;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordsStatisticCounter {

    private List<String> _text;
    private List<String> _stopWords;
    private WordsStatisticOptions _wordsStatisticOptions;

    public WordsStatisticCounter(
            List<String> text,
            List<String> stopWords,
            WordsStatisticOptions wordsStatisticOptions
    ) {
        _text = text;
        _stopWords = stopWords != null ? stopWords : Collections.emptyList();
        _wordsStatisticOptions = wordsStatisticOptions;
    }

    public WordsStatistic count() {
        List<String> tokens = getTokens();
        return getStatistics(tokens);
    }

    private List<String> getTokens() {
        return new TextParser(_text).parse();
    }

    private WordsStatistic getStatistics(List<String> tokens) {
        List<String> words = getWords(tokens);

        int wordCount = countWords(words);
        int uniqueWordCount = countUniqueWords(words);
        float averageWordLength = countAverageWordLength(words);
        List<String> wordsIndex = _wordsStatisticOptions.getIncludeWordIndex() ? sortWords(words) : null;

        return new WordsStatistic(wordCount, uniqueWordCount, averageWordLength, wordsIndex);
    }

    private List<String> getWords(List<String> tokens) {
        return tokens.stream()
                .filter(token -> (isStringAWord(token) && isWordAllowed(token)))
                .collect(Collectors.toList());
    }

    private int countWords(List<String> words) {
        return words.size();
    }

    private int countUniqueWords(List<String> words) {
        return new HashSet<>(words).size();
    }

    private float countAverageWordLength(List<String> words) {
        long totalWordsLength = words.stream().mapToLong(word -> word.length()).sum();
        float averageWordLength = (float) totalWordsLength / ((words.size() > 0) ? words.size() : 1f);
        return round(averageWordLength, 2);
    }

    private boolean isStringAWord(String rawString) {
        return rawString.matches("^[a-zA-Z-]*$");
    }

    private boolean isWordAllowed(String word) {
        return !_stopWords.contains(word);
    }

    public static float round(float floatValue, int decimalPlace) {
        return BigDecimal.valueOf(floatValue).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    private List<String> sortWords(List<String> words) {
        Collections.sort(words, new SorterCaseInsensitive());
        return words;
    }
}
