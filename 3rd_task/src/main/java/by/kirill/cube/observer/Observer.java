package by.kirill.cube.observer;

import by.kirill.cube.entity.CustomCube;

public interface Observer {

    void updateSurfaceArea(CustomCubeEvent customCubeEvent);

    void updateVolume(CustomCubeEvent customCubeEvent);

}
