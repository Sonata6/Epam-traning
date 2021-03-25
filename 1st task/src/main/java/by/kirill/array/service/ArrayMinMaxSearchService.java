package by.kirill.array.service;
import by.kirill.array.entity.ArrayMinMax;
import by.kirill.array.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.message.MapMessage;

public class ArrayMinMaxSearchService {

    private static Logger logger = LogManager.getLogger();

    public ArrayMinMax minMaxFind(CustomArray a)
    {
        //MapMessage mapMessage = new MapMessage().with("\nId", "LogMapMessageMain");
        logger.log(Level.DEBUG, "in minMaxFind method");
        if(a.getArray().length == 0){
            throw new IllegalArgumentException();
        }
        int min = a.getArray()[0];
        int max = a.getArray()[0];
        for(int i = 0; i < a.getArray().length; i++){
            if(a.getArray()[i] > max){
                max = a.getArray()[i];
            }
            if(a.getArray()[i] < min){
                min = a.getArray()[i];
            }
        }
        if(min == max){
            logger.log(Level.INFO, "Array consist of one element");
        }else {
            logger.log(Level.INFO, String.format("\nMin value of array: %d\nMax value of array: %d", min, max));
        }
        ArrayMinMax minmax = new ArrayMinMax(min, max);

        return minmax;
    }

}