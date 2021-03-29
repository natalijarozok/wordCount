package com.wordcount.applicationOutputSource;


import com.wordcount.interfaces.OutputSource;

public class ConsoleOutput implements OutputSource {

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
