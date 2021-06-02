package by.kirill.text.service;

import by.kirill.text.comparator.ParagraphComparator;
import by.kirill.text.entity.AbstractComponent;
import by.kirill.text.entity.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextEditService {

    public void deleteSentencesWhereWordCountLessThenCurrent(TextComposite textComposite, int wordCount) {
        TextSearchService textSearchServiceImpl = new TextSearchService();
        List<AbstractComponent> sentences = textSearchServiceImpl.findAllSentences(textComposite);

        for (AbstractComponent sentence : sentences) {
            List<AbstractComponent> words = textSearchServiceImpl.findAllWords(sentence);
            if (words.size() < wordCount) {
                sentence.remove(sentence);
            }
        }
    }

    public void sortParagraphsBySentences(TextComposite textComposite) {
        List<AbstractComponent> paragraphs = new ArrayList<>();
        for (int i = 0; i < textComposite.getNumberOfComponents(); i++) {
            paragraphs.add(textComposite.getChild(i));
        }
        paragraphs.sort(new ParagraphComparator());
        textComposite.setComponents(paragraphs);
    }
}
