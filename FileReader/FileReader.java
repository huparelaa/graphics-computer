package FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Math.Point3;

public class FileReader {
    public Point3 points[];
    public int numLines;
    public int numPoints;
    // saving as [[x1, y1], [x2, y2], ...
    public int[][] fromPointToPoint;

    public FileReader(String fileName) {
        readFile(fileName);
    }

    public void readFile(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));

            numPoints = scanner.nextInt();

            points = new Point3[numPoints];

            for (int i = 1; i <= numPoints; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int w = 1;
                points[i - 1] = new Point3(x, y, w);
            }

            numLines = scanner.nextInt();
            fromPointToPoint = new int[numLines][2];
            for (int i = 1; i <= numLines; i++) {
                int indice1 = scanner.nextInt();
                int indice2 = scanner.nextInt();
                fromPointToPoint[i - 1][0] = indice1;
                fromPointToPoint[i - 1][1] = indice2;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}