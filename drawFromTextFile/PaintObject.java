package drawFromTextFile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import FileReader.FileReader;
import UtilsGraphs.UtilidadesGraficas;

public class PaintObject extends JPanel {
    public static final int WIDTH = UtilidadesGraficas.WIDTH;
    public static final int HEIGHT = UtilidadesGraficas.HEIGHT;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        UtilidadesGraficas.drawAxis(g);
        g.setColor(Color.BLACK);
        FileReader fileReader = new FileReader("drawFromTextFile/gancho.txt");
        paintFigure(g, fileReader);
    }

    public void paintFigure(Graphics g, FileReader fileReader) {
        for (int i = 0; i < fileReader.numLines; i++) {
            int indice1 = fileReader.fromPointToPoint[i][0];
            int indice2 = fileReader.fromPointToPoint[i][1];
            UtilidadesGraficas.myDrawLine(
                    g,
                    (int)fileReader.points[indice1].getX(),
                    (int)fileReader.points[indice1].getY(),
                    (int)fileReader.points[indice2].getX(),
                    (int)fileReader.points[indice2].getY());
        }
    }
}
