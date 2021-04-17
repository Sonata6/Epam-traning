package by.kirill.cube.reader;

import by.kirill.cube.exception.CustomCubeException;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.util.List;

public class CustomCubeReaderTest {

    @Test
    public void customArrayReaderTest() throws CustomCubeException {
        String expectedString = "1 1 1, 1 1 2, 2 1 2, 2 1 1, 1 2 1, 1 2 2, 2 2 2, 2 2 1";
        CustomCubeReader reader = new CustomCubeReader();
//        Path path = reader.createFilePath("/data/data.txt");
        List<String> actualString = reader.readFromFile("/data/data.txt");
        Assert.assertEquals(actualString.get(0), expectedString);
    }
}
