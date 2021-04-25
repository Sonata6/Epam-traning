package by.kirill.cube.entity;

import by.kirill.cube.observer.Observer;
import by.kirill.cube.observer.impl.ObserverImpl;
import by.kirill.cube.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class AbstractFigure {
    private long id;
    private String name;
    private List<Observer> observers = new ArrayList<>();

    protected AbstractFigure() {
        this.id = IdGenerator.generateNextId();
    }

    protected AbstractFigure(String name) {
        this.id = IdGenerator.generateNextId();
        this.name = name;
    }

    protected AbstractFigure(AbstractFigure figure) {
        this.id = figure.id;
        this.name = figure.name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void attach(ObserverImpl observer) {
        observers.add(observer);
    }

    public void detach(ObserverImpl observer) {
        observers.remove(observer);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractFigure other = (AbstractFigure) obj;
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AbstractFigure [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
}
