import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.service.ArraySumService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySumTest {

    @Test
    public void checkArraySumTestWithStream1() throws CustomArrayException {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        CustomArray actual = new CustomArray(arr);
        ArraySumService arraySumService = new ArraySumService();
        long arrsum = arraySumService.findSumWitnStream(actual);
        Assert.assertEquals(arrsum, 45);
    }

    @Test
    public void checkArraySumTestWithStream2() throws CustomArrayException {
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(arr);
        ArraySumService arraySumService = new ArraySumService();
        long arrsum = arraySumService.findSumWitnStream(actual);
        Assert.assertEquals(arrsum, 0);
    }

    @Test
    public void checkArraySumTest1() throws CustomArrayException {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        CustomArray actual = new CustomArray(arr);
        ArraySumService arraySumService = new ArraySumService();
        long arrsum = arraySumService.findSum(actual);
        Assert.assertEquals(arrsum, 45);
    }

    @Test
    public void checkArraySumTest2() throws CustomArrayException {
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(arr);
        ArraySumService arraySumService = new ArraySumService();
        long arrsum = arraySumService.findSum(actual);
        Assert.assertEquals(arrsum, 0);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void zeroArrayLenghtTest() throws CustomArrayException {
        int arr[] = {};
        CustomArray actual = new CustomArray(arr);
        ArraySumService arraySumService = new ArraySumService();
        arraySumService.findSum(actual);
    }

}
