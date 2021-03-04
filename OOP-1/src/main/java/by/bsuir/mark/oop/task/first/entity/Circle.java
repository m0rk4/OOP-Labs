package by.bsuir.mark.oop.task.first.entity;

public class Circle extends Ellipse {

    private final double radius;

    public Circle(Point2D center, double radius) {
        super(center, radius, radius);
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}
