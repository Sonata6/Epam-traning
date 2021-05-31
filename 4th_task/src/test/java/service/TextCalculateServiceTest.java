package service;

import by.kirill.text.entity.AbstractComponent;
import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.impl.*;
import by.kirill.text.reader.TextReader;
import by.kirill.text.service.TextCalculateService;
import jdk.jshell.spi.ExecutionControl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class TextCalculateServiceTest {
    private AbstractComponent rootComponent;

    @BeforeClass
    public void parseData() throws URISyntaxException, TextHandlerException {
        CharacterParser characterParser = new CharacterParser();
        WordParser wordParser = new WordParser();
        LexemeParser lexemeParser = new LexemeParser();
        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setNextChain(sentenceParser);
        sentenceParser.setNextChain(lexemeParser);
        lexemeParser.setNextChain(wordParser);
        wordParser.setNextChain(characterParser);

        URI uri = getClass().getResource("/data/data.txt").toURI();
        String absolutePath = new File(uri).getAbsolutePath();
        TextReader reader = new TextReader();
        String data = reader.readTextFromFile(absolutePath);
        rootComponent = new TextComposite(ComponentType.PARAGRAPH);
        paragraphParser.parse(data);
    }

    @Test
    public void calculateSentenceCount() throws TextHandlerException {
        TextComposite paragraph0 = (TextComposite) rootComponent.getChild(0);
        TextComposite paragraph1 = (TextComposite) rootComponent.getChild(1);
        TextComposite paragraph2 = (TextComposite) rootComponent.getChild(2);
        TextComposite paragraph3 = (TextComposite) rootComponent.getChild(3);
        TextCalculateService calculationService = new TextCalculateService();
        boolean actual = calculationService.calculateSentencesInParagraph(paragraph0) == 2
                && calculationService.calculateSentencesInParagraph(paragraph1) == 2
                && calculationService.calculateSentencesInParagraph(paragraph2) == 1
                && calculationService.calculateSentencesInParagraph(paragraph3) == 1;
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateAllIdenticalWords() {
        TextCalculateService calculationService = new TextCalculateService();
        int actual = calculationService.calculateAllIdenticalWords((TextComposite) rootComponent, "It");
        int expected = 6;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateVowels() throws TextHandlerException, ExecutionControl.NotImplementedException {
        TextCalculateService calculationService = new TextCalculateService();
        int actual = calculationService.calculateVowelCount(rootComponent);
        int expected = 227;
        Assert.assertEquals(actual, expected);
    }

}
