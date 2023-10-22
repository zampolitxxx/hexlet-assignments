package exercise;

// BEGIN
public class Circle {
    private int radius;
    private Point center;

    public Circle(Point center, int radius) {
        this.radius = radius;
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }
    public double getSquare() throws NegativeRadiusException {
        double Square = Math.PI * radius * radius;
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return Square;
    }
}
// END
