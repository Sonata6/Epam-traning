package test.kirill.array.parser;

import by.kirill.array.creator.CustomArrayCreator;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.parser.CustomArrayParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomArrayParserTest {

    @DataProvider(name = "stringParseTestData")
    public Object[][] stringParseTestData() {
        return new Object[][]{
                {"1 3 -1 -3 4 -4 54 51 21 33", new int[]{1, 3, -1, -3, 4, -4, 54, 51, 21, 33}},
                {"6 - -5 - 4 - -3 - 2 - -1 - 0 - 666", new int[]{6, -5, 4, -3, 2, -1, 0, 666}},
                {"32, 43, -1, -56, 228, 11, 13", new int[]{32, 43, -1, -56, 228, 11, 13}}
        };
    }

    @Test(dataProvider = "stringParseTestData")
    public void stringParserTest(String actualString, int[] expected) throws CustomArrayException {
        CustomArrayParser parser = new CustomArrayParser();
        int actual[] = parser.stringParser(actualString);
        Assert.assertEquals(actual, expected);
    }
}
