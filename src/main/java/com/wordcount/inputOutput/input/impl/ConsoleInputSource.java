package com.wordcount.inputOutput.input.impl;

import com.wordcount.inputOutput.input.InputSource;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputSource implements InputSource {

    @Override
    public List<String> read() {
        String startText = "Enter text: ";
        System.out.print(startText);
        return Collections.singletonList(new Scanner(System.in).nextLine());
    }
}
