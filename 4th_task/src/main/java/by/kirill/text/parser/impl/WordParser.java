package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.BaseParser;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class WordParser implements BaseParser {

    private final String WORD_REGEX = "^[A-Za-z]+$";
    private BaseParser nextBaseParser;

    @Override
    public void setNextChain(BaseParser nextBaseParser) {

        this.nextBaseParser.setNextChain(nextBaseParser);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> wordList = TextHandler.handleText(data, WORD_REGEX);
        TextComposite wordTextComposite = new TextComposite(ComponentType.WORD);
        for (String word : wordList) {
            TextComposite nextTextComposite = nextBaseParser.parse(word);
            wordTextComposite.add(nextTextComposite);
        }
        return wordTextComposite;
    }
}
