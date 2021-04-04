package by.kirill.array.service;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class ArraySumService {

    private static Logger logger = LogManager.getLogger();

    public long findSumWitnStream(CustomArray customArray) throws CustomArrayException {
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        logger.log(Level.DEBUG, "in findSumWithStream method");
        int[] array = customArray.getArray();
        long sum = IntStream.of(array).sum();
        logger.log(Level.INFO, String.format("sum of array elements: %d", sum));
        return sum;
    }

    public long findSum(CustomArray customArray) throws CustomArrayException {
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        logger.log(Level.DEBUG, "in findSum method");
        if (customArray.getArray().length == 0) {
            throw new IllegalArgumentException();
        }
        long sum = 0;
        for (int i = 0; i < customArray.getArray().length; i++) {
            sum += customArray.getArray()[i];
        }
        logger.log(Level.INFO, String.format("sum of array elements: %d", sum));
        return sum;
    }

}
