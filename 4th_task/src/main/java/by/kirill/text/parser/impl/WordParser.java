package by.kirill.text.parser.impl;

import by.kirill.text.entity.impl.CompositeType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.Chain;
import by.kirill.text.parser.TextHandler;

import java.util.List;

public class WordParser implements Chain{

        private final String WORD_REGEX = "^[A-Za-z]+$";
        private Chain nextChain;

        @Override
        public void setNextChain(Chain nextChain) {

            this.nextChain.setNextChain(nextChain);
        }

        @Override
        public TextComposite parse(String data) throws TextHandlerException {
            List<String> wordList = TextHandler.handleText(data, WORD_REGEX);
            TextComposite wordTextComposite = new TextComposite(CompositeType.WORD);
            for (String word : wordList) {
                TextComposite nextTextComposite = nextChain.parse(word);
                wordTextComposite.add(nextTextComposite);
            }
            return wordTextComposite;
        }
}
