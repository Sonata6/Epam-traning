package by.kirill.cube.repository.Impl;

import by.kirill.cube.action.CubeCalculateAction;
import by.kirill.cube.entity.AbstractFigure;
import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.repository.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.kirill.cube.entity.FigureType.CUSTOM_CUBE;

public class AreaSpecification implements Specification {

    private static Logger logger = LogManager.getRootLogger();

    private double minArea;
    private double maxArea;

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(AbstractFigure figure) {
        String className = figure.getClass().getSimpleName();
        boolean result = false;
        switch (className) {
            case (CUSTOM_CUBE):
                CustomCube customCube = (CustomCube) figure;
                CubeCalculateAction cubeCalculateAction = new CubeCalculateAction();
                double cubeArea = cubeCalculateAction.calculateArea(customCube);
                result = minArea <= cubeArea & cubeArea <= maxArea;
                break;
            default:
                logger.log(Level.ERROR, "No such action for figure: {}", className);
                break;
        }
        return result;
    }

}
