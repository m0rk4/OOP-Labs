package by.bsuir.mark.task.second.entity;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Polygon extends Figure {

    private List<Point2D> points;

    public Polygon(List<Point2D> points) {
        this.points = new ArrayList<>(points);
    }

    public Polygon(Point2D... points) {
        this.points = Arrays.asList(points);
    }

    public List<Point2D> getPoints() {
        return points;
    }

    public void setPoints(List<Point2D> points) {
        this.points = points;
    }

    public void setPoints(Point2D... points) {
        this.points = Arrays.asList(points);
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
