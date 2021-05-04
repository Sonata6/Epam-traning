package by.kirill.cube.observer;

public interface Observer {

    void updateArea(CustomCubeEvent customCubeEvent);

    void updateVolume(CustomCubeEvent customCubeEvent);

}
