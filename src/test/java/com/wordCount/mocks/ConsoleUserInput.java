package com.wordCount.mocks;

import com.wordcount.inputOutput.input.UserInputSource;

public class ConsoleUserInput implements UserInputSource {

    private String inputText;

    @Override
    public String read() {
        return inputText;
    }

    public void returns(String inputText) {
        this.inputText = inputText;
    }
}
