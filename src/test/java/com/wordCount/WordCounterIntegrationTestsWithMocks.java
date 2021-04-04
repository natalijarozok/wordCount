package com.wordCount;

import com.wordCount.mocks.StopWordsReader;
import com.wordCount.mocks.TestInputReader;
import com.wordCount.mocks.TestOutputSource;
import com.wordcount.applicationOutputWriter.ApplicationOutputWriter;
import com.wordcount.applicationUserInterface.ApplicationUserInterface;
import com.wordcount.interfaces.OutputWriter;
import com.wordcount.interfaces.UserInterface;
import com.wordcount.mainApp.controller.WordCounterController;
import org.junit.jupiter.api.Test;

import static com.wordCount.data.DataSource.getData;

public class WordCounterIntegrationTestsWithMocks {

    @Test
    public void count_words() {
        TestInputReader inputReader = new TestInputReader();

        TestOutputSource outputSource = new TestOutputSource();
        OutputWriter outputWriter = new ApplicationOutputWriter(outputSource);

        UserInterface ioCommunicator = new ApplicationUserInterface(inputReader, outputWriter);

        StopWordsReader stopWords = new StopWordsReader();

        getData().forEach(testData ->
                {
                    inputReader.returns(testData.inputText());
                    stopWords.contain(testData.stopWords());

                    WordCounterController sut = new WordCounterController(
                            ioCommunicator,
                            stopWords
                    );
                    sut.countWords();

                    outputSource
                            .forUserInput(testData)
                            .writes(
                                    String.format(
                                            "Number of words: %d",
                                            testData.expectedWordCount()
                                    )
                            );
                }
        );

    }
}
