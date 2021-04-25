package by.kirill.cube.repository.Impl;

import by.kirill.cube.entity.AbstractFigure;
import by.kirill.cube.repository.Specification;

public class NameSpecification implements Specification {

    private String subString;

    public NameSpecification(String subString) {
        this.subString = subString;
    }

    @Override
    public boolean specify(AbstractFigure abstractFigure) {
        boolean result = abstractFigure.getName().contains(subString);
        return result;
    }
}
