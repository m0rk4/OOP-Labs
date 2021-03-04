package by.bsuir.mark.oop.task.first.entity;

import javafx.scene.canvas.GraphicsContext;

public class Ellipse extends ClosedFigure {

    private final Point2D center;
    private final double xHalfAxis;
    private final double yHalfAxis;

    public Ellipse(Point2D center, double xHalfAxis, double yHalfAxis) {
        this.center = center;
        this.xHalfAxis = xHalfAxis;
        this.yHalfAxis = yHalfAxis;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((xHalfAxis * xHalfAxis + yHalfAxis * yHalfAxis) / 2.0);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.fillOval(center.getX() , center.getY() , xHalfAxis, yHalfAxis);
    }
}
