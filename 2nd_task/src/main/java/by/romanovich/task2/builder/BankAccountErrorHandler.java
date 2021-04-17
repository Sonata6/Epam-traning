package by.romanovich.task2.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

class BankAccountErrorHandler implements ErrorHandler {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void warning(SAXParseException e) {
        logger.warn(getErrorPosition(e) + ": " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) {
        logger.error(getErrorPosition(e) + ": " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        logger.fatal(getErrorPosition(e) + ": " + e.getMessage());
    }

    private String getErrorPosition(SAXParseException e) {
        return "line " + e.getLineNumber() + " | column " + e.getColumnNumber();
    }
}
