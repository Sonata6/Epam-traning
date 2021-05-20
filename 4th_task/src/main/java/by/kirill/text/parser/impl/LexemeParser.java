package by.kirill.text.parser.Impl;

import by.kirill.text.entity.Impl.CompositeType;
import by.kirill.text.entity.Impl.TextComposite;
import by.kirill.text.exeption.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class LexemeParser implements Chain{
    private final String REGEX = "\\S+";
    private Chain currentChain;

    @Override
    public void setNextChain(Chain nextChain) {

        currentChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> lexemeList = TextHandler.handleText(data, REGEX);
        TextComposite lexemeTextComposite = new TextComposite(CompositeType.LEXEME);
        for (String lexeme : lexemeList) {
            TextComposite nextTextComposite = currentChain.parse(lexeme);
            lexemeTextComposite.add(nextTextComposite);
        }
        return lexemeTextComposite;

    }
}
