package com.wordcount;

import com.wordcount.controllers.WordCounterController;
import com.wordcount.factory.InputSourceFactory;
import com.wordcount.inputOutput.InputParametersParser;
import com.wordcount.inputOutput.dto.InputSourceInfo;
import com.wordcount.inputOutput.enums.InputSourceType;
import com.wordcount.inputOutput.input.InputReader;
import com.wordcount.inputOutput.input.InputSource;
import com.wordcount.inputOutput.input.impl.InputResourcesReader;
import com.wordcount.inputOutput.output.OutputSource;
import com.wordcount.inputOutput.output.OutputWriter;
import com.wordcount.inputOutput.output.impl.ConsoleOutput;
import com.wordcount.inputOutput.output.impl.OutputConsoleWriter;
import com.wordcount.userInterface.UserInterface;
import com.wordcount.userInterface.impl.UserCommunicator;

public class WordCount {

    public static String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        InputParametersParser parser = new InputParametersParser(args);

        InputSource userInputSource = new InputSourceFactory().create(parser.getInputSourceInfo());
        InputReader inputReader = new InputResourcesReader(userInputSource);

        OutputSource userOutputSource = new ConsoleOutput();
        OutputWriter outputWriter = new OutputConsoleWriter(userOutputSource);

        UserInterface userCommunicator = new UserCommunicator(inputReader, outputWriter);

        InputSourceInfo stopWordsSourceInfo = new InputSourceInfo(InputSourceType.FILE, STOP_WORDS_FILE_NAME);
        InputSource stopWordsInputSource = new InputSourceFactory().create(stopWordsSourceInfo);
        InputReader stopWordsReader = new InputResourcesReader(stopWordsInputSource);

        WordCounterController controller = new WordCounterController(userCommunicator, stopWordsReader);
        controller.countWords();
    }
}
