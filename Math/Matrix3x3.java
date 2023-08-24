package Math;

public class Matrix3x3 {

    // matrix3x3 setup
    private double[][] matrix = new double[3][3];

    // constructor
    public Matrix3x3(double[][] matrix) {
        this.matrix = matrix;
    }

    // getters
    public double[][] getMatrix() {
        return matrix;
    }

    // setters
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    // methods
    public static Point3 times(Matrix3x3 matrix, Point3 point) {
        double[][] matrixArray = matrix.getMatrix();
        double[] pointArray = { point.getX(), point.getY(), point.getW() };
        double[] resultArray = new double[3];
        for (int i = 0; i < 3; i++) {
            double result = 0;
            for (int j = 0; j < 3; j++) {
                result += matrixArray[i][j] * pointArray[j];
            }
            resultArray[i] = result;
        }
        Point3 resultPodouble = new Point3(resultArray[0], resultArray[1], resultArray[2]);
        return resultPodouble;
    }

    public static Matrix3x3 times(Matrix3x3 matrix1, Matrix3x3 matrix2) {
        double[][] matrix1Array = matrix1.getMatrix();
        double[][] matrix2Array = matrix2.getMatrix();
        double[][] resultArray = new double[3][3];
        for (int i = 0; i < 3; i++) {
            double[] result = new double[3];
            for (int j = 0; j < 3; j++) {
                double resultdouble = 0;
                for (int k = 0; k < 3; k++) {
                    resultdouble += matrix1Array[i][k] * matrix2Array[k][j];
                }
                result[j] = resultdouble;
            }
            resultArray[i] = result;
        }
        Matrix3x3 resultMatrix = new Matrix3x3(resultArray);
        return resultMatrix;
    }
}
