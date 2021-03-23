package com.wordCount.data.wordsStatistic.entity;

import com.wordcount.domain.dto.Word;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestData implements Cloneable {

    public static final List<String> STOP_WORDS_EMPTY = Collections.emptyList();
    public static final List<String> STOP_WORDS = Arrays.asList("the", "a", "on", "off");

    public static final List<String> DICTIONARY_EMPTY = Collections.emptyList();
    public static final List<String> DICTIONARY = Arrays.asList("big", "small", "little", "cat", "dog", "have", "has", "had");

    private TestInput testInput;

    public TestInput getTestInput() {
        return testInput;
    }


    private ExpectedOutput expectedOutput;

    public ExpectedOutput getExpectedOutput() {
        return expectedOutput;
    }


    public TestData(TestInput testInput, ExpectedOutput expectedOutput) {
        this.testInput = testInput;
        this.expectedOutput = expectedOutput;
    }


    public static TestData data(
            List<String> inputText,
            List<String> stopWords,
            List<String> dictionaryWords,
            int expectedCorrectWordCount,
            int expectedUniqueWordCount
    ) {
        return data(inputText,
                stopWords,
                dictionaryWords,
                expectedCorrectWordCount,
                expectedUniqueWordCount,
                0f,
                0,
                Collections.emptyList()
        );
    }

    public static TestData data(
            List<String> inputText,
            List<String> stopWords,
            List<String> dictionaryWords,
            int expectedCorrectWordCount,
            int expectedUniqueWordCount,
            float expectedAverageWordLength,
            Integer expectedUnknownWordCount,
            List<String> expectedRawWordIndex
    ) {
        return new TestData(
                new TestInput(
                        inputText,
                        stopWords,
                        dictionaryWords
                ),
                new ExpectedOutput(
                        expectedCorrectWordCount,
                        expectedUniqueWordCount,
                        expectedAverageWordLength,
                        expectedUnknownWordCount,
                        toWords(expectedRawWordIndex)
                )
        );
    }

    protected static List<Word> toWords(List<String> wordData) {
        return wordData.stream().map(word -> toWord(word)).collect(Collectors.toList());
    }

    protected static Word toWord(String word) {
        boolean isKnown = !word.contains("*");
        return new Word(word.replace("*", ""), isKnown);
    }
}
