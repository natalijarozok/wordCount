package com.wordcount.domain.enums;

public enum InputOptionType {
    INDEX,
    DICTIONARY;

    public static final String prefix = "-";

    public String format() {
        return prefix + this.name();
    }
}
