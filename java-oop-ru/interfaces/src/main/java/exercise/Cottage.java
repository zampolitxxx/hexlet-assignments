package exercise;

// BEGIN
public class Cottage implements Home {
    private double area = 0;
    private int floorCount = 0;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

    @Override
    public int compareTo(Home another) {
        double amountArea = this.area;
        if (amountArea > another.getArea()) {
            return 1;
        } else if (amountArea < another.getArea()) {
            return -1;
        } else return 0;
    }
}
// END
