package by.kirill.text.entity.impl;

import by.kirill.text.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.List;

import org.apache.logging.log4j.Level;

public class TextComponent extends Component {

    private static Logger logger = LogManager.getLogger();
    private CompositeType compositeType;
    private final List<Component> components = new ArrayList<>();

    public TextComponent(CompositeType compositeType) {
        this.compositeType = compositeType;
    }


    @Override
    public void add(Component textComponent) {
        logger.log(Level.INFO, "Composite -> adding child");
        components.add(textComponent);
    }

    @Override
    public void remove(Component textComponent) {
        logger.log(Level.INFO, "Composite -> deleting child");
        components.remove(textComponent);
    }

    @Override
    public Component getChild(int index) {
        logger.log(Level.INFO, "Composite -> getting child by index {}", index);
        return components.get(index);
    }

    @Override
    public String toString() {
        String delimeter = compositeType.getDelimiter();
        String[] stringComponents = components.stream()
                .map(Object::toString)
                .toArray(String[]::new);
        return String.join(delimeter, stringComponents);
    }

    @Override
    public Iterator<Component> iterator() {
        return Collections.emptyIterator();
    }
}
