package by.kirill.text.parser.Impl;

import by.kirill.text.entity.Impl.CompositeType;
import by.kirill.text.entity.Impl.TextComposite;
import by.kirill.text.exeption.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class WordParser implements Chain{

    private final String REGEX = "[\\\"\\wА-я']+(-[\\\"\\wА-я']+)*";
    private Chain currentChain;

    @Override
    public void setNextChain(Chain nextChain) {

        currentChain.setNextChain(nextChain);
    }

    @Override
    public TextComposite parse(String data) throws TextHandlerException {
        List<String> wordList = TextHandler.handleText(data, REGEX);
        TextComposite wordTextComposite = new TextComposite(CompositeType.WORD);
        for (String word : wordList) {
            TextComposite nextTextComposite = currentChain.parse(word);
            wordTextComposite.add(nextTextComposite);
        }
        return wordTextComposite;
    }
}
