package by.kirill.text.entity.impl;

import by.kirill.text.entity.AbstractComponent;

import java.util.Iterator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterLeaf extends AbstractComponent {

    private static Logger logger = LogManager.getLogger();
    private char symbol;

    public CharacterLeaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(AbstractComponent textAbstractComponent) {
        logger.log(Level.WARN, "Unsupported add operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractComponent textAbstractComponent) {
        logger.log(Level.WARN, "Unsupported remove operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractComponent getChild(int index) {
        logger.log(Level.WARN, "Unsupported getChild operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public Iterator<AbstractComponent> iterator() {
        logger.log(Level.WARN,"Unsupported operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }
}
