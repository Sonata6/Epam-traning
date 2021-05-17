package by.kirill.text.reader;

import by.kirill.text.exeption.TextHandlerException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TextReader {
    private static Logger logger = LogManager.getLogger();
    public String readTextFromFile(String path) throws TextHandlerException {
        String text;
        try {
            text = Files.readString(Paths.get(path));
        } catch (IOException exception) {
            logger.log(Level.ERROR, "Exception while reading from file");
            throw new TextHandlerException("Exception while reading from file");
        }
        return text;
    }
}
