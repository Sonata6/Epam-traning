package by.kirill.cube.repository.Impl;

import by.kirill.cube.entity.Figure;
import by.kirill.cube.repository.Specification;

public class IdSpecification implements Specification {

    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Figure figure) {
        boolean result = figure.getId() == this.id;
        return result;
    }


}
