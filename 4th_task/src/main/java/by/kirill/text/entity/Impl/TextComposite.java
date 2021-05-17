package by.kirill.text.entity.Impl;

import by.kirill.text.entity.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.List;

import org.apache.logging.log4j.Level;

public class TextComposite extends Composite {

    private static Logger logger = LogManager.getLogger();
    private CompositeType compositeType;
    private final List<Composite> composites = new ArrayList<>();

    public TextComposite(CompositeType compositeType) {
        this.compositeType = compositeType;
    }


    @Override
    public void add(Composite textComponent) {
        logger.log(Level.INFO, "Composite -> adding child");
        composites.add(textComponent);
    }

    @Override
    public void remove(Composite textComponent) {
        logger.log(Level.INFO, "Composite -> deleting child");
        composites.remove(textComponent);
    }

    @Override
    public Composite getChild(int index) {
        logger.log(Level.INFO, "Composite -> getting child by index {}", index);
        return composites.get(index);
    }

    @Override
    public String toString() {
        String delimeter = compositeType.getDelimiter();
        String[] stringComponents = composites.stream()
                .map(Object::toString)
                .toArray(String[]::new);
        return String.join(delimeter, stringComponents);
    }

    @Override
    public Iterator<Composite> iterator() {
        return Collections.emptyIterator();
    }
}
