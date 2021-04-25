package by.kirill.cube.observer.impl;

import by.kirill.cube.action.CubeCalculateAction;
import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.FigureParameters;
import by.kirill.cube.entity.Warehouse;
import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.observer.CustomCubeEvent;
import by.kirill.cube.observer.Observer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObserverImpl implements Observer {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateSurfaceArea(CustomCubeEvent customCubeEvent) {
        CustomCube customCube = customCubeEvent.getSource();
        long id = customCube.getId();
        Warehouse warehouse = Warehouse.getInstance();
        FigureParameters parameters = warehouse.get(id);
        CubeCalculateAction cubeAction = new CubeCalculateAction();
        double surfaceArea = cubeAction.calculateArea(customCube);
        parameters.setSurfaceArea(surfaceArea);
    }

    @Override
    public void updateVolume(CustomCubeEvent customCubeEvent) {
        CustomCube cone = customCubeEvent.getSource();
        long id = cone.getId();
        Warehouse warehouse = Warehouse.getInstance();
        FigureParameters parameters = warehouse.get(id);
        CubeCalculateAction cubeAction = new CubeCalculateAction();
        double volume = cubeAction.calculateVolume(cone);
        parameters.setVolume(volume);
    }
}
