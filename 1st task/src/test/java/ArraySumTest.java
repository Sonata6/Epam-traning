import by.kirill.array.entity.CustomArray;
import by.kirill.array.service.ArraySumService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySumTest {



    @Test
    public void checkAverageEqualsTest1() {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        CustomArray myarray = new CustomArray(arr);
        ArraySumService a = new ArraySumService();
        long arrsum = a.findSum(myarray);
        Assert.assertEquals(arrsum, 45);
    }

    @Test
    public void checkAverageEqualsTest2(){
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray myarray = new CustomArray(arr);
        ArraySumService a = new ArraySumService();
        long arrsum = a.findSum(myarray);
        Assert.assertEquals(arrsum, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroArrayLenghtTest(){
        int arr[] = {};
        CustomArray myarray = new CustomArray(arr);
        ArraySumService a = new ArraySumService();
        a.findSum(myarray);
    }

}
