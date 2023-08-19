package UtilsGraphs;

import java.awt.Color;
import java.awt.Graphics;

public class UtilidadesGraficas {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    public static void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        myDrawLine(g, -300, 0, 300, 0);
        myDrawLine(g, 0, -300, 0, 300);
    }

    public static void myDrawPoint(Graphics g, int x, int y) {
        int xj = x + WIDTH / 2;
        int yj = HEIGHT / 2 - y;
        g.drawLine(xj, yj, xj, yj);
    }

    public static void myDrawLine(Graphics g, int x1, int y1, int x2, int y2) {
        int xj1 = x1 + WIDTH / 2;
        int yj1 = HEIGHT / 2 - y1;
        int xj2 = x2 + WIDTH / 2;
        int yj2 = HEIGHT / 2 - y2;
        g.drawLine(xj1, yj1, xj2, yj2);
    }
}
