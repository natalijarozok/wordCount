package com.wordcount.writer;

import com.wordcount.domain.dto.WordsStatistic;

public interface AnswerWriter {
    void write(WordsStatistic wordStatistics);
}
