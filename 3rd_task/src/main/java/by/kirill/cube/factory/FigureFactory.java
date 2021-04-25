package by.kirill.cube.factory;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import by.kirill.cube.exception.CustomCubeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FigureFactory {
    private static Logger logger = LogManager.getLogger();

    public static CustomCube getCubeFromFactory(CustomPoint firstPoint, CustomPoint secondPoint) throws CustomCubeException {
        CustomCube customCube = new CustomCube(firstPoint, secondPoint);
        logger.log(Level.INFO, "new cube created");
        return customCube;
    }

    public static CustomCube getCubeFromFactory(int x1, int y1, int z1, int x2, int y2, int z2)
            throws CustomCubeException {
        CustomPoint firstPoint = new CustomPoint(x1, y1, z1);
        CustomPoint secondPoint = new CustomPoint(x2, y2, z2);
        CustomCube cone = new CustomCube(firstPoint, secondPoint);
        logger.info("new cube {} was created", cone);
        return cone;
    }

    public static CustomCube getCubeFromFactory(int[] array) throws CustomCubeException {
        if (array.length != 6) {
            logger.error("wrong array size {} in factory", array.length);
            throw new CustomCubeException("Wrong number of parameters " + array.length);
        }
        CustomPoint firstPoint = new CustomPoint(array[0], array[1], array[2]);
        CustomPoint secondPoint = new CustomPoint(array[3], array[4], array[5]);
        CustomCube customCube = new CustomCube(firstPoint, secondPoint);
        logger.info("new cube {} was created", customCube);
        return customCube;
    }
}
