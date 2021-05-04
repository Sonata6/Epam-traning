package by.kirill.cube.comparator;

import by.kirill.cube.entity.CustomPoint;

import java.util.Comparator;

public class FieldYComparator implements Comparator<CustomPoint> {

    @Override
    public int compare(CustomPoint firstPoint, CustomPoint secondPoint) {
        int result = 0;
        if (firstPoint.getY() > secondPoint.getY()) {
            result = 1;
        } else if (firstPoint.getY() < secondPoint.getY()) {
            result = -1;
        }
        return result;
    }
}
