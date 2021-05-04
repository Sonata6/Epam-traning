package by.kirill.cube.comparator;

import by.kirill.cube.entity.CustomPoint;

import java.util.Comparator;

public class FieldZComparator implements Comparator<CustomPoint> {

    @Override
    public int compare(CustomPoint firstPoint, CustomPoint secondPoint) {
        int result = 0;
        if (firstPoint.getZ() > secondPoint.getZ()) {
            result = 1;
        } else if (firstPoint.getZ() < secondPoint.getZ()) {
            result = -1;
        }
        return result;
    }
}