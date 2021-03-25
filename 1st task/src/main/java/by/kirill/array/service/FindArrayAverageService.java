package by.kirill.array.service;
import by.kirill.array.entity.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class FindArrayAverageService {

    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    public float findAverage(CustomArray a)
    {
        logger.log(Level.DEBUG, "in findAverage method");
        if(a.getArray().length == 0){
            logger.log(Level.DEBUG, "Array is empty");
        }
        long sum = 0;
        float average;
        for(int i = 0; i < a.getArray().length; i++){
            sum+=a.getArray()[i];
        }
        average = (float)sum/a.getArray().length;

        logger.log(Level.INFO, String.format("average array number: %f", average));

        return average;
    }

}
