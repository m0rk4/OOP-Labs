package by.bsuir.mark.oop.task.first.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polyline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polygon extends ClosedFigure {

    private final List<Point2D> points;

    public Polygon(List<Point2D> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public Polygon(Point2D... points) {
        List<Point2D> point2DList = Arrays.asList(points);
        this.points = Collections.unmodifiableList(point2DList);
    }

    @Override
    public double getPerimeter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        double[] xCoordinates = points.stream()
                .mapToDouble(Point2D::getX)
                .toArray();

        double[] yCoordinates = points.stream()
                .mapToDouble(Point2D::getY)
                .toArray();

        graphicsContext.fillPolygon(xCoordinates, yCoordinates, points.size());
    }
}
