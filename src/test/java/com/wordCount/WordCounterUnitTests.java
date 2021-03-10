package com.wordCount;

import com.wordCount.paramsSource.TestInput;
import com.wordCount.paramsSource.TestInputValuesSource;
import com.wordcount.domain.WordsStatisticCounter;
import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.domain.dto.WordsStatisticOptions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUnitTests {

    @Test
    public void words_statistic_without_index_option() {
        List<String> text;
        List<String> stopWords;
        int correctWordCount;
        int correctUniqueWordCount;
        float correctAverageWordLength;
        List<String> correctWordsIndex;

        List<TestInput> params = TestInputValuesSource.getTestInputValues();

        for (TestInput param : params) {
            text = param.getInputText();
            stopWords = param.getStopWords();
            correctWordCount = param.getCorrectWordCount();
            correctUniqueWordCount = param.getUniqueWordCount();
            correctAverageWordLength = param.getAverageWordLength();
            correctWordsIndex = param.getWordIndex();
            checkThatWordsStatisticIsCorrect(
                    text,
                    stopWords,
                    false,
                    correctWordCount,
                    correctUniqueWordCount,
                    correctAverageWordLength,
                    Collections.emptyList()
            );
        }
    }


    private void checkThatWordsStatisticIsCorrect(
            List<String> text,
            List<String> stopWords,
            boolean includeWordIndex,
            int correctWordCount,
            int correctUniqueWordCount,
            float correctAverageWordLength,
            List<String> correctWordsIndex
    ) {
        WordsStatisticCounter sut = new WordsStatisticCounter(text, stopWords, new WordsStatisticOptions(includeWordIndex));
        WordsStatistic wordStatistics = sut.count();
        assertEquals(correctWordCount, wordStatistics.getWordCount());
        assertEquals(correctUniqueWordCount, wordStatistics.getUniqueWordCount());
        assertEquals(correctAverageWordLength, wordStatistics.getAverageWordLength());
        assertEquals(correctWordsIndex, wordStatistics.getWordsIndex());
    }

}
