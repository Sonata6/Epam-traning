package by.kirill.text.entity;

import by.kirill.text.entity.impl.ComponentType;

public abstract class AbstractComponent implements Iterable<AbstractComponent> {

    protected ComponentType componentType;

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public abstract void add(AbstractComponent c);

    public abstract void remove(AbstractComponent c);

    public abstract AbstractComponent getChild(int index);

}
