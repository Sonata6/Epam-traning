package by.kirill.text.entity.impl;

public enum CompositeType {
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(""),
    WORD(""),
    SYMBOL(""),
    PUNCTUATION("");


    private final String delimiter;

    CompositeType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
