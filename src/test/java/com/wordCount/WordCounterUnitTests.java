package com.wordCount;

import com.wordCount.paramsSource.TestInput;
import com.wordCount.paramsSource.TestInputValuesSource;
import com.wordcount.domain.WordCounter;
import com.wordcount.domain.WordsStatistic;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUnitTests {

    @Test
    public void word_counting() {
        List<String> text;
        List<String> stopWords;
        int wordCount;
        int uniqueWordCount;
        float averageWordLength;
        List<TestInput> params = TestInputValuesSource.getTestInputValuesWithDelimiters();

        for (TestInput param : params) {
            text = param.getInputText();
            stopWords = param.getStopWords();
            wordCount = param.getCorrectWordCount();
            uniqueWordCount = param.getUniqueWordCount();
            averageWordLength = param.getAverageWordLength();
            checkThatWordsCountIsCorrect(text, stopWords, wordCount, uniqueWordCount, averageWordLength);
        }
    }


    private void checkThatWordsCountIsCorrect(
            List<String> text,
            List<String> stopWords,
            int wordCountExpected,
            int uniqueWordCountExpected,
            float averageWordLength
    ) {
        WordCounter sut = new WordCounter(text, stopWords);
        WordsStatistic wordStatistics = sut.count();
        assertEquals(wordCountExpected, wordStatistics.getWordCount());
        assertEquals(uniqueWordCountExpected, wordStatistics.getUniqueWordCount());
        assertEquals(averageWordLength, wordStatistics.getAverageWordLength());
    }

}
