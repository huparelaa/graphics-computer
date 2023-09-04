package Math;

public class Rotation3x3 extends Matrix3x3{
    
    public Rotation3x3(double theta){
        super();
        this.matrix[0][0] = Math.cos(theta);
        this.matrix[0][1] = -Math.sin(theta);
        this.matrix[0][2] = 0;
        this.matrix[1][0] = Math.sin(theta);
        this.matrix[1][1] = Math.cos(theta);
        this.matrix[1][2] = 0;
        this.matrix[2][0] = 0;
        this.matrix[2][1] = 0;
        this.matrix[2][2] = 1;
    }

}
