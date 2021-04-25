package by.kirill.cube.validation;

import by.kirill.cube.entity.CustomCube;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomCubeValidator {

    private static Logger logger = LogManager.getLogger();

    public static boolean validateNotNullOrEmpty(CustomCube customCube) {
        if (customCube.getId() == 0 || customCube.getFirstPoint() == null || customCube.getSecondPoint() == null) {
            logger.log(Level.ERROR, "Incorrect CustomCube: cannot be null or empty");
            return false;
        }
        return true;
    }

}
