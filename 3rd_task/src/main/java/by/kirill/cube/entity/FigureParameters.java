package by.kirill.cube.entity;

public class FigureParameters {

    private double volume;
    private double surfaceArea;

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FigureParameters that = (FigureParameters) o;
        return Double.compare(that.surfaceArea, surfaceArea) == 0 &&
                Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = (int) surfaceArea;
        result = 31 * result + (int) volume;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FigureParameters{");
        sb.append("surfaceArea=").append(surfaceArea);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }
}
