package by.romanovich.task2.builder;

import by.romanovich.task2.exception.BankAccountException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

class SaxBankAccountBuilder extends AbstractBankAccountBuilder {
    private BankAccountHandler accountHandler;
    private XMLReader reader;

    public SaxBankAccountBuilder() throws BankAccountException {
        accountHandler = new BankAccountHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setContentHandler(accountHandler);
        } catch (ParserConfigurationException | SAXException e) {
            throw new BankAccountException("Parser configuration error", e);
        }
    }

    @Override
    public void buildAccounts(String xmlFilePath) throws BankAccountException {
        try {
            reader.parse(xmlFilePath);
        } catch (IOException | SAXException e) {
            throw new BankAccountException("SAX parsing exception", e);
        }
        accounts = accountHandler.getAccounts();
    }
}
