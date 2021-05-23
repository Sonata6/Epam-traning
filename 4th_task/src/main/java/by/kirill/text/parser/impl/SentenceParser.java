package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class SentenceParser implements Chain {

    private final String SENTENCE_REGEX = "[\\w\\s-(),|~&<^';>]+\\s?[\\.\\?\\!\\u2026]+"; //"[\\w\\s-(),|~&<^';>]+\\.\\n?";
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {

        this.nextChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> sentenceList = TextHandler.handleText(data, SENTENCE_REGEX);
        TextComposite sentenceTextComposite = new TextComposite(ComponentType.SENTENCE);
        for (String sentence : sentenceList) {
            TextComposite nextTextComposite = nextChain.parse(sentence);
            sentenceTextComposite.add(nextTextComposite);
        }
        return sentenceTextComposite;
    }
}
