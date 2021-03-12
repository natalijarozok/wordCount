package com.wordcount;

import com.wordcount.controller.WordsStatisticController;
import com.wordcount.factory.InputReaderFactory;
import com.wordcount.paramsParser.ParamsParser;
import com.wordcount.reader.InputReader;
import com.wordcount.writer.AnswerWriter;
import com.wordcount.writer.ConsoleWriter;
import com.wordcount.writer.impl.AnswerWriterImpl;
import com.wordcount.writer.impl.ConsoleWriterImpl;

public class WordCount {

    private static final String STOP_WORDS_FILE_NAME = "stopwords.txt";

    public static void main(String[] args) {
        ParamsParser parser = new ParamsParser(args);
        parser.parse();
        InputReader inputDataReader = new InputReaderFactory(parser.getTextFileName()).create();
        InputReader stopWordsReader = new InputReaderFactory(STOP_WORDS_FILE_NAME).create();
        InputReader dictionaryReader = new InputReaderFactory(parser.getDictionaryFileName()).create();
        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        AnswerWriter answerWriter = new AnswerWriterImpl(consoleWriter);
        boolean includeWordsIndex = parser.getIncludeWordsIndex();

        WordsStatisticController controller = new WordsStatisticController(
                inputDataReader,
                stopWordsReader,
                dictionaryReader,
                answerWriter,
                includeWordsIndex
        );
        controller.execute();
    }
}
