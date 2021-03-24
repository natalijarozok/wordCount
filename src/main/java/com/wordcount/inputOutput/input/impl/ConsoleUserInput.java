package com.wordcount.inputOutput.input.impl;

import com.wordcount.inputOutput.input.UserInputSource;

import java.util.Scanner;

public class ConsoleUserInput implements UserInputSource {

    @Override
    public String read() {
        String startText = "Enter text: ";
        System.out.print(startText);
        return new Scanner(System.in).nextLine();
    }
}
