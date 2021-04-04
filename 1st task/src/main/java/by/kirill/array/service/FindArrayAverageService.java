package by.kirill.array.service;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindArrayAverageService {

    private static Logger logger = LogManager.getLogger();


    public static float findAverageWithStream(CustomArray customArray) throws CustomArrayException { //TODO
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        logger.log(Level.DEBUG, "in findAverageWithStream method");
        ArraySumService sumService = new ArraySumService();
        long sum = sumService.findSumWitnStream(customArray);
        float average;
        average = (float) sum / customArray.getArray().length;
        logger.log(Level.INFO, String.format("average array number: %f", average));
        return average;
    }

    public float findAverage(CustomArray customArray) throws CustomArrayException {
        logger.log(Level.DEBUG, "in findAverage method");
        if (CustomArrayValidator.validateNotNullOrEmpty(customArray)) {
            throw new CustomArrayException("Array is null or empty");
        }
        ArraySumService sumService = new ArraySumService();
        long sum = sumService.findSum(customArray);
        float average;
        average = (float) sum / customArray.getArray().length;
        logger.log(Level.INFO, String.format("average array number: %f", average));
        return average;
    }

}
