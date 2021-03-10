package com.wordcount;

import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.domain.enums.RunTimeOptions;

import java.util.Arrays;

public class RunTimeParamsParser {

    public static String getInputTextFileName(String[] args) {
        return (args.length > 0 && !isParamARunTimeOption(args[0])) ? args[0] : "";
    }

    public static WordsStatisticOptions getWordsStatisticOptions(String[] args) {
        String option = RunTimeOptions.INDEX.toRunTimeFormat();
        boolean includeWordIndex = Arrays.stream(args)
                .filter(arg -> arg.equalsIgnoreCase(option))
                .count() > 1;
        return new WordsStatisticOptions(includeWordIndex);
    }

    private static boolean isParamARunTimeOption(String param) {
        return Arrays.stream(RunTimeOptions.values())
                .filter(option -> option.name().equalsIgnoreCase(param))
                .count() > 1;
    }
}
