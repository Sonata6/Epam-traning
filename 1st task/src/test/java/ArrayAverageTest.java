import by.kirill.array.entity.CustomArray;
import by.kirill.array.service.FindArrayAverageService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayAverageTest {


    @Test
    public void checkAverageEqualsTest1() {

        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        FindArrayAverageService datacount = new FindArrayAverageService();
        CustomArray actual = new CustomArray(arr);
        float average = datacount.findAverage(actual);
        Assert.assertEquals(4.5, average);

    }

    @Test
    public void checkAverageNotEqualsTest(){
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        FindArrayAverageService datacount = new FindArrayAverageService();
        CustomArray actual = new CustomArray(arr);
        float average = datacount.findAverage(actual);
        Assert.assertNotEquals(1, average);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroArrayLenghtTest(){
        int arr[] = {};
        FindArrayAverageService datacount = new FindArrayAverageService();
        CustomArray actual = new CustomArray(arr);
        datacount.findAverage(actual);
    }

}
