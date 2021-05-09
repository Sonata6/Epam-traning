package by.kirill.text.entity.Impl;

public enum TextComponentType {
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(""),
    WORD(""),
    SYMBOL(""),
    PUNCTUATION("");


    private final String delimiter;

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
