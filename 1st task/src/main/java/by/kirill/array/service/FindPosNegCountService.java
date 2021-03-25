package by.kirill.array.service;
import by.kirill.array.entity.ArrayPosNegCount;
import by.kirill.array.entity.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FindPosNegCountService {

    private static Logger logger = LogManager.getLogger();

    public ArrayPosNegCount countOfPositiveNegativeElements(CustomArray arr){
        logger.log(Level.DEBUG, "in countOfPositiveNegativeElements method");
        if(arr.getArray().length == 0){
            throw new IllegalArgumentException();
        }
        int posnumber = 0;
        int negnumber = 0;
        for(int i = 0; i<arr.getArray().length; i++){
            if(arr.getArray()[i] < 0){
                negnumber++;
            } else if(arr.getArray()[i] >0) {
                posnumber++;
            }
        }

        ArrayPosNegCount countofnumbers = new ArrayPosNegCount(posnumber, negnumber);
        logger.log(Level.INFO, String.format("\nCount of positive array numbers: %d\nCount of negative array numbers: %d", posnumber, negnumber));
        return countofnumbers;
    }

}
