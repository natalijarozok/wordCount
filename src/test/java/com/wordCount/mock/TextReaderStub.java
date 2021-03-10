package com.wordCount.mock;

import com.wordcount.reader.InputReader;

import java.util.List;

public interface TextReaderStub extends InputReader {
    void setup(List<String> inputText);
}
