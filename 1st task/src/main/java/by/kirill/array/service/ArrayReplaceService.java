package by.kirill.array.service;
import by.kirill.array.entity.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReplaceService{

    private static Logger logger = LogManager.getLogger();

    public void replaceNumbers(CustomArray arr)
    {
        logger.log(Level.DEBUG, "in replaceNumbers method");
        if(arr.getArray().length == 0){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i<arr.getArray().length; i++){
            if(arr.getArray()[i] < 0){
                arr.setElement(i, -1);
            }
        }
        logger.log(Level.INFO, "replaceNumbers method finished successfully");
    }
}
