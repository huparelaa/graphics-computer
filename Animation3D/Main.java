package Animation3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UtilsGraphs.UtilidadesGraficas;

public class Main extends JPanel implements KeyListener {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    Graphics g;

    PolygonObject po;

    public Main() {
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        super.paintComponent(g);

        this.g = g;

        UtilidadesGraficas.drawAxis(g);
        g.setColor(Color.BLACK);
        po.transformObject();
        po.projectObject();
        po.draw();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    public static void main(String[] args) {
        UtilidadesGraficas.setDimensions(WIDTH, HEIGHT);

        // Crear un nuevo Frame (Ventana)
        JFrame frame = new JFrame("Transformaciones 3D");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Main (esta clase)
        Main main = new Main();
        // Create a PolygonObject
        main.po = new PolygonObject();
        // Reading takes a long time. Read the file before adding the
        // JPanel to the JFrame.
        main.po.readObject("casita3D.txt");
        main.po.setCanvas(main);

        // Agregar el JPanel al frame
        frame.add(main);
        // Asignarle tamaño
        frame.setSize(WIDTH, HEIGHT);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);

    }

    public void drawOneLine(int x1, int y1, int x2, int y2) {
        x1 = x1 + WIDTH / 2;
        y1 = HEIGHT / 2 - y1;
        x2 = x2 + WIDTH / 2;
        y2 = HEIGHT / 2 - y2;
        g.drawLine(x1, y1, x2, y2);
      }
}