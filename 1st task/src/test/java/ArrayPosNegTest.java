import by.kirill.array.entity.ArrayPosNegCount;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.service.FindPosNegCountService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayPosNegTest {

    @Test
    public void checkAverageEqualsTest1() {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray customarray = new CustomArray(arr);
        ArrayPosNegCount posnegcount =  find.countOfPositiveNegativeElements(customarray);
        Assert.assertEquals(9, posnegcount.getPositive());
    }

    @Test
    public void checkAverageNotEqualsTest(){
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray customarray = new CustomArray(arr);
        ArrayPosNegCount posnegcount =  find.countOfPositiveNegativeElements(customarray);
        Assert.assertEquals(4, posnegcount.getNegative());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroArrayLenghtTest(){
        int arr[] = {};
        FindPosNegCountService find = new FindPosNegCountService();
        CustomArray actual = new CustomArray(arr);
        find.countOfPositiveNegativeElements(actual);
    }

}
