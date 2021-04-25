package by.kirill.cube.parser;

import by.kirill.cube.exception.CustomCubeException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomCubeParserTest {
    CustomCubeParser parser = new CustomCubeParser();

    @Test
    public void testParser() throws CustomCubeException {
        List<Integer> actual = Arrays.asList(new Integer[] {3,5,7,2,2,4});
        List<Integer> expected = parser.stringParser("3 5 7 2 2 4");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParserWithZero() throws CustomCubeException {
        List<Integer> actual = Arrays.asList(new Integer[] {0, 0, 0, 1, 1, 1});
        List<Integer> expected = parser.stringParser("0, 0, 0, 1, 1, 1");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomCubeException.class)
    public void testValidationParser() throws CustomCubeException {
        parser.stringParser("s");
    }
}
