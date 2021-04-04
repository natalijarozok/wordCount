package com.wordcount.applicationInputReader;

import com.wordcount.interfaces.InputReader;
import com.wordcount.mainApp.domain.WordCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileInputReader implements InputReader {

    private final String resourceFileName;

    public FileInputReader(String resourceFileName) {
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
