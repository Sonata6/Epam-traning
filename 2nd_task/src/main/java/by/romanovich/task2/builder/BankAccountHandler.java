package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.entity.NonRefillableAccount;
import by.romanovich.task2.entity.RefillableAccount;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.YearMonth;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

class BankAccountHandler extends DefaultHandler {
    private static final char HYPHEN = '-';
    private static final char UNDERSCORE = '_';

    private Set<AbstractAccount> accounts;
    private EnumSet<BankAccountXmlTag> tagsWithTextContent;
    private AbstractAccount currentAccount;
    private BankAccountXmlTag currentTag;

    public BankAccountHandler() {
        accounts = new HashSet<>();
        //tagsWithTextContent = EnumSet.range(DeviceXmlTag.NAME, DeviceXmlTag.PERIPHERAL_DEVICE_PORT);
    }

    public Set<AbstractAccount> getAccounts() {
        return accounts;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String refirableAccountTag = BankAccountXmlTag.MONTHLY_ACCRUAL.toString();
        String nonRefirableAccountTag = BankAccountXmlTag.INTERMEDIATE_ACCRUAL.toString();

        if (refirableAccountTag.equals(qName) || nonRefirableAccountTag.equals(qName)) {
            currentAccount = refirableAccountTag.equals(qName)
                    ? new RefillableAccount()
                    : new NonRefillableAccount();

            String loginAttribute = BankAccountXmlAttribute.LOGIN.toString();
            String worldTopNumberAttribute = BankAccountXmlAttribute.WORLDTOPNUMBER.toString();

            for (int i = 0; i < attributes.getLength(); i++) {
                String attributeName = attributes.getQName(i);

                if (attributeName.equals(loginAttribute) || attributeName.equals((worldTopNumberAttribute))) {  //TODO
                    String login = attributes.getValue(i);
                    String worldTopNumber = attributes.getValue(i);

                    currentAccount.setLogin(login);
                    currentAccount.setWorldTopNumber(worldTopNumber);
                }
                else {
                    String worldTopNumber = attributes.getValue(i);
                    currentAccount.setWorldTopNumber(worldTopNumber);
                }
            }
//            if (tagsWithTextContent.contains(tag)) {
//                currentTag = tag;
//            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String refinableAccount = BankAccountXmlTag.REFILLABLE_ACCOUNT.toString();
        String nonRefirableAccount = BankAccountXmlTag.NON_REFILLABLE_ACCOUNT.toString();

        if (refinableAccount.equals(qName) || nonRefirableAccount.equals(qName)) {
            accounts.add(currentAccount);
            currentAccount = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);

        if (currentTag != null) {
            switch (currentTag) {
                case ACCOUNT_ID -> currentAccount.setAccountId(data);
                case NAME -> currentAccount.setBankName(data);

                case TIME_CONSTRAINTS -> currentAccount.setTimeConstraints(YearMonth.parse(data));
                case DEPOSITOR -> currentAccount.setDepositor(data);
                case COUNTRY -> currentAccount.setCountry(data);
                case PROFITABILITY -> currentAccount.setProfitAbility(data);
                case AMOUNT_ON_DEPOSIT -> currentAccount.setAmountOnDeposit(Double.parseDouble(data));
                case REFILLABLE_ACCOUNT -> {
                    RefillableAccount account = (RefillableAccount) currentAccount;
                    account.setMonthlyAccural(Boolean.parseBoolean(data));
                    //CRITICAL -> currentAccount.setCritical(Boolean.parseBoolean(data));
                }
                case NON_REFILLABLE_ACCOUNT -> {
                    NonRefillableAccount account = (NonRefillableAccount) currentAccount;
                    account.setIntermediateAccural(Boolean.parseBoolean(data));
                }

                default -> throw new EnumConstantNotPresentException(
                        currentTag.getDeclaringClass(), currentTag.name());
            }
        }

        currentTag = null;
    }

    private String toConstantName(String string) {
        return string.strip()
                .replace(HYPHEN, UNDERSCORE)
                .toUpperCase();
    }
}
