package by.kirill.text.entity;

import java.util.Iterator;
import java.util.logging.Level;

public abstract class Composite implements Iterable<Composite> {

    public abstract void add(Composite c);

    public abstract void remove(Composite c);

    public abstract Composite getChild(int index);

}
