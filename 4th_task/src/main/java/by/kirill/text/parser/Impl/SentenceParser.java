package by.kirill.text.parser.Impl;

import by.kirill.text.entity.Impl.CompositeType;
import by.kirill.text.entity.Impl.TextComposite;
import by.kirill.text.exeption.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class SentenceParser implements Chain {

    private final String REGEX = "/([А-ЯA-Z]((!=|ob.)|[^?!.(]|\\([^)]*\\))*[.?!]{1,3})/gm";
    private Chain currentChain;

    @Override
    public void setNextChain(Chain nextChain) {

        currentChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> sentenceList = TextHandler.handleText(data, REGEX);
        TextComposite sentenceTextComposite = new TextComposite(CompositeType.SENTENCE);
        for (String sentence : sentenceList) {
            TextComposite nextTextComposite = currentChain.parse(sentence);
            sentenceTextComposite.add(nextTextComposite);
        }
        return sentenceTextComposite;
    }
}
