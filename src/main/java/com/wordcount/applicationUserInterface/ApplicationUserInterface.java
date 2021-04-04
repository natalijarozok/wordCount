package com.wordcount.applicationUserInterface;

import com.wordcount.interfaces.InputReader;
import com.wordcount.interfaces.OutputWriter;
import com.wordcount.interfaces.UserInterface;

import java.util.List;

public class ApplicationUserInterface implements UserInterface {

    private final InputReader inputReader;

    private final OutputWriter outputWriter;

    public ApplicationUserInterface(InputReader inputReader, OutputWriter outputWriter) {
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
