package by.kirill.cube.repository.Impl;

import by.kirill.cube.entity.AbstractFigure;
import by.kirill.cube.repository.Specification;

public class IdSpecification implements Specification {

    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(AbstractFigure abstractFigure) {
        boolean result = abstractFigure.getId() == this.id;
        return result;
    }


}
