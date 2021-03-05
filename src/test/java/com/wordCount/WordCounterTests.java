package com.wordCount;

import com.domain.WordCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTests {

    @Test
    public void word_counting_in_a_text_made_of_words_only_is_correct() {
        String text = "Mary had a little lamb";
        WordCounter sut = new WordCounter(text);

        int wordNumber = sut.count();

        assertEquals(5, wordNumber);
    }
}
