package com.wordcount;

import com.wordcount.controllers.WordCounterController;
import com.wordcount.readers.ConsoleTextReader;
import com.wordcount.readers.StopWordsReader;
import com.wordcount.readers.impl.ConsoleTextReaderImpl;
import com.wordcount.readers.impl.StopWordsReaderImpl;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.ConsoleWriter;
import com.wordcount.writers.impl.AnswerWriterImpl;
import com.wordcount.writers.impl.ConsoleWriterImpl;

public class WordCount {

    public static void main(String[] args) {
        ConsoleTextReader textReader = new ConsoleTextReaderImpl();
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();
        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriter);

        WordCounterController controller = new WordCounterController(textReader, stopWordsReader, answerWriter);
        controller.countWords();
    }
}
