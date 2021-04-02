package by.kirill.array.validation;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomArrayValidator {

    public static void validateNotNullOrEmpty(CustomArray customArray) throws CustomArrayException {
        if (customArray.getArray() == null) {
            throw new CustomArrayException("incorrect CustomArray: cannot be null");
        }
        if (customArray.getArray().length == 0) {
            throw new CustomArrayException("CustomArray is empty");
        }
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
