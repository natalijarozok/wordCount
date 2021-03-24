package com.wordcount;

import com.wordcount.controllers.WordCounterController;
import com.wordcount.inputOutput.IOCommunicator;
import com.wordcount.inputOutput.impl.IOCommunicatorImpl;
import com.wordcount.inputOutput.input.StopWordsReader;
import com.wordcount.inputOutput.input.UserInputReader;
import com.wordcount.inputOutput.input.UserInputSource;
import com.wordcount.inputOutput.input.impl.ConsoleUserInput;
import com.wordcount.inputOutput.input.impl.StopWordsReaderImpl;
import com.wordcount.inputOutput.input.impl.UserInputReaderImpl;
import com.wordcount.inputOutput.output.UserOutputSource;
import com.wordcount.inputOutput.output.UserOutputWriter;
import com.wordcount.inputOutput.output.impl.ConsoleUserOutput;
import com.wordcount.inputOutput.output.impl.UserOutputWriterImpl;

public class WordCount {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        InputReader textReader = new InputReaderFactory(getInputTextFileName(args)).create();
        InputReader stopWordsReader = new InputReaderFactory(STOP_WORDS_FILE_NAME).create();
        ConsoleReader consoleReader = new ConsoleReaderImpl();
        UserInputReader inputReader = new UserInputReaderImpl(consoleReader);
        UserInputSource userInputSource = new ConsoleUserInput();
        UserInputReader inputReader = new UserInputReaderImpl(userInputSource);

        UserOutputSource userOutputSource = new ConsoleUserOutput();
        UserOutputWriter outputWriter = new UserOutputWriterImpl(userOutputSource);

        IOCommunicator userCommunicator = new IOCommunicatorImpl(inputReader, outputWriter);

        StopWordsReader stopWordsReader = new StopWordsReaderImpl();

        WordCounterController controller = new WordCounterController(userCommunicator, stopWordsReader);
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
