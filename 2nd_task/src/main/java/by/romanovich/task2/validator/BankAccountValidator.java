package by.romanovich.task2.validator;

import by.romanovich.task2.exception.BankAccountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BankAccountValidator {

    private static Logger logger = LogManager.getLogger();

    public static boolean validateXMLFile(String xmlPath, String xsdPath) throws BankAccountException {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setNamespaceAware(true);
            SAXParser parser = parserFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            SAXSource source = new SAXSource(reader, new InputSource(new FileInputStream(xmlPath)));
            validator.validate(source);
        } catch (IOException e) {
            throw new BankAccountException("Can't open file: " + xmlPath, e);
        } catch (ParserConfigurationException e) {
            logger.warn("Parser configuration exception ", e);
        } catch (SAXException e) {
            logger.warn("File {} is not valid: ", xmlPath, e);
            return false;
        }
        return true;
    }
}
