package by.kirill.cube.entity;


public class CustomCube {

    private String id;
    private CustomPoint a;
    private CustomPoint b;
    private CustomPoint c;
    private CustomPoint d;
    private CustomPoint a1;
    private CustomPoint b1;
    private CustomPoint c1;
    private CustomPoint d1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomPoint getA() {
        return a;
    }

    public void setA(CustomPoint a) {
        this.a = a;
    }

    public CustomPoint getB() {
        return b;
    }

    public void setB(CustomPoint b) {
        this.b = b;
    }

    public CustomPoint getC() {
        return c;
    }

    public void setC(CustomPoint c) {
        this.c = c;
    }

    public CustomPoint getD() {
        return d;
    }

    public void setD(CustomPoint d) {
        this.d = d;
    }

    public CustomPoint getA1() {
        return a1;
    }

    public void setA1(CustomPoint a1) {
        this.a1 = a1;
    }

    public CustomPoint getB1() {
        return b1;
    }

    public void setB1(CustomPoint b1) {
        this.b1 = b1;
    }

    public CustomPoint getC1() {
        return c1;
    }

    public void setC1(CustomPoint c1) {
        this.c1 = c1;
    }

    public CustomPoint getD1() {
        return d1;
    }

    public void setD1(CustomPoint d1) {
        this.d1 = d1;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CustomCube that = (CustomCube) o;
//        return Objects.equals(id, that.id) && Objects.equals(a, that.a) && Objects.equals(b, that.b) && Objects.equals(c, that.c) && Objects.equals(d, that.d) && Objects.equals(a1, that.a1) && Objects.equals(b1, that.b1) && Objects.equals(c1, that.c1) && Objects.equals(d1, that.d1);
//    }

    @Override
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        int result = 31 * (a.getX() + b.getY() + c.getZ() + a1.getZ() +
                b1.getY() + c1.getX()) + Integer.parseInt(id);
        return result;
    }

    @Override
    public String
    toString() {
        return "CustomCube{" +
                "id='" + id + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", a1=" + a1 +
                ", b1=" + b1 +
                ", c1=" + c1 +
                ", d1=" + d1 +
                '}';
    }
}
