package Math;

public class Point3 {
    private double x, y, w;

    // constructor
    public Point3(double x, double y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    // getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    // setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setW(double w) {
        this.w = w;
    }
}