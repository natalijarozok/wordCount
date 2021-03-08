package com.wordcount;

import com.wordcount.controllers.WordCounterController;
import com.wordcount.readers.ConsoleTextReader;
import com.wordcount.readers.impl.ConsoleTextReaderImpl;
import com.wordcount.writers.AnswerWriter;
import com.wordcount.writers.ConsoleWriter;
import com.wordcount.writers.impl.AnswerWriterImpl;
import com.wordcount.writers.impl.ConsoleWriterImpl;

public class WordCount {

    public static void main(String[] args) {
        ConsoleTextReader reader = new ConsoleTextReaderImpl();
        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        AnswerWriter writer = new AnswerWriterImpl(consoleWriter);

        WordCounterController controller = new WordCounterController(reader, writer);
        controller.countWords();
    }
}
