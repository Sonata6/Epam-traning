package by.kirill.cube.repository.Impl;

import by.kirill.cube.action.CubeCalculateAction;
import by.kirill.cube.entity.AbstractFigure;
import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.repository.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.kirill.cube.entity.FigureType.CUSTOM_CUBE;

public class VolumeSpecification implements Specification {
    private static Logger logger = LogManager.getRootLogger();

    private double minVolume;
    private double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(AbstractFigure figure) {
        String className = figure.getClass().getSimpleName();
        boolean result = false;
        switch (className) {
            case (CUSTOM_CUBE):
                CustomCube customCube = (CustomCube) figure;
                CubeCalculateAction cubeCalculateAction = new CubeCalculateAction();
                double cubeVolume = cubeCalculateAction.calculateVolume(customCube);
                result = minVolume <= cubeVolume & cubeVolume <= maxVolume;
                break;
            default:
                logger.log(Level.ERROR, "No such action for figure: {}", className);
                break;
        }
        return result;
    }
}
