package by.kirill.cube.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static Logger logger = LogManager.getLogger();


    private Map<Long, FigureParameter> map;
    private static Warehouse instance;

    public static Warehouse getInstance() {
        if (instance == null) {
            logger.log(Level.INFO, "creating singleton warehouse");
            instance = new Warehouse();
        }
        return instance;
    }

    private Warehouse() {
        this.map = new HashMap<>();
    }

    public FigureParameter get(Long id) {  //TODO return copy of map

        return map.get(id);
    }

    public Map<Long, FigureParameter> getMap() {
        return map;
    }

    public FigureParameter put(Long id, FigureParameter value) {
        return map.put(id, value);
    }

    public FigureParameter remove(Long id) {
        return map.remove(id);
    }

}
