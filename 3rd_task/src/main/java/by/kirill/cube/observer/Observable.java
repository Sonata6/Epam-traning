package by.kirill.cube.observer;

public interface Observable {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}
