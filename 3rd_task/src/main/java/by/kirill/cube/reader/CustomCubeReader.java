package by.kirill.cube.reader;

import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.validation.CustomCubeValidator;
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

public class CustomCubeReader
{
    private static Logger logger = LogManager.getLogger();

    public List<String> readFromFile(Path filepath) throws CustomCubeException {
        List<String> lines;
        List<String> correctLines = null;
        Path path = Paths.get(String.valueOf(filepath));
        if (Files.notExists(path)) {
            logger.log(Level.ERROR, "File path problems");
            throw new CustomCubeException("No file found in this path");
        }
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
            lines = lineStream.collect(Collectors.toList());
            for (String line : lines) {
                if (CustomCubeValidator.validateString(line)) {
                    correctLines.add(line);
                }
            }
            if (correctLines == null) {
                logger.log(Level.ERROR, "Incorrect data");
                throw new CustomCubeException("No valid array exist");
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "Incorrect path");
            throw new CustomCubeException("File open Error");
        }
        logger.log(Level.INFO, "Number of cubes: " + correctLines.size());
        return correctLines;
    }


    public Path createFilePath(String filePath) throws CustomCubeException {
        URI uri;
        try {
            uri = getClass().getResource(filePath).toURI();
        } catch (URISyntaxException | NullPointerException e) {
            logger.log(Level.ERROR, "There is file path problems");
            throw new CustomCubeException("No such file on the current path");
        }
        String absolutePath = new File(uri).getAbsolutePath();
        Path path = Paths.get(absolutePath);
        filePathCheck(path);
        return path;
    }

    private void filePathCheck(Path path) throws CustomCubeException {
        if (!CustomCubeValidator.validateFilePath(path)) {
            throw new CustomCubeException("File by path: \'" + path.toString() + "\'is not exist");
        }
    }
}
