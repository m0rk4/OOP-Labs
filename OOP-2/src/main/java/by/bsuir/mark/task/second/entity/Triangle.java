package by.bsuir.mark.task.second.entity;

public class Triangle extends Polygon {
    @Override
    public void setEndPoint(Point2D endPoint) {
        Point2D startPoint = super.getStartPoint();
        double middleX = Math.min(startPoint.getX(), endPoint.getX()) +
                Math.abs(startPoint.getX() - endPoint.getX()) / 2.0;
        Point2D top = new Point2D(middleX, endPoint.getY());
        Point2D right = new Point2D(endPoint.getX(), startPoint.getY());
        super.setPoints(top, startPoint, right);
    }
}
