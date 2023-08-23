package Math;

public class Vector3 {
    private int x, y, z;

    // constructor
    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public static Vector3 crossProduct(Vector3 v1, Vector3 v2) {
        // hacemos el producto cruz
        int x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
        int y = v1.getZ() * v2.getX() - v1.getX() * v2.getZ();
        int z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
        // creamos el vector resultante
        Vector3 result = new Vector3(x, y, z);
        return result;
    }

    public static int dotProduct(Vector3 v1, Vector3 v2) {
        // hacemos el producto punto
        int result = v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
        return result;
    }

    public double magnitude(){
        double result = Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
        return result;
    }

    public static Vector3 normalize(Vector3 v){
        double magnitude = v.magnitude();
        int x = (int) (v.getX() / magnitude);
        int y = (int) (v.getY() / magnitude);
        int z = (int) (v.getZ() / magnitude);
        Vector3 result = new Vector3(x, y, z);
        return result;
    }

}