package com.wordcount;

import com.wordcount.domain.dto.WordsStatisticOptions;
import com.wordcount.domain.enums.InputOptionType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParamsParser {
    private String _args[];
    private List<Option> _inputOptions;

    private String _textFileName = "";

    public String getTextFileName() {
        return _textFileName;
    }

    private WordsStatisticOptions _statisticsOptions = new WordsStatisticOptions(false);

    public WordsStatisticOptions getStatisticsOptions() {
        return _statisticsOptions;
    }

    private String _dictionaryFileName;

    public String getDictionaryFileName() {
        return _dictionaryFileName;
    }

    public ParamsParser(String[] args) {
        _args = args;
        parse();
    }

    private void parse() {
        if (_args.length == 0) return;
        setInputOptions();
        setTextFileName();
        setStatisticsOptions();
        setDictionaryFileName();
    }

    private void setTextFileName() {
        if (isParameter(_args[0]))
            _textFileName = _args[0];
    }

    private void setStatisticsOptions() {
        if (isOptionSpecified(InputOptionType.INDEX))
            _statisticsOptions.showWordsIndex();
    }

    private void setDictionaryFileName() {
        Option option = findOption(InputOptionType.DICTIONARY);
        if (option != null)
            _dictionaryFileName = option.getValue();
    }

    private void setInputOptions() {
        _inputOptions = Arrays.stream(_args)
                .filter(arg -> arg.startsWith("-"))
                .map(arg -> toOption(arg))
                .filter(option -> option.isValid())
                .collect(Collectors.toList());
    }

    private boolean isOptionSpecified(InputOptionType optionType) {
        return findOption(optionType) != null;
    }

    private Option findOption(InputOptionType optionType) {
        Optional<Option> option = _inputOptions.stream()
                .filter(inputOption -> inputOption.getName().equalsIgnoreCase(optionType.format()))
                .findFirst();
        return option.isPresent() ? option.get() : null;
    }

    private boolean isParameter(String parameter) {
        return !parameter.startsWith(InputOptionType.prefix);
    }

    private Option toOption(String parameter) {
        String[] parameterParts = parameter.split("=");
        String name = parameterParts.length > 0 ? parameterParts[0] : "";
        String value = parameterParts.length > 1 ? parameterParts[1] : "";
        return new Option(name, value);
    }
}

class Option {
    private String _name;

    public String getName() {
        return _name;
    }

    private String _value;

    public String getValue() {
        return _value;
    }

    public Option(String name, String value) {
        _name = name;
        _value = value;
    }

    public boolean isValid() {
        return Arrays.stream(InputOptionType.values())
                .filter(option -> option.format().equalsIgnoreCase(this._name))
                .count() > 0;
    }
}