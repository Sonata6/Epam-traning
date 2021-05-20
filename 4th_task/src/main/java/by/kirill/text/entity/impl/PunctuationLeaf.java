package by.kirill.text.entity.Impl;

import by.kirill.text.entity.Composite;

import java.util.Iterator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PunctuationLeaf extends Composite {

    private static Logger logger = LogManager.getLogger();
    private char punctuation;

    public PunctuationLeaf(char punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public void add(Composite textComponent) {
        logger.log(Level.WARN, "Unsupported add operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Composite textComponent) {
        logger.log(Level.WARN, "Unsupported remove operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public Composite getChild(int index) {
        logger.log(Level.WARN, "Unsupported getChild operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(punctuation);
    }

    @Override
    public Iterator<Composite> iterator() {
        logger.log(Level.WARN, "Unsupported operation in PunctuationLeaf");
        throw new UnsupportedOperationException();
    }
}
