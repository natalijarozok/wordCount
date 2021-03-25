package com.wordcount.userInterface;

import java.util.List;

public interface UserInterface {
    List<String> read();

    void write(String text);
}
