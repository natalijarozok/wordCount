package com.wordcount.inputOutput;

import com.wordcount.inputOutput.dto.InputSourceInfo;
import com.wordcount.inputOutput.enums.InputSourceType;

public class InputParametersParser {

    private final String[] args;

    public InputParametersParser(String[] args) {
        this.args = args;
    }

    public InputSourceInfo getInputSourceInfo() {
        String name = getFileName();
        InputSourceType type = "".equals(name) ? InputSourceType.CONSOLE : InputSourceType.FILE;
        return new InputSourceInfo(type, name);
    }

    private String getFileName() {
        String fileName = "";
        if (args.length > 0) {
            fileName = args[0];
        }
        return fileName;
    }
}
