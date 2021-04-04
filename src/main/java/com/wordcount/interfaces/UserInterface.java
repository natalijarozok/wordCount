package com.wordcount.interfaces;

import java.util.List;

public interface UserInterface {
    List<String> read();

    void write(String text);
}
