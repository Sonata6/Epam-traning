package by.kirill.array.validation;

import by.kirill.array.entity.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomArrayValidator {

    private static Logger logger = LogManager.getLogger();

    public static boolean validateNotNullOrEmpty(CustomArray customArray) {
        if (customArray.getArray() == null || customArray.getArray().length == 0) {
            logger.log(Level.ERROR, "incorrect CustomArray: cannot be null or empty");
            return false;
        }
        return true;
    }

    public static boolean validateString(String line) {
        Pattern pattern = Pattern.compile("^-?\\d{1,10}(((\\s-)|(,))?(\\s)(-?)\\d{1,10})*$");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public static boolean validateFilePath(Path path) {

        return !Files.notExists(path);
    }
}
