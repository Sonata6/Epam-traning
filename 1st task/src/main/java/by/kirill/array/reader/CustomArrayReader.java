package by.kirill.array.reader;

import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomArrayReader {

    private static Logger logger = LogManager.getLogger();

    public String readFromFile(Path filepath) throws CustomArrayException {
        List<String> lines = new ArrayList<>();
        String actualArray = null;
        Path path = Paths.get(String.valueOf(filepath));
        if (Files.notExists(path)) {
            logger.log(Level.ERROR, "File path problem");
            throw new CustomArrayException("No file found in this path");
        }
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {

            lines = lineStream.collect(Collectors.toList());
            CustomArrayValidator validator = new CustomArrayValidator();
            for (String line : lines) {
                if (validator.validateFileData(line)) {
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
        return actualArray;
    }

}
