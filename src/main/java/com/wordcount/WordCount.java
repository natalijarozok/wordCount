package com.wordcount;

import com.wordcount.controllers.WordCounterController;
import com.wordcount.readers.ConsoleReader;
import com.wordcount.readers.StopWordsReader;
import com.wordcount.readers.UserInputReader;
import com.wordcount.readers.impl.ConsoleReaderImpl;
import com.wordcount.readers.impl.StopWordsReaderImpl;
import com.wordcount.readers.impl.UserInputReaderImpl;
import com.wordcount.writers.ConsoleWriter;
import com.wordcount.writers.UserOutputWriter;
import com.wordcount.writers.impl.ConsoleWriterImpl;
import com.wordcount.writers.impl.UserOutputWriterImpl;

public class WordCount {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        InputReader textReader = new InputReaderFactory(getInputTextFileName(args)).create();
        InputReader stopWordsReader = new InputReaderFactory(STOP_WORDS_FILE_NAME).create();
        ConsoleReader consoleReader = new ConsoleReaderImpl();
        UserInputReader inputReader = new UserInputReaderImpl(consoleReader);
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();
        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        UserOutputWriter outputWriter = new UserOutputWriterImpl(consoleWriter);

        WordCounterController controller = new WordCounterController(inputReader, stopWordsReader, outputWriter);
        controller.countWords();
    }

    private static String getInputTextFileName(String[] args) {
        String fileName = "";
        if (args.length > 0) {
            fileName = args[0];
        }
        return fileName;
    }
}
