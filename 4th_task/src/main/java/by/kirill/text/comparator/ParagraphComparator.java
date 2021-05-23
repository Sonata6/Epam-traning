package by.kirill.text.comparator;

import by.kirill.text.entity.AbstractComponent;
import by.kirill.text.service.TextSearchService;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<AbstractComponent> {
    @Override
    public int compare(AbstractComponent paragraph1, AbstractComponent paragraph2) {
        TextSearchService textSearchServiceImpl = new TextSearchService();
        int numberOfsentences1 = textSearchServiceImpl.findAllSentences(paragraph1).size();
        int numberOfsentences2 = textSearchServiceImpl.findAllSentences(paragraph2).size();
        return numberOfsentences1 - numberOfsentences2;
    }
}
