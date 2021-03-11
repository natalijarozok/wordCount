package com.wordcount.writer.impl;

import com.wordcount.domain.dto.Word;
import com.wordcount.domain.dto.WordsStatistic;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.ConsoleWriter;

public class AnswerWriterImpl implements AnswerWriter {

    private final ConsoleWriter _writer;
    private WordsStatistic _wordStatistics;

    public AnswerWriterImpl(ConsoleWriter writer) {
        _writer = writer;
    }

    @Override
    public void write(WordsStatistic wordStatistics) {
        _wordStatistics = wordStatistics;
        String answer = getAnswer();
        _writer.write(answer);
    }

    private String getAnswer() {
        StringBuilder answer = new StringBuilder(getGeneralInfo());

        if (mustShowWordsIndex()) {
            answer.append(getWordsIndexInfo());
        }

        return answer.toString();
    }

    private boolean mustShowWordsIndex() {
        return _wordStatistics.getWordsIndex() != null;
    }

    private String getGeneralInfo() {
        return String.format(
                "Number of words: %d, unique: %d; average word length: %.2f characters",
                _wordStatistics.getWordCount(),
                _wordStatistics.getUniqueWordCount(),
                _wordStatistics.getAverageWordLength()
        );
    }

    private String getWordsIndexInfo() {
        StringBuilder info = new StringBuilder("\nIndex")
                .append(getUnknownWordsInfo())
                .append(":\n");

        for (Word word : _wordStatistics.getWordsIndex()) {
            info.append(String.format("%s%s\n", word.getValue(), word.wordIsKnown() ? "" : "*"));
        }
        return info.toString();
    }

    private String getUnknownWordsInfo() {
        return _wordStatistics.getUnknownWordCount() != null ?
                String.format(" (unknown: %d)", _wordStatistics.getUnknownWordCount())
                : "";
    }
}
