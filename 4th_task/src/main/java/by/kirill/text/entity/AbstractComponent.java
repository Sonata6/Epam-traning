package by.kirill.text.entity;

import by.kirill.text.entity.impl.ComponentType;
import jdk.jshell.spi.ExecutionControl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractComponent implements Iterable<AbstractComponent> {

    public Iterator<AbstractComponent> iterator() {
        List<AbstractComponent> list = new LinkedList<>();
        addAllToList(list);
        list.add(this);
        return list.iterator();
    }

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

    public abstract char getCharacter() throws ExecutionControl.NotImplementedException;

    public abstract void addAllToList(List<AbstractComponent> abstractComponents);
}
