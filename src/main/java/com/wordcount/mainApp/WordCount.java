package com.wordcount.mainApp;

import com.wordcount.applicationInputParametersParser.AppInputParametersParser;
import com.wordcount.applicationInputReaderFactory.InputReaderFactory;
import com.wordcount.applicationOutputSource.ConsoleOutput;
import com.wordcount.applicationOutputWriter.ApplicationOutputWriter;
import com.wordcount.applicationUserInterface.ApplicationUserInterface;
import com.wordcount.interfaces.*;
import com.wordcount.mainApp.controller.WordCounterController;

public class WordCount {

    public static String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        InputParametersParser parser = new AppInputParametersParser(args);

        InputReaderAbstractFactory inputReaderFactory = new InputReaderFactory();

        InputReader inputReader = inputReaderFactory.getReader(parser.getInputFileName());

        OutputSource outputSource = new ConsoleOutput();
        OutputWriter outputWriter = new ApplicationOutputWriter(outputSource);

        UserInterface userInterface = new ApplicationUserInterface(inputReader, outputWriter);

        InputReader stopWordsReader = inputReaderFactory.getReader(STOP_WORDS_FILE_NAME);

        WordCounterController controller = new WordCounterController(userInterface, stopWordsReader);
        controller.countWords();
    }
}
