package by.bsuir.mark.task.second.entity;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Figure{
    @Override
    public void draw(GraphicsContext graphicsContext) {
        Point2D startPoint = super.getStartPoint();
        Point2D endPoint = super.getEndPoint();
        graphicsContext.strokeLine(startPoint.getX(), startPoint.getY(),
                endPoint.getX(), endPoint.getY());
    }
}
