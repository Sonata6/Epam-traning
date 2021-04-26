package by.kirill.cube.observer;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.exception.CustomCubeException;

public interface Observer {

    void updateSurfaceArea(CustomCubeEvent customCubeEvent) throws CustomCubeException;

    void updateVolume(CustomCubeEvent customCubeEvent) throws CustomCubeException;

}
