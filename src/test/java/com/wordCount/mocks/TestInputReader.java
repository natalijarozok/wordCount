package com.wordCount.mocks;

import com.wordcount.interfaces.InputReader;

import java.util.List;

public class TestInputReader implements InputReader {

    private List<String> inputText;

    @Override
    public List<String> read() {
        return inputText;
    }

    public void returns(List<String> inputText) {
        this.inputText = inputText;
    }
}
