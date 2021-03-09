package com.wordcount.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TextParser {
    private final String DEFAULT_DELIMITER = " ";
    private final List<String> TOKEN_DELIMITERS = Arrays.asList(DEFAULT_DELIMITER, ".");

    private String _text;

    TextParser(List<String> text) {
        _text = text != null ? String.join(DEFAULT_DELIMITER, text) : "";
    }

    public List<String> parse() {
        List<String> tokens = new ArrayList<>();

        String text = replaceAllDelimiterWithDefault(_text);

        StringTokenizer tokenizer = new StringTokenizer(text, DEFAULT_DELIMITER);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        return tokens;
    }

    private String replaceAllDelimiterWithDefault(String target) {
        String text = target;
        for (String delimiter : TOKEN_DELIMITERS) {
            text = replaceAll(text, delimiter, DEFAULT_DELIMITER);
        }
        return text;
    }

    private String replaceAll(String target, String oldValue, String newValue) {
        if (oldValue == newValue) return target;

        String result = target;
        while (result.contains(oldValue)) {
            result = result.replace(oldValue, newValue);
        }
        return result;
    }
}
