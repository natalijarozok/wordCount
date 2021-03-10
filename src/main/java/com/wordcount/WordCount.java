package com.wordcount;

import com.wordcount.controller.WordsStatisticController;
import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.factory.InputReaderFactory;
import com.wordcount.reader.InputReader;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.ConsoleWriter;
import com.wordcount.writer.impl.AnswerWriterImpl;
import com.wordcount.writer.impl.ConsoleWriterImpl;

public class WordCount {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        InputReader textReader = new InputReaderFactory(RunTimeParamsParser.getInputTextFileName(args)).create();
        InputReader stopWordsReader = new InputReaderFactory(STOP_WORDS_FILE_NAME).create();
        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriter);
        WordsStatisticOptions runTimeOptions = RunTimeParamsParser.getWordsStatisticOptions(args);

        WordsStatisticController controller = new WordsStatisticController(
                textReader,
                stopWordsReader,
                answerWriter,
                runTimeOptions
        );
        controller.countWordsStatistic();
    }
}
