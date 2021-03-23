package com.wordCount.data.wordsStatistic.entity;

import com.wordcount.domain.dto.Word;

import java.util.List;

public class ExpectedOutput {

    private int expectedCorrectWordCount;

    public int getExpectedCorrectWordCount() {
        return expectedCorrectWordCount;
    }

    private int expectedUniqueWordCount;

    public int getExpectedUniqueWordCount() {
        return expectedUniqueWordCount;
    }

    private float expectedAverageWordLength;

    public float getExpectedAverageWordLength() {
        return expectedAverageWordLength;
    }

    private Integer expectedUnknownWordCount;

    public Integer getExpectedUnknownWordCount() {
        return expectedUnknownWordCount;
    }

    private List<Word> expectedRawWordIndex;

    public List<Word> getExpectedRawWordIndex() {
        return expectedRawWordIndex;
    }

    public void setExpectedRawWordIndex(List<Word> expectedRawWordIndex) {
        this.expectedRawWordIndex = expectedRawWordIndex;
    }

    public ExpectedOutput(
            int expectedCorrectWordCount,
            int expectedUniqueWordCount,
            float expectedAverageWordLength,
            Integer expectedUnknownWordCount,
            List<Word> expectedRawWordIndex
    ) {
        this.expectedCorrectWordCount = expectedCorrectWordCount;
        this.expectedUniqueWordCount = expectedUniqueWordCount;
        this.expectedAverageWordLength = expectedAverageWordLength;
        this.expectedUnknownWordCount = expectedUnknownWordCount;
        this.expectedRawWordIndex = expectedRawWordIndex;
    }
}
