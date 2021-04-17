package by.romanovich.task2.builder;

import by.romanovich.task2.entity.AbstractAccount;
import by.romanovich.task2.entity.AccountDepositTypes;
import by.romanovich.task2.entity.NonRefillableAccount;
import by.romanovich.task2.entity.RefillableAccount;
import by.romanovich.task2.exception.BankAccountException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.YearMonth;

public class DomBankAccountBuilder extends AbstractBankAccountBuilder{
    private DocumentBuilder documentBuilder;

    public DomBankAccountBuilder() throws BankAccountException {
        super();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new BankAccountException("Unable to configure parser", e);
        }
    }

    @Override
    public void buildAccounts(String xmlPath) throws BankAccountException {
        Document document;

        try {
            document = documentBuilder.parse(xmlPath);
            Element root = document.getDocumentElement();

            String refirableAccoutTag = BankAccountXmlTag.REFILLABLE_ACCOUNT.toString();
            String nonRefirableAccoutTag = BankAccountXmlTag.NON_REFILLABLE_ACCOUNT.toString();
            NodeList refirableAccounts = root.getElementsByTagName(refirableAccoutTag);
            NodeList nonRefirableAccounts = root.getElementsByTagName(nonRefirableAccoutTag);

            for (int i = 0; i < refirableAccounts.getLength(); i++) {
                Element element = (Element) refirableAccounts.item(i);
                AbstractAccount account = new RefillableAccount();
                buildEntity(element, account);
                accounts.add(account);
            }

            for (int i = 0; i < nonRefirableAccounts.getLength(); i++) {
                Element element = (Element) nonRefirableAccounts.item(i);
                AbstractAccount account = new NonRefillableAccount();
                buildEntity(element, account);
                accounts.add(account);
            }
        } catch (SAXException e) {
            throw new BankAccountException("Unable to parse XML file (" + xmlPath + ")", e);
        } catch (IOException e) {
            throw new BankAccountException("Unable to open XML file (" + xmlPath + ")", e);
        }
    }

    private void buildEntity(Element element, AbstractAccount account) {
        String loginAttribute = BankAccountXmlAttribute.LOGIN.toString();
        String worldTopNumberAttribute = BankAccountXmlAttribute.WORLD_TOP_NUMBER.toString();
        String accountIdTag = BankAccountXmlTag.ACCOUNT_ID.toString();
        String bankNameTag = BankAccountXmlTag.NAME.toString();
        String countryTag = BankAccountXmlTag.COUNTRY.toString();
        String depositorTag = BankAccountXmlTag.DEPOSITOR.toString();
        String profitabilityTag = BankAccountXmlTag.PROFITABILITY.toString();
        String timeConstraintsTag = BankAccountXmlTag.TIME_CONSTRAINTS.toString();
        String amountOnDepositTag = BankAccountXmlTag.AMOUNT_ON_DEPOSIT.toString();
        String typeTag = BankAccountXmlTag.TYPE.toString();

        AccountDepositTypes type = AccountDepositTypes.valueOf(getElementTextContent(element, typeTag).toUpperCase());
        String login = element.getAttribute(loginAttribute);
        String worldTopNumber = element.getAttribute(worldTopNumberAttribute);
        String accountId = getElementTextContent(element, accountIdTag);
        String bankName = getElementTextContent(element, bankNameTag);
        YearMonth timeConstraints = YearMonth.parse(getElementTextContent(element, timeConstraintsTag));
        String country = getElementTextContent(element, countryTag);
        double amountOnDeposit = Double.parseDouble(getElementTextContent(element, amountOnDepositTag));
        String depositor = getElementTextContent(element, depositorTag);
        String profitability = getElementTextContent(element, profitabilityTag);

        account.setType(type);
        account.setLogin(login);
        account.setWorldTopNumber(worldTopNumber);
        account.setAccountId(accountId);
        account.setBankName(bankName);
        account.setTimeConstraints(timeConstraints);
        account.setCountry(country);
        account.setAmountOnDeposit(amountOnDeposit);
        account.setDepositor(depositor);
        account.setProfitAbility(profitability);

        if (account instanceof RefillableAccount) {
            RefillableAccount refillableAccount = (RefillableAccount) account;
            String monthlyAccrualTag = BankAccountXmlTag.MONTHLY_ACCRUAL.toString();
            boolean monthlyAccrual = Boolean.parseBoolean(getElementTextContent(element, monthlyAccrualTag));
            refillableAccount.setMonthlyAccural(monthlyAccrual);
        } else {
            NonRefillableAccount nonRefillableAccount = (NonRefillableAccount) account;
            String intermediateAccrualTag = BankAccountXmlTag.INTERMEDIATE_ACCRUAL.toString();
            boolean intermediateAccrual = Boolean.parseBoolean(getElementTextContent(element, intermediateAccrualTag));
            nonRefillableAccount.setIntermediateAccural(intermediateAccrual);
        }
    }

    private String getElementTextContent(Element element, String name) {
        NodeList nodeList = element.getElementsByTagName(name);
        Node node = nodeList.item(0);

        return node.getTextContent();
    }
}
