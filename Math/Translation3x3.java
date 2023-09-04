package Math;

public class Translation3x3 extends Matrix3x3 {

    public Translation3x3(double dx, double dy) {
        super();
        this.matrix[0][0] = 1;
        this.matrix[0][1] = 0;
        this.matrix[0][2] = dx;
        this.matrix[1][0] = 0;
        this.matrix[1][1] = 1;
        this.matrix[1][2] = dy;
        this.matrix[2][0] = 0;
        this.matrix[2][1] = 0;
        this.matrix[2][2] = 1;
    }
}
