package com.wordCount;

import com.wordCount.mocks.StopWordsReader;
import com.wordCount.mocks.TestInputSource;
import com.wordCount.mocks.TestOutputSource;
import com.wordcount.controllers.WordCounterController;
import com.wordcount.userInterface.UserInterface;
import com.wordcount.inputOutput.input.InputReader;
import com.wordcount.inputOutput.input.impl.InputResourcesReader;
import com.wordcount.inputOutput.output.OutputWriter;
import com.wordcount.inputOutput.output.impl.OutputConsoleWriter;
import com.wordcount.userInterface.impl.UserCommunicator;
import org.junit.jupiter.api.Test;

import static com.wordCount.data.DataSource.getData;

public class WordCounterIntegrationTestsWithMocks {

    @Test
    public void count_words() {
        TestInputSource inputSource = new TestInputSource();
        InputReader inputReader = new InputResourcesReader(inputSource);

        TestOutputSource outputSource = new TestOutputSource();
        OutputWriter outputWriter = new OutputConsoleWriter(outputSource);

        UserInterface ioCommunicator = new UserCommunicator(inputReader, outputWriter);

        StopWordsReader stopWords = new StopWordsReader();

        getData().forEach(testData ->
                {
                    inputSource.returns(testData.inputText());
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
