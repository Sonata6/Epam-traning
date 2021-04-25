package by.kirill.cube.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Logger logger = LogManager.getLogger();


    private Map<Long, FigureParameters> map;
    private static Warehouse instance;

    public static Warehouse getInstance() {
        if(instance == null) {
            logger.log(Level.INFO, "creating singleton warehouse");
            instance = new Warehouse();
        }
        return instance;
    }

    private Warehouse() {
        this.map = new HashMap<>();
    }

    public FigureParameters get(Long id) {  //TODO return copy of map
        return map.get(id);
    }

    public Map<Long, FigureParameters> getMap() {
        return map;
    }

    public FigureParameters put(Long id, FigureParameters value) {
        return map.put(id, value);
    }

    public FigureParameters remove(Long id) {
        return map.remove(id);
    }

}
