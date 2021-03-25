package com.wordcount.inputOutput.output.impl;


import com.wordcount.inputOutput.output.OutputSource;

public class ConsoleOutput implements OutputSource {

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
