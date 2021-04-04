package by.kirill.array.reader;

import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomArrayReader {

    private static Logger logger = LogManager.getLogger();

    public String readFromFile(Path filepath) throws CustomArrayException {
        List<String> lines;
        String actualArray = null;
        Path path = Paths.get(String.valueOf(filepath));
        if (Files.notExists(path)) {
            logger.log(Level.ERROR, "File path problems");
            throw new CustomArrayException("No file found in this path");
        }
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
            lines = lineStream.collect(Collectors.toList());
            CustomArrayValidator validator = new CustomArrayValidator();
            for (String line : lines) {
                if (validator.validateString(line)) {
                    actualArray = line;
                    break;
                }
            }
            if (actualArray == null) {
                logger.log(Level.ERROR, "Incorrect data");
                throw new CustomArrayException("No valid array exist");
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "Incorrect path");
            throw new CustomArrayException("File open Error");
        }
        logger.log(Level.INFO, "Actual array: " + actualArray);
        return actualArray;
    }


    public Path createFilePath(String filePath) throws CustomArrayException {
        URI uri;
        try {
            uri = getClass().getResource(filePath).toURI();
        } catch (URISyntaxException | NullPointerException e) {
            logger.log(Level.ERROR, "There is file path problems");
            throw new CustomArrayException("No such file on the current path");
        }
        String absolutePath = new File(uri).getAbsolutePath();
        Path path = Paths.get(absolutePath);
        filePathCheck(path);
        return path;
    }

    private void filePathCheck(Path path) throws CustomArrayException {
        if (!CustomArrayValidator.validateFilePath(path)) {
            throw new CustomArrayException("File by path: \'" + path.toString() + "\'is not exist");
        }
    }
}
