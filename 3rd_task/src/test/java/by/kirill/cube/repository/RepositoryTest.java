package by.kirill.cube.repository;

import by.kirill.cube.entity.CustomCube;
import by.kirill.cube.entity.CustomPoint;
import by.kirill.cube.exception.CustomCubeException;
import by.kirill.cube.repository.Impl.IdSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class RepositoryTest {

    private CustomCube firstCube;
    private CustomCube secondCube;
    private Repository cubeRepository;

    @BeforeSuite
    public void figuresCreationAndSetup() {
        cubeRepository = Repository.getInstance();
        firstCube = new CustomCube(new CustomPoint(0, 0, 0), new CustomPoint(4, 4, 4));
        firstCube.setId(1);
        secondCube = new CustomCube(new CustomPoint(1, 1, 1), new CustomPoint(5, 5, 5));
        secondCube.setId(5);
    }

    @BeforeTest
    public void repositorySetup() {
        cubeRepository.clear();
        cubeRepository.add(firstCube);
        cubeRepository.add(secondCube);
    }

    @Test
    public void linkTest() {
        Repository repository = Repository.getInstance();
        CustomCube copy = repository.get(0);
        CustomCube original = firstCube;
        boolean expected = true;
        boolean actual = original.equals(copy)
                && original == copy
                && original.getFirstPoint().getX() == copy.getFirstPoint().getX()
                && original.getSecondPoint().getX() == copy.getSecondPoint().getX();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void correctInitTest() {
        int expected = cubeRepository.size();
        int actual = 2;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void queryStreamIdSpecificationTest() {
        IdSpecification specification = new IdSpecification(1);
        String expected = "[1]";
        String actual = cubeRepository.queryStream(specification).stream().map(CustomCube::getId)
                .collect(Collectors.toList()).toString();
        Assert.assertEquals(actual, expected);
    }
}
