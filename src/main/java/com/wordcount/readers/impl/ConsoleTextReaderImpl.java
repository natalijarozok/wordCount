package com.wordcount.readers.impl;

import com.wordcount.readers.ConsoleTextReader;

import java.util.Scanner;

public class ConsoleTextReaderImpl implements ConsoleTextReader {

    @Override
    public String read() {
        System.out.print("Enter text: ");
        String text = new Scanner(System.in).nextLine();
        return text;
    }
}
