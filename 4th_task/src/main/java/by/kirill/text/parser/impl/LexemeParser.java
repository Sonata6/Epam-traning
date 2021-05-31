package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.BaseParser;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class LexemeParser implements BaseParser {
    private final String LEXEME_REGEX = "[\\S]+[\\s]?";
    private BaseParser nextBaseParser;

    @Override
    public void setNextChain(BaseParser nextBaseParser) {

        this.nextBaseParser.setNextChain(nextBaseParser);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> lexemeList = TextHandler.handleText(data, LEXEME_REGEX);
        TextComposite lexemeTextComposite = new TextComposite(ComponentType.LEXEME);
        for (String lexeme : lexemeList) {
            TextComposite nextTextComposite = nextBaseParser.parse(lexeme);
            lexemeTextComposite.add(nextTextComposite);
        }
        return lexemeTextComposite;

    }
}
