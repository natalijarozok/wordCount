package com.wordCount;

import com.wordCount.paramsSource.TestParamValuesSource;
import com.wordcount.domain.WordCounter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUnitTests {

    @Test
    public void word_counting_in_a_text_made_of_words_only_is_correct() {

        HashMap<String, Integer> params = TestParamValuesSource.getWordsOnlyParamValues();

        for (Map.Entry<String, Integer> param : params.entrySet()) {
            checkThatWordsCountIsCorrect(param.getKey(), param.getValue().intValue());
        }
    }


    @Test
    public void word_counting_in_a_text_made_not_of_words_only_is_correct() {

        HashMap<String, Integer> params = TestParamValuesSource.getNonWordsParamValues();

        for (Map.Entry<String, Integer> param : params.entrySet()) {
            checkThatWordsCountIsCorrect(param.getKey(), param.getValue().intValue());
        }
    }


    private void checkThatWordsCountIsCorrect(String text, Integer wordCount) {
        WordCounter sut = new WordCounter(text);
        int wordNumber = sut.count();
        assertEquals(wordCount, wordNumber);
    }

}
