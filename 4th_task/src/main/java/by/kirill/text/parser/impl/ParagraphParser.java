package by.kirill.text.parser.Impl;

import by.kirill.text.entity.Impl.CompositeType;
import by.kirill.text.entity.Impl.TextComposite;
import by.kirill.text.exeption.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class ParagraphParser implements Chain {
    private final String REGEX = "[^\\n\\t]+";
    private Chain currentChain;

    @Override
    public void setNextChain(Chain nextChain) {

        currentChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> paragraphList = TextHandler.handleText(data, REGEX);
        TextComposite paragraphTextComposite = new TextComposite(CompositeType.PARAGRAPH);
        for (String paragraph : paragraphList) {
            TextComposite nextTextComposite = currentChain.parse(paragraph);
            paragraphTextComposite.add(nextTextComposite);
        }
        return paragraphTextComposite;

    }
}