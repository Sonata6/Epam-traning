package by.kirill.array.service;

import by.kirill.array.entity.ArrayPosNegCount;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.IntStream;


public class FindPosNegCountService {

    private static Logger logger = LogManager.getLogger();

    public ArrayPosNegCount calculatePositiveNegativeElementsWithStream(CustomArray customArray) throws CustomArrayException {
        logger.log(Level.DEBUG, "in calculatePositiveNegativeElementsWithStream method");
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        int[] elements = customArray.getArray();
        int positiveNumber = (int) IntStream.of(elements)
                .filter(element -> element > 0)
                .count();
        int negativeNumber = (int) IntStream.of(elements)
                .filter(e -> e < 0)
                .count();
        ArrayPosNegCount countOfNumbers = new ArrayPosNegCount(positiveNumber, negativeNumber);
        return countOfNumbers;

    }

    public ArrayPosNegCount calculatePositiveNegativeElements(CustomArray customArray) throws CustomArrayException {
        logger.log(Level.DEBUG, "in countOfPositiveNegativeElements method");
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        int positiveNumber = 0;
        int negativeNumber = 0;
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (customArray.getArray()[i] < 0) {
                negativeNumber++;
            } else if (customArray.getArray()[i] > 0) {
                positiveNumber++;
            }
        }
        ArrayPosNegCount countOfNumbers = new ArrayPosNegCount(positiveNumber, negativeNumber);
        logger.log(Level.INFO, String.format("\nCount of positive array numbers: %d\nCount of negative array numbers: %d",
                positiveNumber, negativeNumber));
        return countOfNumbers;
    }

}
