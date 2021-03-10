package com.wordcount.reader.impl;

import com.wordcount.reader.InputReader;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleReaderImpl implements InputReader {

    @Override
    public List<String> read() {
        System.out.print("Enter text: ");
        String text = new Scanner(System.in).nextLine();
        return Arrays.asList(text);
    }
}
