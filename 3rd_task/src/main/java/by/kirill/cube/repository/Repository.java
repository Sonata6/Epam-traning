package by.kirill.cube.repository;

import by.kirill.cube.entity.CustomCube;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {

    private static Logger logger = LogManager.getLogger();

    private List<CustomCube> customCubeList;
    private static Repository instance;

    private Repository() {
        customCubeList = new ArrayList<>();
    }

    public static Repository getInstance() {

        if (instance == null) {
            logger.info("creating singleton repository");
            instance = new Repository();
        }
        return instance;
    }

    public List<CustomCube> getCustomCubes() {
        List<CustomCube> result = new ArrayList<>(customCubeList);
        return result;
    }

    public boolean add(CustomCube cube) {
        return customCubeList.add(cube);
    }

    public boolean addAll(Collection<? extends CustomCube> cube) {
        return customCubeList.addAll(cube);
    }

    public boolean remove(CustomCube element) {
        return customCubeList.remove(element);
    }

    public boolean removeAll(Collection<CustomCube> cube) {
        return customCubeList.removeAll(cube);
    }

    public void clear() {
        customCubeList.clear();
    }

    public int size() {
        return customCubeList.size();
    }

    public CustomCube get(int index) {
        return customCubeList.get(index);
    }

    public CustomCube set(int index, CustomCube element) {
        return customCubeList.set(index, element);
    }

    public List<CustomCube> query(Specification specification) {
        List<CustomCube> result = new ArrayList<>();
        for (CustomCube cube : customCubeList) {
            if (specification.specify(cube)) {
                result.add(cube);
            }
        }
        return result;
    }

    public List<CustomCube> queryStream(Specification specification) {
        return customCubeList.stream().filter(specification::specify).collect(Collectors.toList());
    }

    public List<CustomCube> sort(Comparator<? super CustomCube> comparator) {
        return customCubeList.stream().sorted(comparator).collect(Collectors.toList());
    }
}
