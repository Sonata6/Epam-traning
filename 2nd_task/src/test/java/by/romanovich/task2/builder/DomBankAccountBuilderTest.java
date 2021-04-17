package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.entity.RefillableAccount;
import by.romanovich.task2.exception.BankAccountException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.YearMonth;
import java.util.List;

public class DomBankAccountBuilderTest {
    @Test
    public void parseTest() throws BankAccountException, URISyntaxException {
        DomBankAccountBuilder builder = new DomBankAccountBuilder();
        URI uri = getClass().getResource("/data/BankAccount.xml").toURI();
        String absolutePath = new File(uri).getAbsolutePath();
        builder.buildAccounts(absolutePath);
        List<AbstractAccount> accounts = builder.getBankAccounts();
        RefillableAccount expected = new RefillableAccount(String worldTopNumber, String accountId, String bankName, String country, String depositor,
                String profitAbility, YearMonth timeConstraints, double amountOnDeposit, String login, boolean monthlyAccural) {
            super(worldTopNumber, accountId, bankName, country, depositor, profitAbility, timeConstraints, amountOnDeposit, login);
        AbstractAccount actual = accounts.get(0);
        Assert.assertEquals(expected, actual);
    }
}
