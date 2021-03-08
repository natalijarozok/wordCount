package com.wordcount.domain;

import java.util.Collections;
import java.util.List;

public class WordCounter {

    private TextParser _textParser;
    private List<String> _stopWords;

    public WordCounter(String text, List<String> stopWords) {
        _textParser = new TextParser(text);
        _stopWords = stopWords != null ? stopWords : Collections.emptyList();
    }

    public int count() {
        List<String> tokens = getTokens();
        return countWords(tokens);
    }

    private List<String> getTokens() {
        return _textParser.parse();
    }

    private int countWords(List<String> tokens) {
        int wordCount = 0;
        for (String rawString : tokens) {
            if (isStringAWord(rawString) && isWordAllowed(rawString)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    private boolean isStringAWord(String rawString) {
        return rawString.matches("^[a-zA-Z]*$");
    }

    private boolean isWordAllowed(String word) {
        return !_stopWords.contains(word);
    }
}
