package by.bsuir.mark.task.second.entity;

public class Square extends Rectangle {
    @Override
    public void setEndPoint(Point2D endPoint) {
        Point2D startPoint = super.getStartPoint();
        double dx = startPoint.getX() - endPoint.getX();
        double dy = startPoint.getY() - endPoint.getY();
        double absDy = Math.abs(dy);
        double absDx = Math.abs(dx);
        if (absDx > absDy) {
            endPoint = new Point2D(
                    dx > 0 ? startPoint.getX() - absDy : startPoint.getX() + absDy,
                    endPoint.getY());
        } else {
            endPoint = new Point2D(
                    endPoint.getX(),
                    dy > 0 ? startPoint.getY() - absDx : startPoint.getY() + absDx);
        }
        super.setEndPoint(endPoint);
    }
}
