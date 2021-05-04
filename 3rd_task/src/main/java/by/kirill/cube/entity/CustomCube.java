package by.kirill.cube.entity;


import by.kirill.cube.comparator.FieldXComparator;
import by.kirill.cube.comparator.FieldYComparator;
import by.kirill.cube.comparator.FieldZComparator;
import by.kirill.cube.comparator.IdComparator;
import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.observer.CustomCubeEvent;
import by.kirill.cube.observer.Observable;
import by.kirill.cube.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class CustomCube extends Figure implements Observable {


    private CustomPoint firstPoint;
    private CustomPoint secondPoint;
    private List<Observer> cubeObservers = new ArrayList<>();


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
        cubeObservers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        cubeObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        CustomCubeEvent event = new CustomCubeEvent(this);
        if (!cubeObservers.isEmpty()) {
            for (Observer observer : cubeObservers) {
                observer.updateArea(event);
                observer.updateVolume(event);
            }
        }
    }

    public int compareFirstPointByX(CustomCube cube) {
        FieldXComparator comparator = new FieldXComparator();
        return comparator.compare(this.firstPoint, cube.getFirstPoint());
    }

    public int compareFirstPointByY(CustomCube cube) {
        FieldYComparator comparator = new FieldYComparator();
        return comparator.compare(this.firstPoint, cube.getFirstPoint());
    }

    public int compareFirstPointByZ(CustomCube cube) {
        FieldZComparator comparator = new FieldZComparator();
        return comparator.compare(this.firstPoint, cube.getFirstPoint());
    }

    public int compareSecondPointByX(CustomCube cube) {
        FieldXComparator comparator = new FieldXComparator();
        return comparator.compare(this.secondPoint, cube.getSecondPoint());
    }

    public int compareSecondPointByY(CustomCube cube) {
        FieldYComparator comparator = new FieldYComparator();
        return comparator.compare(this.secondPoint, cube.getSecondPoint());
    }

    public int compareSecondPointByZ(CustomCube cube) {
        FieldZComparator comparator = new FieldZComparator();
        return comparator.compare(this.secondPoint, cube.getSecondPoint());
    }

    public int compareById(CustomCube cube) {
        IdComparator comparator = new IdComparator();
        return comparator.compare(this, cube);
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
        return (this.firstPoint.getX() == that.getFirstPoint().getX() && this.firstPoint.getY() ==
                that.firstPoint.getY() && this.firstPoint.getZ() == that.firstPoint.getZ() &&
                this.secondPoint.getX() == that.getSecondPoint().getX() && this.secondPoint.getY() ==
                that.getSecondPoint().getY() && this.secondPoint.getZ() == that.getSecondPoint().getZ());
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
