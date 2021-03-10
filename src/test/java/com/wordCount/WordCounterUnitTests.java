package com.wordCount;

import com.wordCount.data.TestDataStructure;
import com.wordCount.data.TestInput;
import com.wordcount.domain.WordsStatisticCounter;
import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.domain.dto.WordsStatisticOptions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUnitTests {

    @Test
    public void words_statistic() {
        List<TestDataStructure> testInput = new TestInput().get();
        for (TestDataStructure testData : testInput) {
            checkThatWordsStatisticIsCorrect(testData);
        }
    }

    private void checkThatWordsStatisticIsCorrect(TestDataStructure testData) {
        WordsStatisticCounter sut = new WordsStatisticCounter(
                testData.getInputText(),
                testData.getStopWords(),
                new WordsStatisticOptions(testData.getIncludeWordIndex())
        );
        WordsStatistic actualWordStatistics = sut.count();

        WordsStatistic expectedWordsStatistic = new WordsStatistic(
                testData.getCorrectWordCount(),
                testData.getCorrectUniqueWordCount(),
                testData.getCorrectAverageWordLength(),
                testData.getCorrectWordIndex()
        );

        assertEquals(expectedWordsStatistic, actualWordStatistics);
//        assertEquals(correctWordCount, wordStatistics.getWordCount());
//        assertEquals(correctUniqueWordCount, wordStatistics.getUniqueWordCount());
//        assertEquals(correctAverageWordLength, wordStatistics.getAverageWordLength());
//        assertEquals(correctWordsIndex, wordStatistics.getWordsIndex());
    }

}
