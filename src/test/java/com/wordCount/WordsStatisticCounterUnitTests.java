package com.wordCount;

import com.wordCount.data.wordsStatistic.TestDataStructure;
import com.wordCount.data.wordsStatistic.TestInput;
import com.wordcount.domain.WordsStatisticCounter;
import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.domain.dto.WordsStatisticOptions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordsStatisticCounterUnitTests {

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
                testData.getDictionaryWords(),
                new WordsStatisticOptions(testData.getIncludeWordIndex())
        );
        WordsStatistic actualWordStatistics = sut.count();

        WordsStatistic expectedWordsStatistic = new WordsStatistic(
                testData.getExpectedWordCount(),
                testData.getExpectedUniqueWordCount(),
                testData.getExpectedAverageWordLength(),
                testData.getUnknownWordCount(),
                testData.getExpectedWordIndex()
        );

        assertEquals(expectedWordsStatistic, actualWordStatistics);
    }

}
