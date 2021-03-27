package by.kirill.array.entity;

import by.kirill.array.exception.CustomArrayException;

import javax.persistence.Entity;
import java.util.Arrays;


@Entity
public class CustomArray {

    private int[] array;

    public CustomArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    /**
     * @return a copy of the array
     */
    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getElement(int index) throws CustomArrayException {
        if (index <= 0 || index > array.length) {
            throw new CustomArrayException("Incorrect index or array is empty");
        }
        return this.array[index];
    }

    public void setElement(int i, int count) {
        array[i] = count;
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}