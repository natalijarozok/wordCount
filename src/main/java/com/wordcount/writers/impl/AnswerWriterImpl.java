package com.wordcount.writers.impl;

import com.wordcount.domain.WordsStatistic;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.ConsoleWriter;

public class AnswerWriterImpl implements AnswerWriter {

    private ConsoleWriter _writer = new ConsoleWriterImpl();

    public AnswerWriterImpl(ConsoleWriter writer) {
        _writer = writer;
    }

    @Override
    public void write(WordsStatistic wordStatistics) {

        _writer.write(String.format(
                "Number of words: %d, unique: %d",
                wordStatistics.getWordCount(),
                wordStatistics.getUniqueWordCount()
        ));
    }
}
