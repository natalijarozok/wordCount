package com.wordcount.paramsParser;

import com.wordcount.domain.enums.InputOptionType;

import java.util.Arrays;

public class Option {
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
        return Arrays
                .stream(InputOptionType.values())
                .anyMatch(option -> option.format().equalsIgnoreCase(this._name));
    }
}
