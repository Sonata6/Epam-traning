package by.kirill.text.parser.Impl;

import by.kirill.text.entity.Impl.CompositeType;
import by.kirill.text.entity.Impl.TextComposite;
import by.kirill.text.exeption.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class SymbolParser implements Chain{

    private final String REGEX = "[\\\"\\wА-я']+(-[\\\"\\wА-я']+)*";
    private Chain currentChain;

    @Override
    public void setNextChain(Chain nextChain) {

        currentChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> symbolList = TextHandler.handleText(data, REGEX);
        TextComposite symbolTextComposite = new TextComposite(CompositeType.SYMBOL);
        for (String symbol : symbolList) {
            TextComposite nextTextComposite = currentChain.parse(symbol);
            symbolTextComposite.add(nextTextComposite);
        }
        return symbolTextComposite;
    }
}
