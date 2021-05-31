package by.kirill.text.entity.impl;

import by.kirill.text.entity.AbstractComponent;
import jdk.jshell.spi.ExecutionControl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.List;

import org.apache.logging.log4j.Level;

public class TextComposite extends AbstractComponent {

    private static Logger logger = LogManager.getLogger();
    private List<AbstractComponent> abstractComponents = new ArrayList<>();

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    public void setComponents(List<AbstractComponent> components) {
        this.abstractComponents = new ArrayList<>(components);
    }

    public int getNumberOfComponents() {
        logger.log(Level.INFO, "Number of components:" + abstractComponents.size());
        return abstractComponents.size();
    }

    @Override
    public void add(AbstractComponent textAbstractComponent) {
        logger.log(Level.INFO, "Composite -> adding child");
        abstractComponents.add(textAbstractComponent);
    }

    @Override
    public void remove(AbstractComponent textAbstractComponent) {
        logger.log(Level.INFO, "Composite -> deleting child");
        abstractComponents.remove(textAbstractComponent);
    }

    @Override
    public AbstractComponent getChild(int index) {
        logger.log(Level.INFO, "Composite -> getting child by index {}", index);
        return abstractComponents.get(index);
    }

    @Override
    public char getCharacter() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented");
    }

    @Override
    public String toString() {
        String delimeter = componentType.getDelimiter();
        String[] stringComponents = abstractComponents.stream()
                .map(Object::toString)
                .toArray(String[]::new);
        return String.join(delimeter, stringComponents);
    }

    @Override
    public void addAllToList(List<AbstractComponent> abstractComponents) {
        abstractComponents.add(this);
    }
}
