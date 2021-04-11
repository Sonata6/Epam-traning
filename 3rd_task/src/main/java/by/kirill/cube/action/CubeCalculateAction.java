package by.kirill.cube.action;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.exception.CustomCubeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeCalculateAction {

    private static Logger logger = LogManager.getLogger();

    public double calculateArea(CustomCube customCube)
    {
        int area = (customCube.getA().getZ() - customCube.getB().getZ())^2 * 6;
        logger.log(Level.INFO, "Cube area:" + area);
        return area;
    }

    public double calculateVolume(CustomCube customCube)
    {
        int volume = (int)Math.pow((customCube.getA().getZ() - customCube.getB().getZ()),3);
        logger.log(Level.INFO, "Cube volume" + volume);
        return volume;
    }

    public double calculateRatio(CustomCube customCube) throws CustomCubeException {
        double ratio = 0;
        CubeCalculateAction volume = new CubeCalculateAction();
        int face = customCube.getB().getZ() - customCube.getA().getZ();
        if(customCube.getA().getX()*customCube.getC1().getX() < 0) {
            ratio = (double)(customCube.getA1().getY()*face*face) / (volume.calculateVolume(customCube) - (customCube.getA1().getY()*face*face));
        } else if (customCube.getA().getY()*customCube.getC1().getY() < 0) {
            if (ratio != 0.0) {
                logger.log(Level.ERROR, "Incorrect cube data");
                throw new CustomCubeException("The cube crosses two axes");
            }
            ratio = (double)(customCube.getD().getZ()*face*face) / (volume.calculateVolume(customCube) - (customCube.getD().getZ()*face*face));
        } else if (customCube.getA().getZ()*customCube.getC1().getZ() < 0) {
            if (ratio != 0.0) {
                logger.log(Level.ERROR, "Incorrect cube data");
                throw new CustomCubeException("The cube crosses two axes");
            }
            ratio = (double)(customCube.getB().getX()*face*face) / (volume.calculateVolume(customCube) - (customCube.getB().getX()*face*face));
        }
        return ratio;
    }
}