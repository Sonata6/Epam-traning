package by.kirill.cube.comparator;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparatorTest {

    private CustomPoint firstPoint = new CustomPoint(4, 4, 4);
    private CustomPoint secondPoint = new CustomPoint(6, 6, 6);
    private CustomCube firstCube = new CustomCube(secondPoint, firstPoint);
    private CustomCube secondCube = new CustomCube(firstPoint, secondPoint);
    private FieldXComparator xComparator = new FieldXComparator();
    private FieldYComparator yComparator = new FieldYComparator();
    private FieldZComparator zComparator = new FieldZComparator();
    private IdComparator idComparator = new IdComparator();

    @Test
    public void compareFirstPointByX() {
        int expected = firstCube.compareFirstPointByX(secondCube);
        Assert.assertEquals(1, expected);
    }

    @Test
    public void compareFirstPointByY() {
        int expected = firstCube.compareFirstPointByY(secondCube);
        Assert.assertEquals(1, expected);
    }

    @Test
    public void compareFirstPointByZ() {
        int expected = firstCube.compareFirstPointByZ(secondCube);
        Assert.assertEquals(1, expected);
    }

    @Test
    public void compareSecondPointByX() {
        int expected = firstCube.compareSecondPointByX(secondCube);
        Assert.assertEquals(-1, expected);
    }

    @Test
    public void compareSecondPointByY() {
        int expected = firstCube.compareSecondPointByY(secondCube);
        Assert.assertEquals(-1, expected);
    }

    @Test
    public void compareSecondPointByZ() {
        int expected = firstCube.compareSecondPointByZ(secondCube);
        Assert.assertEquals(-1, expected);
    }

    @Test
    public void compareId() {
        int expected = firstCube.compareById(secondCube);
        Assert.assertEquals(-1, expected);
    }

}
