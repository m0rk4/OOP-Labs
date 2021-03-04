package by.bsuir.mark.task.second.entity;

import javafx.scene.canvas.GraphicsContext;

public class Ellipse extends Figure {
    @Override
    public void draw(GraphicsContext graphicsContext) {
        Point2D startPoint = super.getStartPoint();
        Point2D endPoint = super.getEndPoint();
        double dx = startPoint.getX() - endPoint.getX();
        double dy = startPoint.getY() - endPoint.getY();
        double absDx = Math.abs(dx);
        double absDy = Math.abs(dy);
        graphicsContext.fillOval(
                dx > 0 ? startPoint.getX() - absDx : startPoint.getX(),
                dy > 0 ? startPoint.getY() - absDy : startPoint.getY(),
                absDx,
                absDy
        );
    }
}
