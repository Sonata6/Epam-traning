package by.kirill.cube.util;

public class IdGenerator {

    private static int counter;

    private IdGenerator() {
    }

    public static int generateNextId() {
        counter = counter + 1;
        return counter;
    }

}
