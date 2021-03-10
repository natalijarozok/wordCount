package com.wordcount;

import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.domain.enums.RunTimeOption;

import java.util.Arrays;

public class ParamsParser {

    public static String getInputTextFileName(String[] args) {
        return (args.length > 0 && !isParamAValidOption(args[0])) ? args[0] : "";
    }

    public static WordsStatisticOptions getWordsStatisticOptions(String[] args) {
        boolean includeWordIndex = isOptionSpecified(args, RunTimeOption.INDEX);
        return new WordsStatisticOptions(includeWordIndex);
    }

    private static boolean isOptionSpecified(String[] params, RunTimeOption option) {
        return Arrays.stream(params)
                .filter(arg -> arg.equalsIgnoreCase(option.toRunTimeFormat()))
                .count() > 0;
    }

    private static boolean isParamAValidOption(String param) {
        return Arrays.stream(RunTimeOption.values())
                .filter(option -> option.toRunTimeFormat().equalsIgnoreCase(param))
                .count() > 0;
    }
}
