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

    public String readFromFile(String filepath) throws CustomArrayException {
        List<String> lines = new ArrayList<>();
        String actualarray = null;
        Path path = Paths.get(filepath);
        if(Files.notExists(path)){
            logger.log(Level.FATAL, "No file found in this path");
            throw new CustomArrayException();
        }
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {

            lines = lineStream.collect(Collectors.toList());
            CustomArrayValidator validator = new CustomArrayValidator();
            for(String line : lines) {
                if(validator.validateFileData(line)) {
                    actualarray = line;
                    break;
                }
            }
        } catch (IOException e) {
            logger.log(Level.FATAL, "File open Error");
            throw new CustomArrayException();
        }
        return actualarray;
    }

}
