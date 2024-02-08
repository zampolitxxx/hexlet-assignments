package exercise;

// BEGIN
public class Segment {
    Point a;
    Point b;

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getBeginPoint() {
        return a;
    }

    public Point getEndPoint() {
        return b;
    }

    public Point getMidPoint() {
        int xMidle = (a.getX() + b.getX()) / 2;
        int yMidle = (a.getY() + b.getY()) / 2;
        Point midle = new Point(xMidle, yMidle);
        return midle;
    }
}
// END
