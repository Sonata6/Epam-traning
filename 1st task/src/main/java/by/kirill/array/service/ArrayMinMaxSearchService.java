package by.kirill.array.service;

import by.kirill.array.entity.ArrayMinMax;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

import java.util.Arrays;


public class ArrayMinMaxSearchService {

    private static Logger logger = LogManager.getLogger();

    public ArrayMinMax minMaxFindWithStream(CustomArray customArray) {
        int currentArray[] = customArray.getArray();
        int min = Arrays.stream(currentArray).min().getAsInt();
        int max = Arrays.stream(currentArray).max().getAsInt();
        logger.log(Level.INFO, String.format("\nMin value of array: %d\nMax value of array: %d", min, max));
        ArrayMinMax minmaxcount = new ArrayMinMax(min, max);
        return minmaxcount;
    }

    public ArrayMinMax minMaxFind(CustomArray customArray) throws CustomArrayException {
        logger.log(Level.DEBUG, "in minMaxFind method");
        CustomArrayValidator.validateNotNullOrEmpty(customArray);
        int min = customArray.getArray()[0];
        int max = customArray.getArray()[0];
        for (int i = 0; i < customArray.getArray().length; i++) {
            if (customArray.getArray()[i] > max) {
                max = customArray.getArray()[i];
            }
            if (customArray.getArray()[i] < min) {
                min = customArray.getArray()[i];
            }
        }
        logger.log(Level.INFO, String.format("\nMin value of array: %d\nMax value of array: %d", min, max));
        ArrayMinMax minmaxcount = new ArrayMinMax(min, max);
        return minmaxcount;
    }

}