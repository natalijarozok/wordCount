package com.wordcount.readers.impl;

import com.wordcount.domain.WordCounter;
import com.wordcount.readers.StopWordsReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StopWordsReaderImpl implements StopWordsReader {

    private final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    @Override
    public List<String> read() {

        List<String> stopWords = new ArrayList<>();
        String line;

        try {
            BufferedReader bufferedReader = getStopWordsFilerReader();
            while ((line = bufferedReader.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
        }

        return stopWords;
    }

    private BufferedReader getStopWordsFilerReader() throws FileNotFoundException {
        URL fileUrl = WordCounter.class.getClassLoader().getResource(STOP_WORDS_FILE_NAME);
        File file = new File(fileUrl.getFile());
        return new BufferedReader(new FileReader(file));
    }
}
