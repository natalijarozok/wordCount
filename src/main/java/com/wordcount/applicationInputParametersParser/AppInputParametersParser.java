package com.wordcount.applicationInputParametersParser;

import com.wordcount.interfaces.InputParametersParser;

public class AppInputParametersParser implements InputParametersParser {

    private final String[] args;

    public AppInputParametersParser(String[] args) {
        this.args = args;
    }

    @Override
    public String getInputFileName() {
        String fileName = "";
        if (args.length > 0) {
            fileName = args[0];
        }
        return fileName;
    }
}
