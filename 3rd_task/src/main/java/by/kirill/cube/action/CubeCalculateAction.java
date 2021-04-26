package by.kirill.cube.action;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.validation.CustomCubeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeCalculateAction {

    private static Logger logger = LogManager.getLogger();

    public double calculateArea(CustomCube customCube) throws CustomCubeException {
        if(CustomCubeValidator.validateNotNullOrEmpty(customCube)) {
            throw new CustomCubeException("Object must be inialized");
        }
        double area = Math.pow(((customCube.getFirstPoint().getZ() - customCube.getSecondPoint().getZ()) / Math.sqrt(3)),2) * 6;
        logger.log(Level.INFO, "Cube area:" + area);
        return area;
    }

    public double calculateVolume(CustomCube customCube) throws CustomCubeException {
        if(CustomCubeValidator.validateNotNullOrEmpty(customCube)) {
            throw new CustomCubeException("Object must be inialized");
        }
        int volume = (int)Math.pow(((customCube.getSecondPoint().getZ() - customCube.getFirstPoint().getZ()) / Math.sqrt(3)),3);
        logger.log(Level.INFO, "Cube volume" + volume);
        return volume;
    }

    public double calculateRatio(CustomCube customCube) throws CustomCubeException {
        if(CustomCubeValidator.validateNotNullOrEmpty(customCube)) {
            throw new CustomCubeException("Object must be inialized");
        }
        double ratio = 0;
        if(customCube.getFirstPoint().getX()*customCube.getSecondPoint().getX() < 0) {
            ratio = (double)(customCube.getSecondPoint().getY()) / (customCube.getFirstPoint().getY());
        } else if (customCube.getFirstPoint().getY()*customCube.getSecondPoint().getY() < 0) {
            if (ratio != 0.0) {
                logger.log(Level.ERROR, "Incorrect cube data");
                throw new CustomCubeException("The cube crosses two axes");
            }
            ratio = (double)(customCube.getSecondPoint().getZ()) / (customCube.getFirstPoint().getZ());
        } else if (customCube.getFirstPoint().getZ()*customCube.getSecondPoint().getZ() < 0) {
            if (ratio != 0.0) {
                logger.log(Level.ERROR, "Incorrect cube data");
                throw new CustomCubeException("The cube crosses two axes");
            }
            ratio = (double)(customCube.getSecondPoint().getX()) / (customCube.getFirstPoint().getX());
        }
        return Math.pow(ratio, 3) * -1;
    }
}