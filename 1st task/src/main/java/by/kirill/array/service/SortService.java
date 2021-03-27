package by.kirill.array.service;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortService {
    //private final static SortService INSTANCE = new SortServiceImpl();
    private final static Logger LOGGER = LogManager.getLogger(SortService.class);
    //private static CustomArrayServiceValidator validator = new CustomArrayServiceValidator();

//    public static SortService getInstance() {
//        return INSTANCE;
//    }


    public void bubbleSort(CustomArray customArray) throws CustomArrayException {
        //validator.validateNotNullOrEmpty(customArray);
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
        //validator.validateNotNullOrEmpty(customArray);
        int[] array = customArray.getArray();
        int buff;
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
        customArray.setArray(array);
    }

    public void CombSort(CustomArray customArray) throws CustomArrayException {
        //validator.validateNotNullOrEmpty(customArray);
        int[] array = customArray.getArray();
        int gap = array.length;
        boolean swap = true;
        while (gap > 1 || swap) {
            if (gap > 1)
                gap = (int) (gap / 1.247330950103979);

            int i = 0;
            swap = false;
            while (i + gap < array.length) {
                if (array[i] > array[i + gap]) {
                    int buf = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = buf;
                    swap = true;
                }
                i++;
            }
        }
        customArray.setArray(array);
    }
}
