package test.kirill.array.validation;

import by.kirill.array.validation.CustomArrayValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomArrayValidatorTest {

    @DataProvider(name = "trueValidationTestData")
    public Object[][] trueValidationTestData() {
        return new Object[][]{
                {"2 4 8 -8 4 -4 54 51 16 32"},
                {"6 54 1 -4 -5 6 5 4"},
                {"13 423 -14 -64 54 61 5"},
                {"1, 5, 54, 8, 74, -4, 54, 51, 2, 3"},
                {"6 - 54 - 1 - 3 - 5 - 13 - 5 - 4"}
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
        Assert.assertTrue(CustomArrayValidator.validateString(validationString));
    }

    @Test(dataProvider = "falseValidationTestData")
    public void falseValidationTest(String validationString) {
        Assert.assertFalse(CustomArrayValidator.validateString(validationString));
    }
}
