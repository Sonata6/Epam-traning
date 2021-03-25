
import by.kirill.array.entity.ArrayMinMax;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.service.ArrayMinMaxSearchService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayMinMaxSearchTest {

    @Test
    public void checkAverageEqualsTest1() {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        CustomArray myarray = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax a = search.minMaxFind(myarray);
        Assert.assertEquals(0, a.getMin());
        Assert.assertEquals(9, a.getMax());
    }

    @Test
    public void checkAverageNotEqualsTest(){
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        CustomArray myarray = new CustomArray(arr);
        ArrayMinMaxSearchService search = new ArrayMinMaxSearchService();
        ArrayMinMax a = search.minMaxFind(myarray);
        Assert.assertEquals(-4, a.getMin());
        Assert.assertEquals(4, a.getMax());
    }

}
