package by.romanovich.task2.builder;

public enum BankAccountXmlTag {
    BANK_ACCOUNTS,
    REFILLABLE_ACCOUNT,
    NON_REFILLABLE_ACCOUNT,
    ACCOUNT_ID,
    NAME,
    COUNTRY,
    DEPOSITOR,
    PROFITABILITY,
    TIME_CONSTRAINTS,
    AMOUNT_ON_DEPOSIT,
    MONTHLY_ACCRUAL,
    INTERMEDIATE_ACCRUAL;


    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';
    @Override
    public String toString() {
        return name()
                .toLowerCase()
                .replace(UNDERSCORE, HYPHEN);
    }
}