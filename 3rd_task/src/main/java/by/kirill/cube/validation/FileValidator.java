package by.kirill.cube.validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class FileValidator {

    private static final String CORRECT_REGULAR_CUBE = "^-?\\d{1,10}((,)?(\\s)(-?)\\d{1,10}){5}$";

    public static boolean
    validateString(String line) {
        boolean resultRegularPyramid = Pattern.matches(CORRECT_REGULAR_CUBE, line);
        //boolean resultRegularPolygon = Pattern.matches(CORRECT_REGULAR_POLYGON, line);
        return resultRegularPyramid;
        // || resultRegularPolygon;
    }

    public static boolean validateFilePath(Path path) {
        return !Files.notExists(path);
    }

}
