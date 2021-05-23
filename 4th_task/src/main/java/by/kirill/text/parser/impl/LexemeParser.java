package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.CompositeType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class LexemeParser implements Chain{
    private final String LEXEME_REGEX = "\\S";
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> lexemeList = TextHandler.handleText(data, LEXEME_REGEX);
        TextComposite lexemeTextComposite = new TextComposite(CompositeType.LEXEME);
        for (String lexeme : lexemeList) {
            TextComposite nextTextComposite = nextChain.parse(lexeme);
            lexemeTextComposite.add(nextTextComposite);
        }
        return lexemeTextComposite;

    }
}
