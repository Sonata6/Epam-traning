import by.kirill.array.entity.ArrayMinMax;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.service.ArrayMinMaxSearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayMinMaxSearchTest {

    @Test
    public void checkAverageEqualsTest1() {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CustomArray actual = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax countservice = search.minMaxFind(actual);
        Assert.assertEquals(9, countservice.getMax());
    }

    @Test
    public void checkAverageNotEqualsTest() {
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax countservice = search.minMaxFind(actual);
        Assert.assertEquals(-4, countservice.getMin());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void zeroArrayLenghtTest() {
        int arr[] = {};
        CustomArray customarray = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        search.minMaxFind(customarray);
    }
}
