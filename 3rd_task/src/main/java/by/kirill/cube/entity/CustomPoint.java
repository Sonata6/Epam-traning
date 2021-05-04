package by.kirill.cube.entity;

public class CustomPoint {

    private int x;
    private int y;
    private int z;


    public CustomPoint() {

        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public CustomPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomPoint that = (CustomPoint) o;
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {

        return (x >> 16) ^ (y >> 8) ^ z;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Point: [x=");
        stringBuilder.append(x);
        stringBuilder.append(", y=");
        stringBuilder.append(y);
        stringBuilder.append(", z=");
        stringBuilder.append(z);
        stringBuilder.append("]");
        String result = stringBuilder.toString();
        return result;
    }
}
