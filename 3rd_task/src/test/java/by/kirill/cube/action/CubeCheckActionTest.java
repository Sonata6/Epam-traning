package by.kirill.cube.action;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import by.kirill.cube.exception.CustomCubeException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubeCheckActionTest {
    CubeCheckAction action;
    CustomCube cube;
    CustomCube notCube;

    @BeforeClass
    public void init() {
        action = new CubeCheckAction();
        cube = new CustomCube(new CustomPoint(0, 0, 3), new CustomPoint(6,6,9));
        notCube = new CustomCube(new CustomPoint(5, 5, 5), new CustomPoint(6,6,-7));
    }


    @Test
    public void isCubeTest() throws CustomCubeException {
        boolean expected = action.isCube(cube);
        Assert.assertEquals(true, expected);
    }

    @Test
    public void isNotCubeTest() throws CustomCubeException {
        boolean expected = action.isCube(notCube);
        Assert.assertEquals(false, expected);
    }

    @Test
    public void onAxisTest() throws CustomCubeException {
        boolean expected = action.onAxis(cube);
        Assert.assertEquals(true, expected);
    }

    @Test
    public void notOnAxisTest() throws CustomCubeException {
        boolean expected = action.onAxis(notCube);
        Assert.assertEquals(false, expected);
    }

}
