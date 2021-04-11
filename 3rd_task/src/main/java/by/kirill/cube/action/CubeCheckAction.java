package by.kirill.cube.action;

import by.kirill.cube.entity.CustomCube;

public class CubeCheckAction {

    public boolean isCube(CustomCube customCube) {
        boolean isCube = false;
        int ab = customCube.getB().getZ() - customCube.getA().getZ();
        int bb1 = customCube.getB1().getY() - customCube.getB().getY();
        int b1c1 = customCube.getC1().getX() - customCube.getB1().getX();
        int cd = customCube.getC().getZ() - customCube.getD().getZ();
        int dd1 = customCube.getD1().getY() - customCube.getD().getY();
        int a1d1 = customCube.getD1().getX() - customCube.getA1().getX();
        double faceDiagonal = Math.sqrt((Math.pow(cd, 2) + Math.pow(dd1, 2)));
        double cubeDiagonal = Math.sqrt(Math.pow(faceDiagonal, 2) + Math.pow(a1d1, 2));

        if (ab == bb1 && bb1 == b1c1 && cubeDiagonal == ab * Math.sqrt(3)) {
            isCube = true;
        }
        return isCube;
    }


    public boolean onAxis(CustomCube customCube) {
        int counter = 0;
        boolean onAxis = false;
        if (customCube.getA().getX() == 0 || customCube.getB1().getX() == 0 || customCube.getD1().getX() == 0 || customCube.getC().getX() == 0) {
            counter++;
        }
        if (customCube.getA().getY() == 0 || customCube.getB1().getY() == 0 || customCube.getD1().getY() == 0 || customCube.getC().getY() == 0) {
            counter++;
        }
        if (customCube.getA().getZ() == 0 || customCube.getB1().getZ() == 0 || customCube.getD1().getZ() == 0 || customCube.getC().getZ() == 0) {
            counter++;
        }
        if(counter == 2) {
            onAxis = true;
        }
        return onAxis;
    }
}
