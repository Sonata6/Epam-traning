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
        CustomArrayValidator.validateNotNullOrEmpty(customArray);
        logger.log(Level.DEBUG, "in findSumWithStream method");
        int[] array = customArray.getArray();
        long sum = IntStream.of(array).sum();
        logger.log(Level.INFO, String.format("sum of array elements: %d", sum));
        return sum;
    }

    public long findSum(CustomArray customarray) throws CustomArrayException {
        CustomArrayValidator.validateNotNullOrEmpty(customarray);
        logger.log(Level.DEBUG, "in findSum method");
        if (customarray.getArray().length == 0) {
            throw new IllegalArgumentException();
        }
        long sum = 0;
        for (int i = 0; i < customarray.getArray().length; i++) {
            sum += customarray.getArray()[i];
        }
        logger.log(Level.INFO, String.format("sum of array elements: %d", sum));
        return sum;
    }

}
