package by.kirill.text.service;

import by.kirill.text.entity.AbstractComponent;
import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;
import java.util.regex.Pattern;

public class TextCalculateService {

    private static final String CONSONANT = "[a-zA-Z&&[^aeiouAEIOU]]";
    private static final String VOWEL = "[aeiouAEIOU]";

    public int calculateSentencesInParagraph(TextComposite paragraph) throws TextHandlerException {
        ComponentType componentType = paragraph.getComponentType();
        if (componentType == ComponentType.PARAGRAPH) {
            int sentenceCount = paragraph.getNumberOfComponents();
            return sentenceCount;
        } else {
            throw new TextHandlerException("Composite type != PARAGRAPH: " + componentType);
        }
    }

    public int calculateWordLength(TextComposite word) throws TextHandlerException {
        ComponentType componentType = word.getComponentType();
        if (componentType == ComponentType.WORD) {
            int wordLength = word.getNumberOfComponents();
            return wordLength;
        } else {
            throw new TextHandlerException("Composite type != WORD: " + componentType);
        }
    }

    public int calculateAllIdenticalWords(AbstractComponent textComposite, String wordToSearch) {
        TextSearchService searchService = new TextSearchService();
        List<AbstractComponent> words = searchService.findAllWords(textComposite);
        int wordsCount = 0;
        for (AbstractComponent word : words) {
            String word1 = word.toString().toLowerCase();
            String word2 = wordToSearch.toLowerCase();
            if (word1.equals(word2)) {
                wordsCount++;
            }
        }
        return wordsCount;
    }

    public int calculateVowelCount(AbstractComponent component) throws ExecutionControl.NotImplementedException {
        TextSearchService searchService = new TextSearchService();
        List<AbstractComponent> characters = searchService.findAllCharacters(component);
        int vowelCount = 0;
        for (AbstractComponent characterComponent : characters) {
            String stringToSearch = Character.toString(characterComponent.getCharacter());
            if (Pattern.matches(VOWEL, stringToSearch)) {
                vowelCount++;
            }
        }
        return vowelCount;
    }
}
