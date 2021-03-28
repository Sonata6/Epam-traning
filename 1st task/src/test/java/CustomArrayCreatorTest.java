import by.kirill.array.creator.CustomArrayCreator;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomArrayCreatorTest {
    @Test
    public void createArrayTest() throws CustomArrayException {
        int expectedArray[] = {14, 7, 113, 25, -63};
        CustomArrayCreator create = new CustomArrayCreator();
        CustomArray customArray = create.customArrayCreator();
        int actualArray[] = customArray.getArray();
        Assert.assertEquals(expectedArray, actualArray);
    }
}
