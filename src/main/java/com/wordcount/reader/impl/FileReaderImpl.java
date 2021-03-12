package com.wordcount.reader.impl;

import com.wordcount.ActionQueue;
import com.wordcount.WordCount;
import com.wordcount.reader.InputReader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReaderImpl implements InputReader {

    protected String _fileName;

    public FileReaderImpl(String fileName) {
        _fileName = fileName != null ? fileName : "";
    }

    @Override
    public List<String> read() {
        List<String> lines = Collections.emptyList();

        try {
            lines = readFile();
        } catch (Exception ignored) {
        }

        return lines;
    }

    private List<String> readFile() throws IOException {
        List<String> lines = new ArrayList<>();
        String line;

        BufferedReader bufferedReader = getFilerReader();
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

    private BufferedReader getFilerReader() throws FileNotFoundException {
        URL fileUrl = WordCount.class.getClassLoader().getResource(_fileName);
        File file = new File(fileUrl.getFile());
        ActionQueue.getInstance().add(this);
        return new BufferedReader(new FileReader(file));
    }

}
