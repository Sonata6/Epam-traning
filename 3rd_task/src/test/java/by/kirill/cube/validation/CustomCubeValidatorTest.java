package by.kirill.cube.validation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomCubeValidatorTest {

    @DataProvider(name = "trueValidationTestData")
    public Object[][] trueValidationTestData() {
        return new Object[][]{
                {"1 2 3 4 5 6"},
                {"0, 0, 0, 3, 3, 3"},
                {"25, 25, 25, 14 15 14"},
                {"1 1 1, 2 2 2"},
                {"6, 6, 6, 6, 6, 6"}
        };
    }

    @DataProvider(name = "falseValidationTestData")
    public Object[][] falseValidationTestData() {
        return new Object[][]{
                {"2 d4 8 -8 4 -4 54 51k 16 32"},
                {""},
                {"13 423    -14 -64 54 61 5"},
                {"1, 5, 54,, 8, 74, -4, 54, 51, 2, 3"},
                {"6 - 54 - 1 - 3 -- 5 - 13 - 5 - 4"}
        };
    }

    @Test(dataProvider = "trueValidationTestData")
    public void trueValidationTest(String validationString) {
        Assert.assertTrue(FileValidator.validateString(validationString));
    }

    @Test(dataProvider = "falseValidationTestData")
    public void falseValidationTest(String validationString) {
        Assert.assertFalse(FileValidator.validateString(validationString));
    }

}
