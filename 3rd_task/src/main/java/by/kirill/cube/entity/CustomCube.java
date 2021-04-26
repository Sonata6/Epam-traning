package by.kirill.cube.entity;


import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.observer.CustomCubeEvent;
import by.kirill.cube.observer.Observable;
import by.kirill.cube.observer.Observer;

import java.util.ArrayList;

public class CustomCube extends Figure implements Observable {


    private CustomPoint firstPoint;
    private CustomPoint secondPoint;
    private ArrayList<Observer> observers = new ArrayList<>();


    public CustomCube() {
        this.firstPoint = new CustomPoint(0, 0, 0);
        this.secondPoint = new CustomPoint(0, 0, 0);
    }

    public CustomCube(CustomPoint firstPoint, CustomPoint secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public CustomCube(CustomCube customCube) {
        super(customCube);
        this.firstPoint.setX(customCube.getFirstPoint().getX());
        this.firstPoint.setY(customCube.getSecondPoint().getY());
        this.firstPoint.setZ(customCube.getFirstPoint().getZ());
        this.secondPoint.setX(customCube.getSecondPoint().getX());
        this.secondPoint.setY(customCube.getSecondPoint().getY());
        this.secondPoint.setZ(customCube.getSecondPoint().getZ());
    }

    public CustomPoint getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(CustomPoint firstPoint) throws CustomCubeException {

        this.firstPoint = firstPoint;
        notifyObservers();
    }

    public CustomPoint getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(CustomPoint secondPoint) throws CustomCubeException {

        this.secondPoint = secondPoint;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws CustomCubeException {
        CustomCubeEvent event = new CustomCubeEvent(this);
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.updateSurfaceArea(event);
                observer.updateVolume(event);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomCube that = (CustomCube) o;
        return super.equals(firstPoint) && super.equals(secondPoint);
    }

    @Override
    public int hashCode() {
        return (firstPoint.getX() >> 16) ^ (secondPoint.getX() >> 16) ^ (firstPoint.getY() >> 8) ^
                (secondPoint.getY() >> 8) ^ firstPoint.getZ() ^ secondPoint.getZ() | super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("First Point: [x=");
        stringBuilder.append(firstPoint.getX());
        stringBuilder.append(", y=");
        stringBuilder.append(firstPoint.getY());
        stringBuilder.append(", z=");
        stringBuilder.append(firstPoint.getZ());
        stringBuilder.append("]");
        stringBuilder.append("Second Point: [x=");
        stringBuilder.append(secondPoint.getX());
        stringBuilder.append(", y=");
        stringBuilder.append(secondPoint.getY());
        stringBuilder.append(", z=");
        stringBuilder.append(secondPoint.getZ());
        stringBuilder.append("]");
        String result = stringBuilder.toString();
        return result;
    }
}
