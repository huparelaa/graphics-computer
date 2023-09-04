package Animation;

import Math.Point3;
import FileReader.FileReader;

public class CalcTransforms {
    public static FileReader fileReader = Printer.fileReader;
    public static Point3[] newPoints = new Point3[fileReader.points.length];

    public static Point3 calculateObjectCenter() {
        double centerX = 0;
        double centerY = 0;
        for (int i = 0; i < fileReader.points.length; i++) {
            centerX += fileReader.points[i].getX();
            centerY += fileReader.points[i].getY();
        }
        centerX /= fileReader.points.length;
        centerY /= fileReader.points.length;
        return new Point3(centerX, centerY, 1);
    }

    public static void bringPointsToCenter(Point3 center) {
        for (int i = 0; i < fileReader.points.length; i++) {
            fileReader.points[i].setX(fileReader.points[i].getX() - center.getX());
            fileReader.points[i].setY(fileReader.points[i].getY() - center.getY());
        }
    }

    public static void returnPointsToOriginalPosition(Point3 center) {
        for (int i = 0; i < fileReader.points.length; i++) {
            fileReader.points[i].setX(fileReader.points[i].getX() + center.getX());
            fileReader.points[i].setY(fileReader.points[i].getY() + center.getY());
        }
    }
}
