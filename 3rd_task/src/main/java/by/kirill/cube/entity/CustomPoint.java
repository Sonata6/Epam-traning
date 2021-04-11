package by.kirill.cube.entity;

import java.util.Objects;

public class CustomPoint {
    private String id;
    private int x;
    private int y;
    private int z;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomPoint that = (CustomPoint) o;
        return x == that.x && y == that.y && z == that.z && Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "CustomPoint{" +
                "id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        int result = 31 * (x+y+z) + Integer.parseInt(id);
        return result;
    }

    public CustomPoint() {
        this.id = null;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public CustomPoint(String id, int x, int y, int z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
