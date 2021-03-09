package com.wordcount.writers;

import com.wordcount.domain.WordsStatistic;

public interface AnswerWriter {
    void write(WordsStatistic wordStatistics);
}
