import by.kirill.array.entity.ArrayMinMax;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.service.ArrayMinMaxSearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayMinMaxSearchTest {

    @Test
    public void checkMinMaxValuseTestWithStream1() throws CustomArrayException {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CustomArray actual = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax countService = search.minMaxFindWithStream(actual);
        Assert.assertEquals(9, countService.getMax());
    }

    @Test
    public void checkMinMaxValuseTestWithStream2() throws CustomArrayException {
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax countService = search.minMaxFindWithStream(actual);
        Assert.assertEquals(-4, countService.getMin());
    }

    @Test
    public void checkMinMaxValuseTest1() throws CustomArrayException {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CustomArray actual = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax countService = search.minMaxFind(actual);
        Assert.assertEquals(9, countService.getMax());
    }

    @Test
    public void checkMinMaxValuseTest2() throws CustomArrayException {
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray actual = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax countService = search.minMaxFind(actual);
        Assert.assertEquals(-4, countService.getMin());
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void zeroArrayLenghtTest() throws CustomArrayException {
        int arr[] = {};
        CustomArray customArray = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        search.minMaxFind(customArray);
    }
}
