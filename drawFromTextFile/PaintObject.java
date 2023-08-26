package drawFromTextFile;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

import Math.Point3;
import UtilsGraphs.UtilidadesGraficas;

public class PaintObject extends JPanel {
    public static final int WIDTH = UtilidadesGraficas.WIDTH;
    public static final int HEIGHT = UtilidadesGraficas.HEIGHT;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        UtilidadesGraficas.drawAxis(g);
        g.setColor(Color.BLACK);
        readFile("drawFromTextFile/house.txt", g);
    }

    public static void readFile(String fileName, Graphics g) {
        try {
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
                UtilidadesGraficas.myDrawLine(
                        g,
                        points[indice1].getX(),
                        points[indice1].getY(),
                        points[indice2].getX(),
                        points[indice2].getY());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
