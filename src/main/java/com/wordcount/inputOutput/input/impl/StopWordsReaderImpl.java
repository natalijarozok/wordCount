package com.wordcount.inputOutput.input.impl;

import com.wordcount.domain.WordCounter;
import com.wordcount.inputOutput.input.StopWordsReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StopWordsReaderImpl implements StopWordsReader {

    private String stopWordsFileName = "stopwords.txt";

    public StopWordsReaderImpl() {
    }

    public StopWordsReaderImpl(String stopWordsFileName) {
        this.stopWordsFileName = stopWordsFileName;
    }

    @Override
    public List<String> read() {

        List<String> stopWords = new ArrayList<>();
        String line;

        try {
            BufferedReader bufferedReader = getStopWordsFilerReader();
            while ((line = bufferedReader.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (Error ignored) {

        } catch (Exception ignored) {

        }

        return stopWords;
    }

    private BufferedReader getStopWordsFilerReader() throws FileNotFoundException {
        URL fileUrl = WordCounter.class.getClassLoader().getResource(stopWordsFileName);
        assert fileUrl != null;
        File file = new File(fileUrl.getFile());
        return new BufferedReader(new FileReader(file));
    }
}
