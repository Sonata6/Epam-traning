package by.kirill.cube.reader;

import by.kirill.cube.exception.CustomCubeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CustomCubeReaderTest {


        String filepath;
        CustomCubeReader reader;
        ClassLoader loader;

        @BeforeClass
        public void init() {
            reader = new CustomCubeReader();
            loader = CustomCubeReaderTest.class.getClassLoader();
        }

        @Test(expectedExceptions = CustomCubeException.class)
        public void testException() throws CustomCubeException {
            reader.readFromFile("wrong_path");
        }

        @Test
        public void testFullyRightFile() throws CustomCubeException {
            ArrayList<String> actual = new ArrayList<>();
            actual.add("1 1 1, 3 3 3");
            actual.add("2 2 2, 4 4 4");
            List<String> expected = reader.readFromFile("/data/data.txt");
            Assert.assertEquals(  actual, expected);
        }

        @Test(expectedExceptions = CustomCubeException.class)
        public void testPartlyWrongFile() throws CustomCubeException {
            ArrayList<String> actual = new ArrayList<>();
            actual.add("1 1 1, 3 3 3");
            actual.add("2 2 2, 4 4 4");
            List<String> expected = reader.readFromFile("/data/data1.txt");
            Assert.assertEquals(  actual, expected);
        }

}
