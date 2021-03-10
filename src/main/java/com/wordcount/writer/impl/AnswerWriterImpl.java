package com.wordcount.writer.impl;

import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.ConsoleWriter;

public class AnswerWriterImpl implements AnswerWriter {

    private ConsoleWriter _writer = new ConsoleWriterImpl();

    public AnswerWriterImpl(ConsoleWriter writer) {
        _writer = writer;
    }

    @Override
    public void write(WordsStatistic wordStatistics) {

        _writer.write(String.format(
                "Number of words: %d, unique: %d; average word length: %.2f characters",
                wordStatistics.getWordCount(),
                wordStatistics.getUniqueWordCount(),
                wordStatistics.getAverageWordLength()
        ));
    }
}
