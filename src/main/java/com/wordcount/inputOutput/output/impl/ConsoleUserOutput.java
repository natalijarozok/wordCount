package com.wordcount.inputOutput.output.impl;


import com.wordcount.inputOutput.output.UserOutputSource;

public class ConsoleUserOutput implements UserOutputSource {

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
