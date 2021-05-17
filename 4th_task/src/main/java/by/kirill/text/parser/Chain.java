package by.kirill.text.parser;

import by.kirill.text.entity.Composite;
import by.kirill.text.entity.Impl.TextComposite;
import by.kirill.text.exeption.TextHandlerException;

public interface Chain {

    void setNextChain(Chain nextChain);

    TextComposite parse(String data) throws TextHandlerException;

}
