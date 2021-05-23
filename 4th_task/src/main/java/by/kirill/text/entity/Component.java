package by.kirill.text.entity;

public abstract class Component implements Iterable<Component> {

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract Component getChild(int index);

}
