package by.kirill.cube.observer;

import by.kirill.cube.exception.CustomCubeException;

public interface Observable {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers() throws CustomCubeException;
}
