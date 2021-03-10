package com.wordcount.domain.enums;

public enum RunTimeOptions {
    INDEX;
//            {
//        public String toRunTimeFormat() {
//            return new StringBuilder("-").append(RunTimeOptions.INDEX.name()).toString();
//        }
//    };

    //    public abstract String toRunTimeFormat();
    public String toRunTimeFormat() {
        return new StringBuilder("-").append(this.name()).toString();
    }

    ;

}
