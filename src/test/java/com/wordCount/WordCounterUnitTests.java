package com.wordCount;

import com.wordCount.paramsSource.TestParamValuesSource;
import com.wordcount.domain.WordCounter;
import javafx.util.Pair;
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

        HashMap<Pair<String, List<String>>, Integer> params = TestParamValuesSource.getTextParamValues();

        for (Map.Entry<Pair<String, List<String>>, Integer> param : params.entrySet()) {
            text = param.getKey().getKey();
            stopWords = param.getKey().getValue();
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
