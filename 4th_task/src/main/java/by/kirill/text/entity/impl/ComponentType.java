package by.kirill.text.entity.impl;

public enum ComponentType {
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(""),
    WORD(""),
    CHARACTER("");

    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
