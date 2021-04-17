package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.exception.BankAccountException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBankAccountBuilder {

    protected List<AbstractAccount> accounts;

    protected AbstractBankAccountBuilder() {

        accounts = new ArrayList<>();
    }

    protected AbstractBankAccountBuilder(List<AbstractAccount> accounts) {
        this.accounts = new ArrayList<>(accounts);
    }

    public List<AbstractAccount> getBankAccounts() {

        return new ArrayList<>(accounts);
    }

    public abstract void buildAccounts(String xmlFilePath) throws BankAccountException;
}
