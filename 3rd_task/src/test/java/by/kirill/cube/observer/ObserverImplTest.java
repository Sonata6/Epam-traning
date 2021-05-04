package by.kirill.cube.observer;

import by.kirill.cube.action.CubeCalculateAction;
import by.kirill.cube.creator.CustomCubeCreator;
import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import by.kirill.cube.entity.FigureParameter;
import by.kirill.cube.entity.Warehouse;
import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.factory.FigureFactory;
import by.kirill.cube.observer.impl.ObserverImpl;
import by.kirill.cube.parser.CustomCubeParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ObserverImplTest {
    @Test
    public void figureEventTest() throws CustomCubeException {
        CustomCubeParser parser = new CustomCubeParser();
        List<Integer> figureParameter = parser.stringParser("4 4 4 6 6 6");
        FigureFactory factory = new FigureFactory();
        CustomCube cube = factory.getCubeFromFactory(figureParameter);
        cube.attach(new ObserverImpl());
        Warehouse warehouse = Warehouse.getInstance();
        long id = cube.getId();
        CubeCalculateAction calculation = new CubeCalculateAction();
        double surfaceArea = calculation.calculateArea(cube);
        double volume = calculation.calculateVolume(cube);
        FigureParameter parameter = new FigureParameter();
        parameter.setSurfaceArea(surfaceArea);
        parameter.setVolume(volume);
        warehouse.put(id, parameter);
        CustomPoint point = new CustomPoint(5, 5, 5);
        cube.setFirstPoint(point);
        double expected = calculation.calculateArea(cube);
        FigureParameter pyramidParameter = warehouse.get(id);
        double actual = pyramidParameter.getSurfaceArea();
        Assert.assertEquals(expected, actual, 0.0000000001);
    }
}
