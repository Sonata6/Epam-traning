package service;

import by.kirill.text.entity.AbstractComponent;
import by.kirill.text.entity.impl.ComponentType;
import by.kirill.text.entity.impl.TextComposite;
import by.kirill.text.exception.TextHandlerException;
import by.kirill.text.parser.impl.*;
import by.kirill.text.reader.TextReader;
import by.kirill.text.service.TextSearchService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TextSearchServiceTest {
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
    public void findSentencesWithLongestWord() throws TextHandlerException {
        TextSearchService searchService = new TextSearchService();
        List<Integer> actual = searchService.findSentencesWithLongestWord((TextComposite) rootComponent);
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[] {2}));
        Assert.assertEquals(actual.get(0), (Integer)8);
    }
}
