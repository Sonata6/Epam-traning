package by.kirill.cube.reader;

import by.kirill.cube.exception.CustomCubeException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.util.List;

public class CustomCubeReaderTest {

    @Test
    public void customArrayReaderTest() throws CustomCubeException {
        String expectedString = "14 7 113 25 -63";
        CustomCubeReader reader = new CustomCubeReader();
        Path path = reader.createFilePath("/data/data.txt");
        List<String> actualString = reader.readFromFile(path);
        Assert.assertEquals(actualString, expectedString);
    }
}
