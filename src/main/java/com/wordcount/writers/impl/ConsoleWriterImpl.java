package com.wordcount.writers.impl;

import com.wordcount.writers.ConsoleWriter;

public class ConsoleWriterImpl implements ConsoleWriter {

    @Override
    public void write(String outputText) {
        System.out.println(outputText);
    }
}
