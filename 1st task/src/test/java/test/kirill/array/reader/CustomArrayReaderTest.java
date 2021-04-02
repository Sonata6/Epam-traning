package test.kirill.array.reader;

import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.reader.CustomArrayReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Path;

public class CustomArrayReaderTest {


    @Test
    public void customArrayReaderTest() throws CustomArrayException {
        String expectedString = "14 7 113 25 -63";
        CustomArrayReader reader = new CustomArrayReader();
        Path path = reader.createFilePath("/data/data.txt");
        String actualString = reader.readFromFile(path);
        Assert.assertEquals(actualString, expectedString);
    }

}
