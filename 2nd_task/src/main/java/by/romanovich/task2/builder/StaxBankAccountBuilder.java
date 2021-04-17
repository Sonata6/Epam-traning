package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.entity.NonRefillableAccount;
import by.romanovich.task2.entity.RefillableAccount;
import by.romanovich.task2.exception.BankAccountException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.time.YearMonth;
import java.util.Optional;

public class StaxBankAccountBuilder extends AbstractBankAccountBuilder{
    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';

    private final String REFILLABLE_ACCOUNT_TAG;
    private final String NON_REFILLABLE_ACCOUNT_TAG;

    private XMLInputFactory inputFactory;

    public StaxBankAccountBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        REFILLABLE_ACCOUNT_TAG = BankAccountXmlTag.REFILLABLE_ACCOUNT.toString();
        NON_REFILLABLE_ACCOUNT_TAG = BankAccountXmlTag.NON_REFILLABLE_ACCOUNT.toString();
    }

    @Override
    public void buildAccounts(String xmlPath) throws BankAccountException {
        File file = new File(xmlPath);

        if (!file.exists() || file.isDirectory()) {
            throw new BankAccountException("Unable to open file with path: " + xmlPath);
        }

        XMLStreamReader reader;
        String name;

        try {
            Source source = new StreamSource(xmlPath);
            reader = inputFactory.createXMLStreamReader(source);

            while (reader.hasNext()) {
                int type = reader.next();

                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();

                    if (name.equals(REFILLABLE_ACCOUNT_TAG)) {
                        AbstractAccount account = new RefillableAccount();
                        buildEntity(account, reader);
                        accounts.add(account);
                    }

                    if (name.equals(NON_REFILLABLE_ACCOUNT_TAG)) {
                        AbstractAccount account = new NonRefillableAccount();
                        buildEntity(account, reader);
                        accounts.add(account);
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new BankAccountException("An error occurred during file reading", e);
        }
    }


    private void buildEntity(AbstractAccount account, XMLStreamReader reader) throws XMLStreamException, BankAccountException {
        String loginAttribute = BankAccountXmlAttribute.LOGIN.toString(); // todo
        String manufacturerWebsiteAttribute = BankAccountXmlAttribute.WORLDTOPNUMBER.toString();
        String accountId = reader.getAttributeValue(null, loginAttribute);
        String worldTopNumber = reader.getAttributeValue(null, manufacturerWebsiteAttribute);

        account.setLogin(accountId);
        account.setWorldTopNumber(worldTopNumber);
        String name;

        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT -> {
                    name = reader.getLocalName();
//                    String constantName = toConstantName(name);
//                    BankAccountXmlTag tag = BankAccountXmlTag.valueOf(constantName);
//                    initializeField(reader, tag, account);
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    name = reader.getLocalName();

                    if (name.equals(REFILLABLE_ACCOUNT_TAG) || name.equals(NON_REFILLABLE_ACCOUNT_TAG)) {
                        return;
                    }
                }
            }
        }

        throw new BankAccountException("Unable to build Device object");
    }

    private void initializeField(XMLStreamReader reader, BankAccountXmlTag tag, AbstractAccount account)
            throws XMLStreamException, BankAccountException {
        String data = getTextContent(reader)
                .orElseThrow(() -> new BankAccountException("Unable to get text content"));

        switch (tag) {
            case ACCOUNT_ID -> account.setAccountId(data);
            case NAME -> {
                account.setBankName(data);
            }
            case TIME_CONSTRAINTS -> account.setTimeConstraints(YearMonth.parse(data));
            case COUNTRY -> account.setCountry(data);
            case DEPOSITOR -> account.setDepositor(data);
            case PROFITABILITY -> account.setProfitAbility(data);
            case AMOUNT_ON_DEPOSIT -> account.setAmountOnDeposit(Double.parseDouble(data));
            case REFILLABLE_ACCOUNT -> {
                RefillableAccount refillableAccount = (RefillableAccount) account;
                refillableAccount.setMonthlyAccural(Boolean.parseBoolean(data));
            }
            case NON_REFILLABLE_ACCOUNT -> {
                NonRefillableAccount nonRefillableAccount = (NonRefillableAccount) account;
                nonRefillableAccount.setIntermediateAccural(Boolean.parseBoolean(data));
            }
            default -> throw new EnumConstantNotPresentException(
                    tag.getDeclaringClass(), tag.name());
        }
    }

    private String toConstantName(String string) {
        return string.strip()
                .replace(HYPHEN, UNDERSCORE)
                .toUpperCase();
    }

    private Optional<String> getTextContent(XMLStreamReader reader) throws XMLStreamException {
        Optional<String> result = Optional.empty();

        if (reader.hasNext()) {
            reader.next();
            String text = reader.getText();
            result = Optional.of(text);
        }

        return result;
    }
}
