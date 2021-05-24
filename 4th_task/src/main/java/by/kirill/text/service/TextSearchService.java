package by.kirill.text.service;

import by.kirill.text.entity.AbstractComponent;
import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;

import java.util.ArrayList;
import java.util.List;

public class TextSearchService {

    public List<AbstractComponent> findAllSentences(AbstractComponent textComposite) {
        List<AbstractComponent> sentences = new ArrayList<>();
        for (AbstractComponent component: textComposite) {
            ComponentType componentType = component.getComponentType();
            if (componentType == ComponentType.SENTENCE) {
                sentences.add(component);
            }
        }
        return sentences;
    }

    public List<AbstractComponent> findAllWords(AbstractComponent textComposite) {
        List<AbstractComponent> words = new ArrayList<>();
        for (AbstractComponent component: textComposite) {
            ComponentType componentType = component.getComponentType();
            if (componentType == ComponentType.WORD) {
                words.add(component);
            }
        }
        return words;
    }

    public List<AbstractComponent> findAllCharacters(AbstractComponent textComposite) {
        List<AbstractComponent> letters = new ArrayList<>();
        for (AbstractComponent component: textComposite) {
            ComponentType componentType = component.getComponentType();
            if (componentType == ComponentType.CHARACTER) {
                letters.add(component);
            }
        }
        return letters;
    }

    public List<Integer> findSentencesWithLongestWord(AbstractComponent textComposite) throws TextHandlerException {
        List<Integer> sentenceNumber = new ArrayList<>();
        int currentSentence = 0;
        int maxWord = 0;
        TextCalculateService calculationService = new TextCalculateService();
        for (AbstractComponent component: textComposite) {
            ComponentType componentType = component.getComponentType();
            if (componentType == ComponentType.SENTENCE) {
                currentSentence++;
            }
            if (componentType == ComponentType.WORD) {
                int currentLength = calculationService.calculateWordLength((TextComposite) component);
                if (currentLength > maxWord) {
                    maxWord = currentLength;
                    sentenceNumber = new ArrayList<>();
                    sentenceNumber.add(currentSentence);
                } else if (currentLength == maxWord) {
                    sentenceNumber.add(currentSentence);
                }
            }
        }
        return sentenceNumber;
    }
}
