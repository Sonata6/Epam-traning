package by.kirill.cube.observer;

import by.kirill.cube.entity.CustomCube;

import java.util.EventObject;

public class CustomCubeEvent extends EventObject {
    public CustomCubeEvent(CustomCube source) {

        super(source);
    }

    @Override
    public CustomCube getSource() {

        return (CustomCube) super.getSource();
    }
}
