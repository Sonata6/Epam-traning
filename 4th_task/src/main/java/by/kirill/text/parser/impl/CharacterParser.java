package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.BaseParser;
import by.kirill.text.parser.TextHandler;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CharacterParser implements BaseParser {

    private BaseParser nextBaseParser;
    private final String CHARACTER_CHAIN = "[\\s\\S]";
    private static Logger logger = LogManager.getRootLogger();

    @Override
    public void setNextChain(BaseParser nextBaseParser) {
        logger.log(Level.INFO, "This is last element of chain");

    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> symbolList = TextHandler.handleText(data, CHARACTER_CHAIN);
        TextComposite symbolTextComposite = new TextComposite(ComponentType.CHARACTER);
        for (String symbol : symbolList) {
            TextComposite nextTextComposite = nextBaseParser.parse(symbol);
            symbolTextComposite.add(nextTextComposite);
        }
        return symbolTextComposite;
    }
}
