package com.wordcount.applicationInputReaderFactory;

import com.wordcount.applicationInputReader.ConsoleInputReader;
import com.wordcount.applicationInputReader.FileInputReader;
import com.wordcount.interfaces.InputReaderAbstractFactory;
import com.wordcount.interfaces.InputReader;

public class InputReaderFactory implements InputReaderAbstractFactory {

    public InputReader getReader(String inputFileName) {
        InputReader reader;

        if ("".equals(inputFileName)) {
            reader = new ConsoleInputReader();
        } else {
            reader = new FileInputReader(inputFileName);
        }

        return reader;
    }
}
