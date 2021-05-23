package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class ParagraphParser implements Chain {
    private final String PARAGRAPH_REGEX = "\\t[^\\t]*";
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> paragraphList = TextHandler.handleText(data, PARAGRAPH_REGEX);
        TextComposite paragraphTextComposite = new TextComposite(ComponentType.PARAGRAPH);
        for (String paragraph : paragraphList) {
            TextComposite nextTextComposite = nextChain.parse(paragraph);
            paragraphTextComposite.add(nextTextComposite);
        }
        return paragraphTextComposite;

    }
}