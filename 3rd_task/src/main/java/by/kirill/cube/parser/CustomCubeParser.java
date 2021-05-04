package by.kirill.cube.parser;

import by.kirill.cube.exception.CustomCubeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCubeParser {
    private static final String SPACE = " ";
    private static final String COMMA = ",";


    private static Logger logger = LogManager.getLogger();

    public List<Integer> stringParser(String customCubeStr) throws CustomCubeException {
        if (customCubeStr == null) {
            logger.log(Level.ERROR, "stringParser got null parameter.");
            throw new CustomCubeException("Input string is null.");
        }
        List<Integer> cubeCoordinates = null;
        try {
            List<String> cubeCoordinatesStr = Stream.of(customCubeStr.split(SPACE)).collect(Collectors.toList());
            cubeCoordinates = new ArrayList<>();
            for (String s : cubeCoordinatesStr) cubeCoordinates.add(Integer.valueOf(s.replaceAll(",", "")));
        } catch (NumberFormatException e) {
            throw new CustomCubeException("Wrong string in parser.");
        }
        return cubeCoordinates;
    }

}



