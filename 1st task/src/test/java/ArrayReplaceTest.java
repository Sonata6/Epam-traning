import by.kirill.array.entity.CustomArray;
import by.kirill.array.service.ArrayReplaceService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayReplaceTest {

    @Test
    public void checkAverageEqualsTest1() {
        int expected[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,0};
        int arr[] = {-9,-8,-7,-6,-5,-4,-3,-2,-1,0};
        CustomArray actual = new CustomArray(arr);
        ArrayReplaceService replace = new ArrayReplaceService();
        replace.replaceNumbers(actual);
        Assert.assertEquals(expected, actual.getArray());
    }

    @Test
    public void checkAverageNotEqualsTest(){
        int expected[] = {-1,-1,-1,-1, 0, 1, 2, 3, 4};
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(arr);
        ArrayReplaceService replace = new ArrayReplaceService();
        replace.replaceNumbers(actual);
        Assert.assertEquals(expected, actual.getArray());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroArrayLenghtTest(){
        int arr[] = {};
        CustomArray actual = new CustomArray(arr);
        ArrayReplaceService replace = new ArrayReplaceService();
        replace.replaceNumbers(actual);
    }

}
