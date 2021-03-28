package by.kirill.array.service;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class SortService {

    private final static Logger logger = LogManager.getLogger(SortService.class);

    public void bubbleSort(CustomArray customArray) throws CustomArrayException {
        CustomArrayValidator.validateNotNullOrEmpty(customArray);
        logger.log(Level.DEBUG, "in bubbleSort");
        int[] array = customArray.getArray();
        int length = array.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        customArray.setArray(array);
    }

    public void shakeSort(CustomArray customArray) throws CustomArrayException {
        CustomArrayValidator.validateNotNullOrEmpty(customArray);
        logger.log(Level.DEBUG, "in shakeSort");
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        customArray.setArray(array);
    }

    public void insertionSort(CustomArray customArray) throws CustomArrayException {
        CustomArrayValidator.validateNotNullOrEmpty(customArray);
        logger.log(Level.DEBUG, "in insertionSort");
        int[] array = customArray.getArray();
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        customArray.setArray(array);
    }

    public CustomArray sortWithIntStream(CustomArray customArray) throws CustomArrayException {
        CustomArrayValidator.validateNotNullOrEmpty(customArray);
        logger.log(Level.DEBUG, "in intStreamSort");
        int[] array = customArray.getArray();
        array = IntStream.of(array).sorted().toArray();
        customArray.setArray(array);
        return customArray;
    }

}
