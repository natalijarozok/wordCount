package com.wordCount;

import com.wordCount.paramsSource.TestParam;
import com.wordCount.paramsSource.TestParamValuesSource;
import com.wordcount.domain.WordCounter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUnitTests {

    @Test
    public void word_counting() {
        String text;
        List<String> stopWords;
        int wordCount;

        HashMap<TestParam, Integer> params = TestParamValuesSource.getTextParamValues();

        for (Map.Entry<TestParam, Integer> param : params.entrySet()) {
            text = param.getKey().getInputText();
            stopWords = param.getKey().getStopWords();
            wordCount = param.getValue().intValue();
            checkThatWordsCountIsCorrect(text, stopWords, wordCount);
        }
    }


    private void checkThatWordsCountIsCorrect(String text, List<String> stopWords, Integer wordCount) {
        WordCounter sut = new WordCounter(text, stopWords);
        int wordNumber = sut.count();
        assertEquals(wordCount, wordNumber);
    }

}
