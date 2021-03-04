package by.bsuir.mark.task.second.entity;

import javafx.scene.canvas.GraphicsContext;

public abstract class Figure {

    private Point2D startPoint;
    private Point2D endPoint;

    public Point2D getEndPoint() {
        return endPoint;
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }

    public abstract void draw(GraphicsContext graphicsContext);
}
