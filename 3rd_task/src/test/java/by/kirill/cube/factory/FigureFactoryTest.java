package by.kirill.cube.factory;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import by.kirill.cube.entity.FigureParameter;
import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.parser.CustomCubeParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FigureFactoryTest {

    @Test
    public void factoryRegularPolygonTest() throws CustomCubeException {
        CustomCube expected = new CustomCube(new CustomPoint(0, 0, 0), new CustomPoint(4, 4, 4));
        expected.setId(0);
        CustomCubeParser parser = new CustomCubeParser();

        List<Integer> parameterArray = parser.stringParser("0 0 0 4 4 4");
        FigureParameter figureParameter = new FigureParameter();
        FigureFactory factory = new FigureFactory();
        CustomCube actual = factory.getCubeFromFactory(parameterArray);
        Assert.assertEquals(expected.equals(actual), true);
    }


}
