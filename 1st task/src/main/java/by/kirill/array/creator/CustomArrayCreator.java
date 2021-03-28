package by.kirill.array.creator;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.parser.CustomArrayParser;
import by.kirill.array.reader.CustomArrayReader;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomArrayCreator {

    private static Logger logger = LogManager.getLogger();
    private static final String DATAPATH = "/data/data.txt";

    public CustomArray customArrayCreator() throws CustomArrayException {

        CustomArrayReader reader = new CustomArrayReader();
        Path absolutePath = createFilePath();
        String actualString = reader.readFromFile(absolutePath);
        logger.log(Level.INFO, "actual array: " + actualString);
        CustomArrayParser parser = new CustomArrayParser();
        int actualarray[] = parser.stringParser(actualString);
        CustomArray customArray = new CustomArray(actualarray);
        CustomArrayValidator validator = new CustomArrayValidator();
        validator.validateNotNullOrEmpty(customArray);
        return customArray;
    }

    public Path createFilePath() throws CustomArrayException {
        URI uri = null;
        try {
            uri = getClass().getResource(DATAPATH).toURI();
        } catch (URISyntaxException | NullPointerException e) {
            logger.log(Level.ERROR, "There is file path problems");
            throw new CustomArrayException("No such file on the current path");
        }
        String absolutePath = new File(uri).getAbsolutePath();
        Path path = Paths.get(absolutePath);
        pathCheck(path);
        return path;
    }

    private void pathCheck(Path path) throws CustomArrayException {
        if (Files.notExists(path)) {
            logger.log(Level.ERROR, "NoSuchFileException");
            throw new CustomArrayException();
        }
    }
}