package by.romanovich.task2.builder;

import by.romanovich.task2.exception.BankAccountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccountBuilderFactory {
        private static Logger logger = LogManager.getLogger();
        private enum ParserType {
            DOM, SAX, STAX
        }

        private BankAccountBuilderFactory() { }

        public static AbstractBankAccountBuilder createDeviceBuilder(String parserType) throws BankAccountException {
            try {
                ParserType type = ParserType.valueOf(parserType.toUpperCase());

                return switch (type) {
                    case DOM -> new DomBankAccountBuilder();
                    case SAX -> new SaxBankAccountBuilder();
                    case STAX -> new StaxBankAccountBuilder();
                };
            } catch (IllegalArgumentException e) {
                logger.error("Parser with name '" + parserType + "' not found");
                throw new BankAccountException("Parser with name '" + parserType + "' not found", e);
            }
        }
}
