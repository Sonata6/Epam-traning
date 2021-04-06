package by.kirill.array.service;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ArrayReplaceService {

    private static Logger logger = LogManager.getLogger();

    public void replaceNumbersWithStream(CustomArray customArray, IntPredicate predicate) throws CustomArrayException {
        logger.log(Level.DEBUG, "in replaceNumbers method");
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        int currentArray[] = customArray.getArray();
        currentArray = IntStream.of(currentArray)
                .map(element -> predicate.test(element) ? -1 : element)
                .toArray();
        customArray.setArray(currentArray);
        logger.log(Level.INFO, "replaceNumbers method finished successfully");
    }

    public void replaceNumbers(CustomArray customArray) throws CustomArrayException {
        logger.log(Level.DEBUG, "in replaceNumbers method");
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        if (customArray.getArray().length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (customArray.getArray()[i] < 0) {
                customArray.setElement(i, -1);
            }
        }
        logger.log(Level.INFO, "replaceNumbers method finished successfully");
    }
}
