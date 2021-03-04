package by.bsuir.mark.oop.task.first.entity;

public class Square extends Rectangle {
    private final double sideLength;

    public Square(Point2D topLeftPoint, double sideLength) {
        super(topLeftPoint, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}
