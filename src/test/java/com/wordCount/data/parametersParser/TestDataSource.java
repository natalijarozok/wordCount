package com.wordCount.data.parametersParser;


import com.wordCount.data.parametersParser.entity.TestData;

import java.util.ArrayList;
import java.util.List;

import static com.wordCount.data.parametersParser.entity.TestData.data;

public class TestDataSource {

    public static List<TestData> getTestData() {
        return new ArrayList<TestData>() {{
            add(data(null, null, null, "", false, null));
            add(data(null, "-index", null, "", true, null));
            add(data(null, "-index", "-dictionary", "", true, null));
            add(data(null, "-index", "-dictionary=", "", true, null));
            add(data(null, null, "-dictionary", "", false, null));
            add(data(null, null, "-dictionary=", "", false, null));
            add(data(null, null, "-dictionary=dic.txt", "", false, "dic.txt"));
            add(data("mytext.txt", null, null, "mytext.txt", false, null));
            add(data("mytext.txt", "-index", null, "mytext.txt", true, null));
            add(data("mytext.txt", "-index", "-dictionary", "mytext.txt", true, null));
            add(data("mytext.txt", "-index", "-dictionary=", "mytext.txt", true, null));
            add(data("mytext.txt", "-index", "-dictionary=dic.txt", "mytext.txt", true, "dic.txt"));
            add(data("mytext.txt", null, "-dictionary", "mytext.txt", false, null));
            add(data("mytext.txt", null, "-dictionary=", "mytext.txt", false, null));
            add(data("mytext.txt", null, "-dictionary=dic.txt", "mytext.txt", false, "dic.txt"));
        }};
    }
}
