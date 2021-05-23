//package by.kirill.text.parser.impl;
//
//import by.kirill.text.entity.impl.CompositeType;
//import by.kirill.text.entity.impl.TextComposite;
//import by.kirill.text.exception.TextHandlerException;
//import by.kirill.text.parser.Chain;
//import by.kirill.text.parser.TextHandler;
//
//import java.util.List;
//
//public class TextParser implements Chain{
//
//    private final String TEXT_REGEX = "\\t[^\\t]*";
//    private Chain nextChain;
//
//    @Override
//    public void setNextChain(Chain nextChain) {
//
//        this.nextChain.setNextChain(nextChain);
//    }
//
//    @Override
//    public TextComposite parse(String data) throws TextHandlerException {
//        List<String> textList = TextHandler.handleText(data, TEXT_REGEX);
//        TextComposite sentenceTextComposite = new TextComposite(CompositeType.SENTENCE);
//        for (String sentence : textList) {
//            TextComposite nextTextComposite = nextChain.parse(sentence);
//            sentenceTextComposite.add(nextTextComposite);
//        }
//        return sentenceTextComposite;
//    }
//}
