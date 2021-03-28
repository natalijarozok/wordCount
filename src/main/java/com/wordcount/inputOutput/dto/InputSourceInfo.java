package com.wordcount.inputOutput.dto;

import com.wordcount.inputOutput.enums.InputSourceType;

public class InputSourceInfo {

    private InputSourceType type;

    public InputSourceType getType() {
        return type;
    }

    private String name;

    public String getName() {
        return name;
    }

    public InputSourceInfo(InputSourceType type, String name) {
        this.type = type;
        this.name = name;
    }
}
