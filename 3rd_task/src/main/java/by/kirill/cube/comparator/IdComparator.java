package by.kirill.cube.comparator;

import by.kirill.cube.entity.CustomCube;

import java.util.Comparator;

public class IdComparator implements Comparator<CustomCube> {

    @Override
    public int compare(CustomCube firstCube, CustomCube secondCube) {
        int result = 0;
        if (firstCube.getId() > secondCube.getId()) {
            result = 1;
        } else if (firstCube.getId() < secondCube.getId()) {
            result = -1;
        }
        return result;
    }

}