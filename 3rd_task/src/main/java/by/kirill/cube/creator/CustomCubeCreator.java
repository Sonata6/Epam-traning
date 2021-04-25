package by.kirill.cube.creator;

import by.kirill.cube.action.CubeCalculateAction;
import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import by.kirill.cube.entity.FigureParameters;
import by.kirill.cube.entity.Warehouse;
import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.factory.FigureFactory;
import by.kirill.cube.repository.Repository;

public class CustomCubeCreator {

    public void fillRepositoryWithCone(CustomPoint firstPoint, CustomPoint secondPoint) throws CustomCubeException {
        CustomCube cube = FigureFactory.getCubeFromFactory(firstPoint, secondPoint);
        createWarehouse(cube);
        Repository repository = Repository.getInstance();
        repository.add(cube);
    }

    public void fillRepositoryWithCone(int x1, int y1, int z1, int x2, int y2, int z2)
            throws CustomCubeException {
        CustomCube cone = FigureFactory.getCubeFromFactory(x1, y1, z1,x2,y2,z2);
        createWarehouse(cone);
        Repository repository = Repository.getInstance();
        repository.add(cone);
    }

    public void fillRepositoryWithCone(int[] array)
            throws CustomCubeException {
        CustomCube cube = FigureFactory.getCubeFromFactory(array);
        createWarehouse(cube);
        Repository repository = Repository.getInstance();
        repository.add(cube);
    }

    private void createWarehouse(CustomCube cube) throws CustomCubeException {
        long id = cube.getId();
        Warehouse warehouse = Warehouse.getInstance();
        CubeCalculateAction cubeAction = new CubeCalculateAction();
        double surfaceArea = cubeAction.calculateArea(cube);
        double volume = cubeAction.calculateVolume(cube);
        FigureParameters figureParameters = new FigureParameters();
        figureParameters.setSurfaceArea(surfaceArea);
        figureParameters.setVolume(volume);
        warehouse.put(id, figureParameters);
    }

}
