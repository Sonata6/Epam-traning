package test.kirill.array.service;

import by.kirill.array.entity.ArrayPosNegCount;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.service.FindPosNegCountService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayPosNegTest {

    @Test
    public void checkPositiveNegativeTestWithStream1() throws CustomArrayException {
        int initialArray[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray customArray = new CustomArray(initialArray);
        ArrayPosNegCount positiveNegativecount = find.calculatePositiveNegativeElementsWithStream(customArray);
        Assert.assertEquals(9, positiveNegativecount.getPositive());
    }

    @Test
    public void checkPositiveNegativeTestWithStream2() throws CustomArrayException {
        int initialArray[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray customArray = new CustomArray(initialArray);
        ArrayPosNegCount positiveNegativecount = find.calculatePositiveNegativeElementsWithStream(customArray);
        Assert.assertEquals(4, positiveNegativecount.getNegative());
    }

    @Test
    public void checkPositiveNegativeTest1() throws CustomArrayException {
        int initialArray[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray customArray = new CustomArray(initialArray);
        ArrayPosNegCount positiveNegativecount = find.calculatePositiveNegativeElements(customArray);
        Assert.assertEquals(9, positiveNegativecount.getPositive());
    }

    @Test
    public void checkPositiveNegativeTest2() throws CustomArrayException {
        int initialArray[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray customArray = new CustomArray(initialArray);
        ArrayPosNegCount positiveNegativecount = find.calculatePositiveNegativeElements(customArray);
        Assert.assertEquals(4, positiveNegativecount.getNegative());
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void zeroArrayLenghtTest() throws CustomArrayException {
        int initialArray[] = {};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray actual = new CustomArray(initialArray);
        find.calculatePositiveNegativeElements(actual);
    }

}
