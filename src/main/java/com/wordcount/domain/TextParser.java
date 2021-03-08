package com.wordcount.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TextParser {
    private final String TEXT_DELIMITER = " ";

    private String _text;

    TextParser(String text) {
        _text = text != null ? text : "";
    }

    public List<String> parse() {

        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(_text, TEXT_DELIMITER);

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        return tokens;
    }
}
