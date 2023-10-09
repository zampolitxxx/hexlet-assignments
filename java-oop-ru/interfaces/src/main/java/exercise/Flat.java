package exercise;

// BEGIN
public class Flat implements Home {
    double area = 0;
    double balconyArea = 0;
    int floor = 0;
    double amountArea = 0;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
        this.amountArea = area + balconyArea;
    }
    @Override
    public double getArea() {
        return this.amountArea;
    }

    @Override
    public int compareTo(Home another) {
        double amountArea = this.amountArea;
        if (amountArea > another.getArea()) {
            return 1;
        } else if (amountArea < another.getArea()) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
}
// END
