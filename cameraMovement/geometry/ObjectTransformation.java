package cameraMovement.geometry;

import Math.Projection4x4;
import Math.TranslScalRot4x4;

public class ObjectTransformation {
    public double dx;
    public double dy;
    public double dz;
    public double sx;
    public double sy;
    public double sz;
    public double thetaX;
    public double thetaY;
    public double thetaZ;
    public double projectionDistance;
    public double centerX;
    public double centerY;
    public double centerZ;
    public double u;
    public double v;
    public double n;
    public double cameraX;
    public double cameraY;
    boolean cameraFollow;

    public static final double DELTA_TRANSL = 10;
    public static final double DELTA_SCAL = 0.1;
    public static final double DELTA_ROT = 10 * Math.PI / 180;

    public ObjectTransformation() {
        dx = 0;
        dy = 0;
        dz = 0;
        sx = 1;
        sy = 1;
        sz = 1;
        thetaX = 0;
        thetaY = 0;
        thetaZ = 0;
        projectionDistance = -500;
        centerX = 0;
        centerY = 0;
        centerZ = 0;
        u = 0;
        v = 0;
        n = 0;
        cameraX = 0;
        cameraY = 0;
        cameraFollow = false;
        
    }

    public TranslScalRot4x4 createTransformation() {
        TranslScalRot4x4 tsr = new TranslScalRot4x4(dx, dy, dz, 
        sx, sy, sz, 
        thetaX, thetaY, thetaZ,
        centerX, centerY, centerZ, 
        u, v, n,
        cameraX, cameraY, cameraFollow);
        return tsr;
    }

    public Projection4x4 createProjection() {
        Projection4x4 p = new Projection4x4(projectionDistance);
        return p;
    }

    public void reset() {
        dx = 0;
        dy = 0;
        dz = 0;
        sx = 1;
        sy = 1;
        sz = 1;
        thetaX = 0;
        thetaY = 0;
        thetaZ = 0;
        u = 0;
        v = 0;
        n = 0;
        cameraX = 0;
        cameraY = 0;
        cameraFollow = false;
    }

}
