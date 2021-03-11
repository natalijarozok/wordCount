package com.wordcount.factory;

import com.wordcount.reader.InputReader;
import com.wordcount.reader.impl.ConsoleReaderImpl;
import com.wordcount.reader.impl.FileReaderImpl;

public class InputReaderFactory {

    private final String _fileName;

    public InputReaderFactory(String fileName) {
        _fileName = fileName;
    }

    public InputReader create() {

        if (_fileName == null) return null;

        InputReader reader;

        switch (_fileName) {

            case "":
                reader = new ConsoleReaderImpl();
                break;

            default:
                reader = new FileReaderImpl(_fileName);
        }

        return reader;
    }
}
