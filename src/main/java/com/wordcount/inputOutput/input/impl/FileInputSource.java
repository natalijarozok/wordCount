package com.wordcount.inputOutput.input.impl;

import com.wordcount.domain.WordCounter;
import com.wordcount.inputOutput.input.InputSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileInputSource implements InputSource {

    private final String resourceFileName;

    public FileInputSource(String resourceFileName) {
        this.resourceFileName = resourceFileName;
    }

    @Override
    public List<String> read() {

        List<String> content = new ArrayList<>();
        String line;

        try {
            BufferedReader bufferedReader = getFilerReader();
            while ((line = bufferedReader.readLine()) != null) {
                content.add(line);
            }
        } catch (Error | Exception ignored) {
        }

        return content;
    }

    private BufferedReader getFilerReader() throws FileNotFoundException {
        URL fileUrl = WordCounter.class.getClassLoader().getResource(resourceFileName);
        assert fileUrl != null;
        File file = new File(fileUrl.getFile());
        return new BufferedReader(new FileReader(file));
    }
}
