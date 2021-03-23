package com.wordcount.domain.dto;

public class Word {
    private final String _value;

    public String getValue() {
        return _value;
    }

    private boolean _isKnown = true;

    public Word(String value) {
        _value = value;
    }

    public Word(String value, boolean isKnown) {
        _value = value;
        _isKnown = isKnown;
    }

    public boolean wordIsKnown() {
        return _isKnown;
    }

    public void makeWordUnknown() {
        _isKnown = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word that = (Word) o;
        return _value.equals(that._value) &&
                _isKnown == that._isKnown;
    }

    @Override
    public String toString() {
        return String.format("[value: %s, isKnown: %s]", _value, _isKnown);
    }
}
