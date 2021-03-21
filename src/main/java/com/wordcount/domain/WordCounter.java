package com.wordcount.domain;

import java.util.List;

public class WordCounter {

    private TextParser _textParser;

    public WordCounter(String text) {
        _textParser = new TextParser(text);
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
            if (isStringAWord(rawString)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    private boolean isStringAWord(String rawString) {
        return rawString != null && rawString.matches("^[a-zA-Z]*$");
    }
}
