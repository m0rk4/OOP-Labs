package by.bsuir.mark.oop.task.first.entity;


import java.util.Objects;

public class Point2D {

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public Point2D add(double x, double y) {
        return new Point2D(
                getX() + x,
                getY() + y);
    }

    public Point2D add(Point2D point) {
        return add(point.getX(), point.getY());
    }

    public Point2D subtract(double x, double y) {
        return new Point2D(
                getX() - x,
                getY() - y);
    }


    public Point2D subtract(Point2D point) {
        return subtract(point.getX(), point.getY());
    }

    public final double getX() {
        return x;
    }


    public final double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, x) == 0 &&
                Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point2D{x=" + x + ",y =" + y + "}";
    }
}
