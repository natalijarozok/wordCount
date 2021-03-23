package com.wordcount.readers.impl;

import com.wordcount.readers.ConsoleReader;

import java.util.Scanner;

public class ConsoleReaderImpl implements ConsoleReader {

    @Override
    public String read() {
        System.out.print("Enter text: ");
        String text = new Scanner(System.in).nextLine();
        return text;
    }
}
