package by.kirill.cube.util;

public class IdGenerator {

    private static int counter;

    private IdGenerator() {
    }

    public static int generateNextId() {
        counter++;
        return counter;
    }

}
