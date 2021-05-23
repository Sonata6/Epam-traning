package by.kirill.text.parser;

import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;

public interface Chain {

    void setNextChain(Chain nextChain);

    TextComposite parse(String data) throws TextHandlerException;

}
