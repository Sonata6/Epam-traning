package by.romanovich.task2.entity;

import java.time.YearMonth;
import java.util.Objects;

public abstract class AbstractAccount {
    private String worldTopNumber;
    private String accountId;
    private String bankName;
    private String country;
    private String depositor;
    private String profitAbility;
    private YearMonth timeConstraints;
        private double amountOnDeposit;
    private String login;

    public AbstractAccount(){

    }
    public AbstractAccount(String worldTopNumber, String accountId, String bankName, String country, String depositor,
                           String profitAbility, YearMonth timeConstraints, double amountOnDeposit, String login) {
        this.worldTopNumber = worldTopNumber;
        this.accountId = accountId;
        this.bankName = bankName;
        this.country = country;
        this.depositor = depositor;
        this.profitAbility = profitAbility;
        this.timeConstraints = timeConstraints;
        this.amountOnDeposit = amountOnDeposit;
        this.login = login;
    }

    public String getWorldTopNumber() {
        return worldTopNumber;
    }

    public void setWorldTopNumber(String worldTopNumber) {
        this.worldTopNumber = worldTopNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getProfitAbility() {
        return profitAbility;
    }

    public void setProfitAbility(String profitAbility) {
        this.profitAbility = profitAbility;
    }

    public YearMonth getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(YearMonth timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    public double getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public void setAmountOnDeposit(double amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
    }


    public String getAccountId() {
        return accountId;
    }

    public String getCountry() {
        return country;
    }

    public String getLogin() {
        return login;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLogin(String login) {
        this.login = login;
    }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AbstractAccount banks = (AbstractAccount) obj;

            return  this.accountId == banks.accountId &&
                    this.amountOnDeposit == banks.amountOnDeposit &&
                    Objects.equals(worldTopNumber, banks.worldTopNumber) &&
                    Objects.equals(bankName, banks.bankName) &&
                    Objects.equals(depositor, banks.depositor) &&
                    Objects.equals(timeConstraints, banks.timeConstraints);
        }

    @Override
    public int hashCode() {
        int result = 1;
        int hash = 31;
        result += hash + this.worldTopNumber.hashCode();
        result += hash + this.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nNumber in the worlds top: ");
        sb.append(worldTopNumber).append("\nLogin: ").append(login);
        sb.append("\nAccount id: ").append(accountId);
        sb.append("\nBank name: ").append(bankName );
        sb.append("\nLogin: ").append(login);
        sb.append("\nCountry: ").append(country);
        sb.append("\nDepositor: ").append(depositor );
        sb.append("\nProfitability: ").append(profitAbility);
        sb.append("\nTime constraints: ").append(timeConstraints);
        sb.append("\nAmount on deposit: ").append(amountOnDeposit );
        return sb.toString();
    }
}
