package by.romanovich.task2.builder;

enum BankAccountXmlAttribute {
    WORLD_TOP_NUMBER,
    LOGIN;

    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';

    @Override
    public String toString() {
        return name()
                .toLowerCase()
                .replace(UNDERSCORE, HYPHEN);
    }
}
