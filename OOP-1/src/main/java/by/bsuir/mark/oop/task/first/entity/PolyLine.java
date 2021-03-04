package by.bsuir.mark.oop.task.first.entity;

import javafx.scene.canvas.GraphicsContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PolyLine extends OpenFigure {

    private final List<Point2D> points;

    public PolyLine(List<Point2D> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public PolyLine(Point2D... points) {
        List<Point2D> point2DList = Arrays.asList(points);
        this.points = Collections.unmodifiableList(point2DList);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        double[] xCoordinates = points.stream()
                .mapToDouble(Point2D::getX)
                .toArray();

        double[] yCoordinates = points.stream()
                .mapToDouble(Point2D::getY)
                .toArray();

        graphicsContext.strokePolyline(xCoordinates, yCoordinates, points.size());
    }
}
