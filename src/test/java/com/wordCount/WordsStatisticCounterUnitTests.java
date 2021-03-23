package com.wordCount;

import com.wordCount.data.wordsStatistic.TestDataSource;
import com.wordCount.data.wordsStatistic.entity.TestData;
import com.wordcount.domain.WordsStatisticCounter;
import com.wordcount.domain.dto.WordsStatistic;
import org.junit.jupiter.api.Test;

import static com.wordCount.data.wordsStatistic.TestDataSource.errorMessageFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordsStatisticCounterUnitTests {

    @Test
    public void words_statistic() {
        TestDataSource.getTestData().forEach(this::assertWordsStatisticIsCorrect);
    }

    private void assertWordsStatisticIsCorrect(TestData testData) {
        WordsStatistic expectedWordsStatistic = getExpectedWordsStatistic(testData);
        WordsStatistic actualWordStatistics = getWordsStatisticCounter(testData).count();
        assertEquals(expectedWordsStatistic, actualWordStatistics, errorMessageFor(testData));
    }

    private WordsStatisticCounter getWordsStatisticCounter(TestData testData) {
        return new WordsStatisticCounter(
                testData.getTestInput().getInputText(),
                testData.getTestInput().getStopWords(),
                testData.getTestInput().getDictionaryWords(),
                testData.getTestInput().getIncludeWordIndex()
        );
    }

    private WordsStatistic getExpectedWordsStatistic(TestData testData) {
        return new WordsStatistic(
                testData.getExpectedOutput().getExpectedCorrectWordCount(),
                testData.getExpectedOutput().getExpectedUniqueWordCount(),
                testData.getExpectedOutput().getExpectedAverageWordLength(),
                testData.getExpectedOutput().getExpectedUnknownWordCount(),
                testData.getExpectedOutput().getExpectedRawWordIndex()
        );
    }
}
