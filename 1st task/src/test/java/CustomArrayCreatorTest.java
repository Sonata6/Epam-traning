import by.kirill.array.creator.CustomArrayCreator;
import by.kirill.array.entity.CustomArray;
import by.kirill.array.exception.CustomArrayException;
import by.kirill.array.service.FindArrayAverageService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomArrayCreatorTest {
    @Test
    public void createArrayTest() throws CustomArrayException {

        CustomArrayCreator create = new CustomArrayCreator();
        create.customArrayCreator();

    }
}
