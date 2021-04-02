package test.kirill.array.service;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.service.FindArrayAverageService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayAverageTest {

    public static FindArrayAverageService dataCount = new FindArrayAverageService();

    @Test
    public void checkAverageEqualsTestWithStream1() throws CustomArrayException {
        int initialArray[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CustomArray actual = new CustomArray(initialArray);
        float average = dataCount.findAverageWithStream(actual);
        Assert.assertEquals(4.5, average);
    }

    @Test
    public void checkAverageNotEqualsTestWithStream() throws CustomArrayException {
        int initialArray[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(initialArray);
        float average = dataCount.findAverageWithStream(actual);
        Assert.assertNotEquals(1, average);
    }

    @Test
    public void checkAverageEqualsTest1() throws CustomArrayException {
        int initialArray[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CustomArray actual = new CustomArray(initialArray);
        float average = dataCount.findAverage(actual);
        Assert.assertEquals(4.5, average);
    }

    @Test
    public void checkAverageNotEqualsTest() throws CustomArrayException {
        int initialArray[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(initialArray);
        float average = dataCount.findAverage(actual);
        Assert.assertNotEquals(1, average);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void zeroArrayLenghtTest() throws CustomArrayException {
        int initialArray[] = {};
        CustomArray actual = new CustomArray(initialArray);
        dataCount.findAverage(actual);
    }

}
