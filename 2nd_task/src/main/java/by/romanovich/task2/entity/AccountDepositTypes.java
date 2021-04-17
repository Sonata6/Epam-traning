package by.romanovich.task2.entity;

public enum AccountDepositTypes {
    DEMAND,
    TIME,
    SETTLEMENT,
    ACCUMULATIVE,
    SAVINGS,
    METAL;

    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';

    @Override
    public String toString() {
        return name()
                .toLowerCase()
                .replace(UNDERSCORE, HYPHEN);
    }
}
