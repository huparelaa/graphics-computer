package Math;

public class Scaling3x3 extends Matrix3x3{
    
    public Scaling3x3(double sx, double sy) {
        super();
        this.matrix[0][0] = sx;
        this.matrix[0][1] = 0;
        this.matrix[0][2] = 0;
        this.matrix[1][0] = 0;
        this.matrix[1][1] = sy;
        this.matrix[1][2] = 0;
        this.matrix[2][0] = 0;
        this.matrix[2][1] = 0;
        this.matrix[2][2] = 1;
    }
}
