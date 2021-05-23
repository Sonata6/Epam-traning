package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class CharacterParser implements Chain{

    private final String SYMBOL_REGEX = "[\\s\\S]";
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> symbolList = TextHandler.handleText(data, SYMBOL_REGEX);
        TextComposite symbolTextComposite = new TextComposite(ComponentType.CHARACTER);
        for (String symbol : symbolList) {
            TextComposite nextTextComposite = nextChain.parse(symbol);
            symbolTextComposite.add(nextTextComposite);
        }
        return symbolTextComposite;
    }
}
