package com.wordcount.writer.impl;

import com.wordcount.writer.ConsoleWriter;

public class ConsoleWriterImpl implements ConsoleWriter {

    @Override
    public void write(String outputText) {
        System.out.println(outputText);
    }
}
