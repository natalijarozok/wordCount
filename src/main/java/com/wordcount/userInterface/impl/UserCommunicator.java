package com.wordcount.userInterface.impl;

import com.wordcount.inputOutput.input.InputReader;
import com.wordcount.inputOutput.output.OutputWriter;
import com.wordcount.userInterface.UserInterface;

import java.util.List;

public class UserCommunicator implements UserInterface {

    private final InputReader inputReader;

    private final OutputWriter outputWriter;

    public UserCommunicator(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }


    @Override
    public List<String> read() {
        return inputReader.read();
    }

    @Override
    public void write(String text) {
        outputWriter.write(text);
    }
}
