package test.kirill.array.creator;

import by.kirill.array.creator.CustomArrayCreator;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomArrayCreatorTest {

    @DataProvider(name = "customArrayCreatorTestData")
    public Object[][] customArrayCreatorTestData() {
        return new Object[][]{
                {new int[]{3, 4, -8, 14}},
                {new int[]{-5, 0, 42, 15}},
                {new int[]{23, -16, 6, 11}},
                {new int[]{228, -555, 43, 555}},
                {new int[]{53, 44, 17, 5}},
                {new int[]{1, 3, -4, 5}},
                {new int[]{2, 48, 18, -6}},
                {new int[]{3, 4, 15, 56}},
                {new int[]{4, -2, 10, 75}},
                {new int[]{15, 3, -50, 25}}
        };
    }

    @Test(dataProvider = "customArrayCreatorTestData")
    public void createArrayTest(int... params) throws CustomArrayException {
        CustomArrayCreator creator = new CustomArrayCreator();
        CustomArray array = creator.customArrayCreator(params);
        Assert.assertNotNull(array);
    }
}
