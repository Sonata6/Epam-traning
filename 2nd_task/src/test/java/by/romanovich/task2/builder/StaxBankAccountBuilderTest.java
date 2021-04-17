package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.entity.AccountDepositTypes;
import by.romanovich.task2.entity.RefillableAccount;
import by.romanovich.task2.exception.BankAccountException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.YearMonth;
import java.util.List;

public class StaxBankAccountBuilderTest {
    @Test
    public void parseTest() throws BankAccountException, URISyntaxException {
        StaxBankAccountBuilder builder = new StaxBankAccountBuilder();
        URI uri = getClass().getResource("/data/BankAccount.xml").toURI();
        String absolutePath = new File(uri).getAbsolutePath();
        builder.buildAccounts(absolutePath);
        List<AbstractAccount> accounts = builder.getBankAccounts();
        RefillableAccount expected = new RefillableAccount("7", "40227810099910004312", "Paribas",
                "France", "Bob", "2.0", YearMonth.of(2023, 06), 3000,
                "qwertyui", false, AccountDepositTypes.DEMAND);
        AbstractAccount actual = accounts.get(0);
        Assert.assertEquals(expected, actual);
    }
}
