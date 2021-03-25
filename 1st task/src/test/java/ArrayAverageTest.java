import by.kirill.array.entity.CustomArray;
import by.kirill.array.service.FindArrayAverageService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayAverageTest {

    private static Logger logger = LogManager.getLogger();

    @Test
    public void checkAverageEqualsTest1() {

        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        FindArrayAverageService datacount = new FindArrayAverageService();
        CustomArray a = new CustomArray(arr);
        float average = datacount.findAverage(a);
        Assert.assertEquals(4.5, average);

    }

    @Test
    public void checkAverageNotEqualsTest(){
        int arr[] = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        FindArrayAverageService datacount = new FindArrayAverageService();
        CustomArray a = new CustomArray(arr);
        float average = datacount.findAverage(a);
        Assert.assertNotEquals(1, average);

    }

}
