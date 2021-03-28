package com.wordcount.factory;

import com.wordcount.inputOutput.dto.InputSourceInfo;
import com.wordcount.inputOutput.enums.InputSourceType;
import com.wordcount.inputOutput.input.InputSource;
import com.wordcount.inputOutput.input.impl.ConsoleInputSource;
import com.wordcount.inputOutput.input.impl.FileInputSource;

public class InputSourceFactory {

    public InputSource create(InputSourceInfo inputSourceInfo) {
        InputSource source;

        if (inputSourceInfo.getType() == InputSourceType.CONSOLE) {
            source = new ConsoleInputSource();
        } else {
            source = new FileInputSource(inputSourceInfo.getName());
        }

        return source;
    }
}
