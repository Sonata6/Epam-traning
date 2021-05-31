package by.kirill.text.parser;

import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;

public interface BaseParser {

    void setNextChain(BaseParser nextBaseParser);

    TextComposite parse(String data) throws TextHandlerException;

}
