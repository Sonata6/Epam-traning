package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.exception.BankAccountException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

class SaxBankAccountBuilder extends AbstractBankAccountBuilder {
    private BankAccountHandler handler;
    private XMLReader reader;

    public SaxBankAccountBuilder() throws BankAccountException {
        handler = new BankAccountHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(new BankAccountErrorHandler());
        } catch (SAXException | ParserConfigurationException e) {
            throw new BankAccountException("Unable to configure SAX parser", e);
        }
    }

    @Override
    public void buildAccounts(String xmlPath) throws BankAccountException {
        try {
            reader.parse(xmlPath);
        } catch (IOException e) {
            throw new BankAccountException("Unable to open XML file (" + xmlPath + ")", e);
        } catch (SAXException e) {
            throw new BankAccountException("Unable to parse XML file (" + xmlPath + ")", e);
        }

        accounts = (List<AbstractAccount>) handler.getAccounts();
    }
}
