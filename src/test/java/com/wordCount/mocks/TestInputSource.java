package com.wordCount.mocks;

import com.wordcount.inputOutput.input.InputSource;

import java.util.List;

public class TestInputSource implements InputSource {

    private List<String> inputText;

    @Override
    public List<String> read() {
        return inputText;
    }

    public void returns(List<String> inputText) {
        this.inputText = inputText;
    }
}
