package com.wordcount.domain.enums;

public enum RunTimeOption {
    INDEX;

    public String toRunTimeFormat() {
        return new StringBuilder("-").append(this.name()).toString();
    }
}
