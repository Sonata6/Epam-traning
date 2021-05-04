package by.kirill.cube.comparator;

import by.kirill.cube.entity.CustomPoint;

import java.util.Comparator;

public class FieldXComparator implements Comparator<CustomPoint> {

    @Override
    public int compare(CustomPoint firstPoint, CustomPoint secondPoint) {
        int result = 0;
        if (firstPoint.getX() > secondPoint.getX()) {
            result = 1;
        } else if (firstPoint.getX() < secondPoint.getX()) {
            result = -1;
        }
        return result;
    }
}
