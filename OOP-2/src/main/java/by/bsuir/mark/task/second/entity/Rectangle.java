package by.bsuir.mark.task.second.entity;

public class Rectangle extends Polygon {
    @Override
    public void setEndPoint(Point2D endPoint) {
        Point2D startPoint = super.getStartPoint();
        super.setPoints(startPoint,
                new Point2D(startPoint.getX(), endPoint.getY()),
                endPoint,
                new Point2D(endPoint.getX(), startPoint.getY()));
    }
}
