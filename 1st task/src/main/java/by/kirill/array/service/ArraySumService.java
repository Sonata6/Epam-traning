package by.kirill.array.service;
import by.kirill.array.entity.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySumService  {

    private static Logger logger = LogManager.getLogger();

    public long findSum(CustomArray arr)
    {
        logger.log(Level.DEBUG, "in findSum method");
        if(arr.getArray().length == 0){
            throw new IllegalArgumentException();
        }
        long sum = 0;
        for(int i = 0; i < arr.getArray().length; i++){
            sum += arr.getArray()[i];
        }
        if(sum == 0 ){
            logger.log(Level.ERROR, "Error in findSum method execution ");

        } else {
            logger.log(Level.INFO, String.format("sum of array elements: %d", sum));
        }
        return sum;
    }

}
