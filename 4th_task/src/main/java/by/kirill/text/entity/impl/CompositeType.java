package by.kirill.text.entity.Impl;

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
