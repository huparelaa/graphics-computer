package Math;

public class Matrix3x3 {
    
    //matrix3x3 setup
    private int[][] matrix = new int[3][3];

    //constructor
    public Matrix3x3(int[][] matrix) {
        this.matrix = matrix;
    }

    //getters
    public int[][] getMatrix() {
        return matrix;
    }

    //setters
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    //methods
    public static Point3 times(Matrix3x3 matrix, Point3 point) {
        int[][] matrixArray = matrix.getMatrix();
        int[] pointArray = {point.getX(), point.getY(), point.getW()};
        int[] resultArray = new int[3];
        for (int i = 0; i < 3; i++) {
            int result = 0;
            for (int j = 0; j < 3; j++) {
                result += matrixArray[i][j] * pointArray[j];
            }
            resultArray[i] = result;
        }
        Point3 resultPoint = new Point3(resultArray[0], resultArray[1], resultArray[2]);
        return resultPoint;
    }

    public static Matrix3x3 times(Matrix3x3 matrix1, Matrix3x3 matrix2){
        int[][] matrix1Array = matrix1.getMatrix();
        int[][] matrix2Array = matrix2.getMatrix();
        int[][] resultArray = new int[3][3];
        for (int i = 0; i < 3; i++) {
            int[] result = new int[3];
            for (int j = 0; j < 3; j++) {
                int resultInt = 0;
                for (int k = 0; k < 3; k++) {
                    resultInt += matrix1Array[i][k] * matrix2Array[k][j];
                }
                result[j] = resultInt;
            }
            resultArray[i] = result;
        }
        Matrix3x3 resultMatrix = new Matrix3x3(resultArray);
        return resultMatrix;
    }
}
