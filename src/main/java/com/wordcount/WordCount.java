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

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReaderImpl();
        UserInputReader inputReader = new UserInputReaderImpl(consoleReader);
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();
        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        UserOutputWriter outputWriter = new UserOutputWriterImpl(consoleWriter);

        WordCounterController controller = new WordCounterController(inputReader, stopWordsReader, outputWriter);
        controller.countWords();
    }
}
