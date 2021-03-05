package com.wordCount;

import com.domain.WordCounter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTests {

    @Test
    public void word_counting_in_a_text_made_of_words_only_is_correct() {

        HashMap<String, Integer> params = getWordsOnlyParamValues();

        for (Map.Entry<String, Integer> param : params.entrySet()) {
            checkThatTextHasRightWordsCount(param.getKey(), param.getValue().intValue());
        }
    }


    @Test
    public void word_counting_in_a_text_made_not_of_words_only_is_correct() {

        HashMap<String, Integer> params = getNonWordsOnlyParamValues();

        for (Map.Entry<String, Integer> param : params.entrySet()) {
            checkThatTextHasRightWordsCount(param.getKey(), param.getValue().intValue());
        }
    }

    private void checkThatTextHasRightWordsCount(String text, Integer wordCount) {
        WordCounter sut = new WordCounter(text);

        int wordNumber = sut.count();

        assertEquals(wordCount, wordNumber);
    }

    private HashMap<String, Integer> getWordsOnlyParamValues() {
        return new HashMap<String, Integer>() {{
            put("Mary had a little lamb", 5);
            put("Mary ", 1);
            put("Mary", 1);
        }};
    }

    private HashMap<String, Integer> getNonWordsOnlyParamValues() {
        return new HashMap<String, Integer>() {{
            put("Mary 1", 1);
            put("1@ 1@", 0);
            put("1@ ", 0);
            put("1@", 0);
            put(" ", 0);
            put(null, 0);
        }};
    }

}
