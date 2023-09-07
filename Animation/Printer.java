package Animation;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import FileReader.FileReader;
import Math.Matrix3x3;
import Math.TranslScalRot3x3;
import UtilsGraphs.UtilidadesGraficas;

public class Printer extends JPanel {
    public static final int WIDTH = UtilidadesGraficas.WIDTH;
    public static final int HEIGHT = UtilidadesGraficas.HEIGHT;
    public static FileReader fileReader = new FileReader("house.txt");

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        UtilidadesGraficas.drawAxis(g);
        g.setColor(Color.BLACK);

        paintFigure(g);
    }

    // Paint the house
    public void paintFigure(Graphics g) {
        for (int i = 0; i < fileReader.numLines; i++) {
            int indice1 = fileReader.fromPointToPoint[i][0];
            int indice2 = fileReader.fromPointToPoint[i][1];
            UtilidadesGraficas.myDrawLine(
                    g,
                    (int) fileReader.points[indice1].getX(),
                    (int) fileReader.points[indice1].getY(),
                    (int) fileReader.points[indice2].getX(),
                    (int) fileReader.points[indice2].getY());
        }
    }

    public void applyTransformation(Graphics g, TranslScalRot3x3 transformation) {
        Matrix3x3 matrix = new Matrix3x3(transformation.getMatrix());
        for (int i = 0; i < fileReader.numPoints; i++) {
            fileReader.points[i] = Matrix3x3.times(matrix, fileReader.points[i]);
        }
    }

    public void restart() {
        FileReader fileReader2 = new FileReader("house.txt");
        // replacing the points
        for(int i = 0; i < fileReader.numPoints; i++) {
            fileReader.points[i] = fileReader2.points[i];
        }
    }

}
