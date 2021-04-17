package by.romanovich.task2.entity;

import java.time.YearMonth;
import java.util.Objects;

public class NonRefillableAccount extends AbstractAccount {
    private boolean intermediateAccural;

    public NonRefillableAccount() {
        // default values
        intermediateAccural = false;
    }

    public NonRefillableAccount(String worldTopNumber, String accountId, String bankName, String country, String depositor,
                                String profitAbility, YearMonth timeConstraints, double amountOnDeposit, String login, boolean intermediateAccural,
                                AccountDepositTypes type) {
        super(worldTopNumber, accountId, bankName, country, depositor, profitAbility, timeConstraints, amountOnDeposit, login, type);
        this.intermediateAccural = intermediateAccural;
    }

    public boolean getIntermediateAccural() {
        return intermediateAccural;
    }

    public void setIntermediateAccural(boolean intermediateAccural) {
        this.intermediateAccural = intermediateAccural;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + super.hashCode();
        result = result * prime + (intermediateAccural == false ? 31 : 32);

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
        NonRefillableAccount another = (NonRefillableAccount) obj;

        return super.equals(another) && Objects.equals(intermediateAccural, another.intermediateAccural);
    }

    @Override
    public String toString() {
        return super.toString() + "; deviceType = " + intermediateAccural;
    }
}
