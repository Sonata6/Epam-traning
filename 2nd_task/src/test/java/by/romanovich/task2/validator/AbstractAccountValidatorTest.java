package by.romanovich.task2.validator;

import by.romanovich.task2.exception.BankAccountException;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class AbstractAccountValidatorTest {
    @Test
    public void parseTest() throws BankAccountException, URISyntaxException, ParserConfigurationException {
        URI uri = getClass().getResource("/data/BankAccount.xml").toURI();
        String xmlPath = new File(uri).getAbsolutePath();
        uri = getClass().getResource("/data/BankAccountTable.xsd").toURI();
        String xsdPath = new File(uri).getAbsolutePath();
        boolean expected = true;
        boolean actual = BankAccountValidator.validateXMLFile(xmlPath, xsdPath);
        Assert.assertEquals(actual, expected);
    }
}
