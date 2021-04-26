package by.kirill.cube.action;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import by.kirill.cube.exception.CustomCubeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeCalculateActionTest {
    CubeCalculateAction action;
    CustomCube cube;

    @BeforeClass
    public void init() {
        action = new CubeCalculateAction();
        cube = new CustomCube(new CustomPoint(4, 4, 4), new CustomPoint(6,6,6));
    }

    @Test(expectedExceptions = CustomCubeException.class)
    public void errorTest() throws CustomCubeException {
        action.calculateVolume(null);
    }

    @Test
    public void calculateAreaEqualsTest() throws CustomCubeException {
        double actual = 24;
        double expected = action.calculateArea(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateVolumeEqualsTest() throws CustomCubeException {
        double actual = 8;
        double expected = action.calculateVolume(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaNotEqualsTest() throws CustomCubeException {
        double actual = 23;
        double expected = action.calculateArea(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateVolumeNotEqualsTest() throws CustomCubeException {
        double actual = 10;
        double expected = action.calculateVolume(cube);
        Assert.assertEquals(actual, expected);
    }


}
