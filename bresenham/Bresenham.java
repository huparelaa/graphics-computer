package bresenham;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import UtilsGraphs.UtilidadesGraficas;

public class Bresenham extends JPanel {
    public static final int WIDTH = UtilidadesGraficas.WIDTH;
    public static final int HEIGHT = UtilidadesGraficas.HEIGHT;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        UtilidadesGraficas.drawAxis(g);
        int radio = 100;
        int step = 20;
        drawWheel(g, radio, step);

    }

    private void drawWheel(Graphics g, int radio, int step) {
        g.setColor(Color.blue);

        // primer octante
        for (int y2 = 0; y2 <= radio; y2 += step) {
            int x2 = (int) Math.sqrt(radio * radio - y2 * y2);
            drawLine(g, 0, 0, x2, y2);
        }
        // segundo octante
        for (int x2 = 0; x2 <= radio; x2 += step) {
            int y2 = (int) Math.sqrt(radio * radio - x2 * x2);
            drawLine(g, 0, 0, x2, y2);
        }
        // tercer octante
        for (int x2 = 0; x2 <= radio; x2 += step) {
            int y2 = (int) Math.sqrt(radio * radio - x2 * x2);
            drawLine(g, 0, 0, x2, -y2);
        }
        // cuarto octante
        for (int y2 = 0; y2 <= radio; y2 += step) {
            int x2 = (int) Math.sqrt(radio * radio - y2 * y2);
            drawLine(g, 0, 0, -x2, y2);
        }
        // quinto octante
        for (int y2 = 0; y2 <= radio; y2 += step) {
            int x2 = (int) Math.sqrt(radio * radio - y2 * y2);
            drawLine(g, 0, 0, -x2, -y2);
        }
        // sexto octante
        for (int x2 = 0; x2 <= radio; x2 += step) {
            int y2 = (int) Math.sqrt(radio * radio - x2 * x2);
            drawLine(g, 0, 0, -x2, -y2);
        }
        // septimo octante
        for (int x2 = 0; x2 <= radio; x2 += step) {
            int y2 = (int) Math.sqrt(radio * radio - x2 * x2);
            drawLine(g, 0, 0, -x2, y2);
        }
        // octavo octante
        for (int y2 = 0; y2 <= radio; y2 += step) {
            int x2 = (int) Math.sqrt(radio * radio - y2 * y2);
            drawLine(g, 0, 0, x2, -y2);
        }
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        // delta of exact value and rounded value of the dependent variable
        int d = 0;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;

        int x = x1;
        int y = y1;

        if (dx >= dy) {
            while (true) {
                // draw the point
                UtilidadesGraficas.myDrawPoint(g, x, y);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                // draw the point
                UtilidadesGraficas.myDrawPoint(g, x, y);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }

    
}
