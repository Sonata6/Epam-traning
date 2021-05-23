package by.kirill.text.entity.impl;

import by.kirill.text.entity.Component;

import java.util.Iterator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class SymbolLeaf extends Component {

    private static Logger logger = LogManager.getLogger();
    private char symbol;

    public SymbolLeaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(Component textComponent) {
        logger.log(Level.WARN, "Unsupported add operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component textComponent) {
        logger.log(Level.WARN, "Unsupported remove operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int index) {
        logger.log(Level.WARN, "Unsupported getChild operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public Iterator<Component> iterator() {
        logger.log(Level.WARN,"Unsupported operation in SymbolLeaf");
        throw new UnsupportedOperationException();
    }
}
