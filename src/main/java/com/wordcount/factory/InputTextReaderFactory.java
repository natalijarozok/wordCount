package com.wordcount.factory;

import com.wordcount.readers.InputTextReader;
import com.wordcount.readers.impl.ConsoleInputTextReaderImpl;
import com.wordcount.readers.impl.FileInputTextReaderImpl;

public class InputTextReaderFactory {

    private String _fileName;

    public InputTextReaderFactory(String fileName) {
        _fileName = fileName != null ? fileName : "";
    }

    public InputTextReader create() {

        InputTextReader reader;

        switch (_fileName) {
            case "":
                reader = new ConsoleInputTextReaderImpl();
                break;

            default:
                reader = new FileInputTextReaderImpl();
        }

        return reader;
    }
}
