package Math;

public class Vector3 {
    private double x, y, z;

    // constructor
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static Vector3 crossProduct(Vector3 v1, Vector3 v2) {
        // hacemos el producto cruz
        double x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
        double y = v1.getZ() * v2.getX() - v1.getX() * v2.getZ();
        double z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
        // creamos el vector resultante
        Vector3 result = new Vector3(x, y, z);
        return result;
    }

    public static double dotProduct(Vector3 v1, Vector3 v2) {
        // hacemos el producto punto
        double result = v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
        return result;
    }

    public double magnitude() {
        double result = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        return result;
    }

    public static Vector3 normalize(Vector3 v) {
        double magnitude = v.magnitude();
        double x = v.getX() / magnitude;
        double y = v.getY() / magnitude;
        double z = v.getZ() / magnitude;
        Vector3 result = new Vector3(x, y, z);
        return result;
    }

}