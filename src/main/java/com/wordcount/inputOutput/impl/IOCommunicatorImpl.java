package com.wordcount.inputOutput.impl;

import com.wordcount.inputOutput.IOCommunicator;
import com.wordcount.inputOutput.input.UserInputReader;
import com.wordcount.inputOutput.output.UserOutputWriter;

public class IOCommunicatorImpl implements IOCommunicator {

    private final UserInputReader inputReader;

    private final UserOutputWriter outputWriter;

    public IOCommunicatorImpl(UserInputReader inputReader, UserOutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }


    @Override
    public String read() {
        return inputReader.read();
    }

    @Override
    public void write(String text) {
        outputWriter.write(text);
    }
}
