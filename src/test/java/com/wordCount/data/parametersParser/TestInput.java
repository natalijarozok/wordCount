package com.wordCount.data.parametersParser;


import java.util.List;

public class TestInput {

    public List<TestDataStructure> get() {
        List<TestDataStructure> testDataCollection = TestDataSource.getData();
        return testDataCollection;
    }
}
