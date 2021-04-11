package by.kirill.cube.parser;

import by.kirill.cube.exception.CustomCubeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomCubeParser {
    //handles numbers, which separate by " ", " - ", ", ".

    private static Logger logger = LogManager.getLogger();

    public int[] stringParser(String customArrayStr) throws CustomCubeException {
        if(customArrayStr == null) {
            logger.log(Level.ERROR, "stringParser got null parameter.");
            throw new CustomCubeException("Input string is null.");
        }
        char charArray[] = customArrayStr.toCharArray();
        CustomCubeParser parser = new CustomCubeParser();
        boolean flag = false;
        int lenght = parser.findNumberOfElements(charArray);
        int actualArray[] = new int[lenght];
        int index = lenght - 1;
        int ten = 10;
        int order = 0;
        int degree = 1;
        int number;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (Character.isDigit(charArray[i])) {
                number = (int) charArray[i] - '0';
                if (order != 0) {
                    degree *= ten;
                }
                flag = true;
                order++;
                number *= degree;
                actualArray[index] += number;
            }
            if (flag & charArray[i] == '-') {
                actualArray[index] *= -1;
                index--;
                order = 0;
                degree = 1;
                flag = false;
            }
            if (charArray[i] == ' ' & flag) {
                index--;
                order = 0;
                degree = 1;
                flag = false;
            }
        }
        return actualArray;
    }

    public int findNumberOfElements(char[] charArray) {
        int lenght = 0;
        boolean flag = false;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (Character.isDigit(charArray[i])) {
                flag = true;
            } else if (flag == true) {
                flag = false;
                lenght++;
            }
        }
        lenght++;
        return lenght;
    }
}
