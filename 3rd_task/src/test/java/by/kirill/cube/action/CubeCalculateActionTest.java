package by.kirill.cube.action;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeCalculateActionTest {
    CubeCalculateAction action;
    CustomCube cube;

    @BeforeClass
    public void init() {
        action = new CubeCalculateAction();
        cube = new CustomCube(new CustomPoint(4, 4, 4), new CustomPoint(6, 6, 6));
    }

    @Test
    public void calculateAreaEqualsTest() {
        double expected = 24;
        double actual = action.calculateArea(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateVolumeEqualsTest() {
        double expected = 8;
        double actual = action.calculateVolume(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaNotEqualsTest() {
        double expected = 23;
        double actual = action.calculateArea(cube);
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void calculateVolumeNotEqualsTest() {
        double expected = 10;
        double actual = action.calculateVolume(cube);
        Assert.assertNotEquals(actual, expected);
    }

}
