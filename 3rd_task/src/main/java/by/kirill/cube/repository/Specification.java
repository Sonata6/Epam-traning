package by.kirill.cube.repository;

import by.kirill.cube.entity.Figure;
import by.kirill.cube.exception.CustomCubeException;

public interface Specification {

    boolean specify(Figure figure) throws CustomCubeException;

}
