package com.wordcount.interfaces;

public interface InputReaderAbstractFactory {
    InputReader getReader(String inputFileName);
}
