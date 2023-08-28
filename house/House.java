package house;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

import Math.Matrix3x3;
import Math.Point3;
import UtilsGraphs.UtilidadesGraficas;

public class House extends JPanel {
    public static final int WIDTH = UtilidadesGraficas.WIDTH;
    public static final int HEIGHT = UtilidadesGraficas.HEIGHT;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        UtilidadesGraficas.drawAxis(g);
        g.setColor(Color.BLACK);
        readFile("house/house.txt", g);
    }

    public static void readFile(String fileName, Graphics g) {
        try {
            int matrix[][] = { { 1, 0, 100 }, { 0, 1, 50 }, { 0, 0, 1 } };
            Matrix3x3 multiplier = new Matrix3x3(matrix);
            Scanner scanner = new Scanner(new File(fileName));

            int numPoints = scanner.nextInt();

            Point3 points[] = new Point3[numPoints];

            for (int i = 1; i <= numPoints; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int w = 1;
                points[i - 1] = new Point3(x, y, w);
            }

            int numLines = scanner.nextInt();
            for (int i = 1; i <= numLines; i++) {
                int indice1 = scanner.nextInt();
                int indice2 = scanner.nextInt();
                g.setColor(Color.decode("#000"));
                // Original
                UtilidadesGraficas.myDrawLine(g,
                        points[indice1].getX(),
                        points[indice1].getY(),
                        points[indice2].getX(),
                        points[indice2].getY());
                g.setColor(Color.BLUE);

                // Traslated
                UtilidadesGraficas.myDrawLine(
                        g,
                        points[indice1].getX() + multiplier.getMatrix()[0][2],
                        points[indice1].getY() + multiplier.getMatrix()[1][2],
                        points[indice2].getX() + multiplier.getMatrix()[0][2],
                        points[indice2].getY() + multiplier.getMatrix()[1][2]);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
