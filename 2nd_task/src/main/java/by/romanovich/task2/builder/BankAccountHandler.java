package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.entity.AccountDepositTypes;
import by.romanovich.task2.entity.NonRefillableAccount;
import by.romanovich.task2.entity.RefillableAccount;
import by.romanovich.task2.parameter.BankAccountParameter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

class BankAccountHandler extends DefaultHandler {

    private static final Logger logger = LogManager.getRootLogger();

    private List<AbstractAccount> accounts;
    private AbstractAccount currentAccount;
    private StringBuilder elementValue;

    public BankAccountHandler() {
        accounts = new ArrayList<>();
    }

    public List<AbstractAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        elementValue = new StringBuilder();
        elementValue.append(ch, start, length);
    }

    @Override
    public void startDocument() {
        elementValue = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        logger.log(Level.DEBUG, "initializing start elements.");
        switch (qualifiedName) {
            case BankAccountParameter.REFILLABLE_ACCOUNT:
                currentAccount = new RefillableAccount();
                currentAccount.setLogin(attributes.getValue(0));
                currentAccount.setWorldTopNumber(attributes.getValue(1));
                break;
            case BankAccountParameter.NON_REFILLABLE_ACCOUNT:
                currentAccount = new NonRefillableAccount();
                currentAccount.setLogin(attributes.getValue(0));
                currentAccount.setWorldTopNumber(attributes.getValue(1));
                break;
            default:
                logger.log(Level.DEBUG, qualifiedName);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) {
        logger.log(Level.DEBUG, "initializing end elements.");
        switch (qualifiedName) {
            case BankAccountParameter.REFILLABLE_ACCOUNT -> accounts.add(currentAccount);
            case BankAccountParameter.NON_REFILLABLE_ACCOUNT -> accounts.add(currentAccount);
            case BankAccountParameter.ACCOUNT_ID -> currentAccount.setAccountId(elementValue.toString());
            case BankAccountParameter.NAME -> currentAccount.setBankName(elementValue.toString());
            case BankAccountParameter.TYPE -> {
                currentAccount.setType(AccountDepositTypes.valueOf(elementValue.toString().toUpperCase()));
            }
            case BankAccountParameter.TIME_CONSTRAINTS -> currentAccount.setTimeConstraints(YearMonth.parse(elementValue.toString()));
            case BankAccountParameter.DEPOSITOR -> currentAccount.setDepositor(elementValue.toString());
            case BankAccountParameter.COUNTRY -> currentAccount.setCountry(elementValue.toString());
            case BankAccountParameter.PROFITABILITY -> currentAccount.setProfitAbility(elementValue.toString());
            case BankAccountParameter.AMOUNT_ON_DEPOSIT -> currentAccount.setAmountOnDeposit(Double.parseDouble(elementValue.toString()));
            case BankAccountParameter.MONTHLY_ACCRUAL -> {
                RefillableAccount account = (RefillableAccount) currentAccount;
                account.setMonthlyAccural(Boolean.parseBoolean(elementValue.toString()));
            }
            case BankAccountParameter.INTERMEDIATE_ACCRUAL -> {
                NonRefillableAccount account = (NonRefillableAccount) currentAccount;
                account.setIntermediateAccural(Boolean.parseBoolean(elementValue.toString()));
                break;
            }
            default -> logger.log(Level.DEBUG, qualifiedName);
        }
    }
}
