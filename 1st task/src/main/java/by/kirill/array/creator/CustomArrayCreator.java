package by.kirill.array.creator;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomArrayCreator {

    private static Logger logger = LogManager.getLogger();


    public CustomArray customArrayCreator(int[] currentArray) throws CustomArrayException {
        CustomArray customArray = new CustomArray(currentArray);
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        return customArray;
    }
}