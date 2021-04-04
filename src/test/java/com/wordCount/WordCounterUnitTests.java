package com.wordCount;

import com.wordCount.data.entity.TestData;
import com.wordcount.mainApp.domain.WordCounter;
import org.junit.jupiter.api.Test;

import static com.wordCount.data.DataSource.errorMessageFor;
import static com.wordCount.data.DataSource.getData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUnitTests {

    @Test
    public void count_words() {
        getData().forEach(this::assertInputWordCountEqualsToExpectedWordCount);
    }


    private void assertInputWordCountEqualsToExpectedWordCount(TestData testData) {
        WordCounter sut = new WordCounter(testData.stopWords());
        long actualWordCount = sut.countWords(testData.inputText());
        assertEquals(
                testData.expectedWordCount(),
                actualWordCount,
                errorMessageFor(testData)
        );
    }
}
