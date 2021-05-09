package by.kirill.text.entity;

import java.util.logging.Level;

public interface Composite extends Iterable<Composite> {
    void operation();
    void add(Composite c);
    void remove(Composite c);
    Composite getChild(int index);
}
