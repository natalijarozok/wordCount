package com.wordCount.mocks;

import com.wordcount.readers.InputReader;

import java.util.List;

public interface TextReaderStub extends InputReader {
    void setup(List<String> inputText);
}
