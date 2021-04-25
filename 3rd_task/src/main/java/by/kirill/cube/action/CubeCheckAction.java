package by.kirill.cube.action;

import by.kirill.cube.entity.CustomCube;

public class CubeCheckAction {

    public boolean isCube(CustomCube customCube) {
        boolean isCube = false;
        int side = customCube.getSecondPoint().getX() - customCube.getFirstPoint().getX();
        int lenghtToX = customCube.getFirstPoint().getX();
        int lenghtToY = customCube.getFirstPoint().getY();
        int lenghtToZ = customCube.getFirstPoint().getZ();
        if(customCube.getSecondPoint().getX() == lenghtToX + side &&
           customCube.getSecondPoint().getY() == lenghtToY + side &&
           customCube.getSecondPoint().getZ() == lenghtToZ + side) {
            isCube = true;
        }

        return isCube;
    }


    public boolean onAxis(CustomCube customCube) {
        boolean onAxis = false;

        if(customCube.getFirstPoint().getX() == 0 || customCube.getFirstPoint().getY() == 0 ||
           customCube.getFirstPoint().getZ() == 0 || customCube.getSecondPoint().getX() == 0 ||
           customCube.getSecondPoint().getY() == 0 || customCube.getSecondPoint().getZ() == 0) {
            onAxis = true;
        }

        return onAxis;
    }
}
