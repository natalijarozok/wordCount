package com.wordcount.applicationInputReader;

import com.wordcount.interfaces.InputReader;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public List<String> read() {
        String startText = "Enter text: ";
        System.out.print(startText);
        return Collections.singletonList(new Scanner(System.in).nextLine());
    }
}
