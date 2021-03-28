import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.service.SortService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest {

    private static int array[] = {8, 3, 2, 5, 4, 6, 1, 7, 9};
    private static int expected[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void bubbleSortTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(array);
        SortService arraySort = new SortService();
        arraySort.bubbleSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shakeSortTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(array);
        SortService arraySort = new SortService();
        arraySort.shakeSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void insertionSortTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(array);
        SortService arraySort = new SortService();
        arraySort.insertionSort(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortWithIntStreamTest() throws CustomArrayException {
        CustomArray customArray = new CustomArray(array);
        SortService arraySort = new SortService();
        arraySort.sortWithIntStream(customArray);
        int[] actual = customArray.getArray();
        Assert.assertEquals(expected, actual);
    }

}
