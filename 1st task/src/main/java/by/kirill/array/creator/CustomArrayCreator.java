package by.kirill.array.creator;

import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.parser.CustomArrayParser;
import by.kirill.array.reader.CustomArrayReader;
import by.kirill.array.validation.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayCreator {

    private static Logger logger = LogManager.getLogger();

    public CustomArray customArrayCreator() throws CustomArrayException {

        CustomArrayReader reader = new CustomArrayReader();
        String filepath = "D://my projects//Epam courses//1st task//info.txt";
        String actualstring = reader.readFromFile(filepath);
        logger.log(Level.INFO, "actual array: " + actualstring);
        CustomArrayParser parser = new CustomArrayParser();
        int actualarray[] = parser.stringParser(actualstring);
        CustomArray customarray = new CustomArray(actualarray);
        CustomArrayValidator validator = new CustomArrayValidator();
        validator.validateNotNullOrEmpty(customarray);
        return customarray;
    }
}