package com.wordcount;

import com.wordcount.controllers.WordsStatisticController;
import com.wordcount.factory.InputReaderFactory;
import com.wordcount.readers.InputReader;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.ConsoleWriter;
import com.wordcount.writers.impl.AnswerWriterImpl;
import com.wordcount.writers.impl.ConsoleWriterImpl;

public class WordCount {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        InputReader textReader = new InputReaderFactory(getInputTextFileName(args)).create();
        InputReader stopWordsReader = new InputReaderFactory(STOP_WORDS_FILE_NAME).create();
        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriter);

        WordsStatisticController controller = new WordsStatisticController(
                textReader,
                stopWordsReader,
                answerWriter
        );
        controller.countWordsStatistic();
    }

    private static String getInputTextFileName(String[] args) {
        String fileName = "";
        if (args.length > 0) {
            fileName = args[0];
        }
        return fileName;
    }
}
