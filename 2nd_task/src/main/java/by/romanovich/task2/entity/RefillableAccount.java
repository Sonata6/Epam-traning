package by.romanovich.task2.entity;

import java.time.YearMonth;
import java.util.Objects;

public class RefillableAccount extends AbstractAccount {
    private boolean monthlyAccural;

    public RefillableAccount() {
        // default values
        monthlyAccural = false;
    }

    public RefillableAccount(String worldTopNumber, String accountId, String bankName, String country, String depositor,
                             String profitAbility, YearMonth timeConstraints, double amountOnDeposit, String login, boolean monthlyAccural,
                             AccountDepositTypes type) {
        super(worldTopNumber, accountId, bankName, country, depositor, profitAbility, timeConstraints, amountOnDeposit, login, type);
        this.monthlyAccural = monthlyAccural;
    }

    public boolean getMonthlyAccural() {
        return monthlyAccural;
    }

    public void setMonthlyAccural(boolean monthlyAccural) {
        this.monthlyAccural = monthlyAccural;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + super.hashCode();
        result = result * prime + (monthlyAccural == false ? 31 : 32);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RefillableAccount another = (RefillableAccount) obj;

        return super.equals(another) && Objects.equals(monthlyAccural, another.monthlyAccural);
    }

    @Override
    public String toString() {
        return super.toString() + "; deviceType = " + monthlyAccural;
    }
}
