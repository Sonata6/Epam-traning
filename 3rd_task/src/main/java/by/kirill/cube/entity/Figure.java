package by.kirill.cube.entity;

import by.kirill.cube.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Figure {
    private static Logger logger = LogManager.getRootLogger();
    private long id;

    protected Figure() {
        this.id = IdGenerator.generateNextId();
    }

    protected Figure(Figure figure) {
        this.id = figure.id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Figure other = (Figure) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AbstractFigure [id=");
        builder.append(id);
        builder.append("]");
        return builder.toString();
    }

}
