package com.wordcount.inputOutput.input.impl;

import com.wordcount.inputOutput.input.UserInputSource;

import java.util.Scanner;

public class ConsoleUserInput implements UserInputSource {

    @Override
    public String read() {
        System.out.print("Enter text: ");
        String text = new Scanner(System.in).nextLine();
        return text;
    }
}
