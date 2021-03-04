package by.bsuir.mark.oop.task.first.entity;

public class Rectangle extends Polygon {

    private final double width;
    private final double height;

    public Rectangle(Point2D topLeftPoint, double width, double height) {
        super(topLeftPoint, topLeftPoint.add(width, 0), topLeftPoint.add(width, height), topLeftPoint.add(0, height));
        this.height = height;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * (width + height);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
