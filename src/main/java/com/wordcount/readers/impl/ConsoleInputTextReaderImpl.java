package com.wordcount.readers.impl;

import com.wordcount.readers.InputTextReader;

import java.util.Scanner;

public class ConsoleInputTextReaderImpl implements InputTextReader {

    @Override
    public String read() {
        System.out.print("Enter text: ");
        String text = new Scanner(System.in).nextLine();
        return text;
    }
}
