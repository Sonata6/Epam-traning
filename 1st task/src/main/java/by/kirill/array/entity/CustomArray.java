package by.kirill.array.entity;

import by.kirill.array.service.ArrayReplaceService;
import org.apache.logging.log4j.LogManager;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.logging.Logger;


@Entity
public class CustomArray {

    //private static final Logger logger = (Logger) LogManager.getLogger(ArrayReplaceService.class);
    //logger.info("hello");

    private int[] array; // = 0

    public CustomArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    /** @return a copy of the array */
    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int i, int count) {
        array[i] = count;
    }
}