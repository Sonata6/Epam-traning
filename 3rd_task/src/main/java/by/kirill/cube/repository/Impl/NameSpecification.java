package by.kirill.cube.repository.Impl;

import by.kirill.cube.entity.Figure;
import by.kirill.cube.repository.Specification;

public class NameSpecification implements Specification {

    private String subString;

    public NameSpecification(String subString) {
        this.subString = subString;
    }

    @Override
    public boolean specify(Figure figure) {
        boolean result = figure.getName().contains(subString);
        return result;
    }
}
