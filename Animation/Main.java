package Animation;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

import Math.Point3;
import Math.TranslScalRot3x3;

public class Main extends JFrame implements KeyListener {
    public static Printer printer = new Printer();

    public static void main(String[] args) {
        // Crear un nuevo Frame
        Main frame = new Main();
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Printer (tu clase)
        frame.add(printer);
        // Asignarle tamaño
        frame.setSize(Printer.WIDTH, Printer.HEIGHT);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);

        // Agregar el KeyListener al frame
        frame.addKeyListener(frame);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_W) {
            printer.applyTransformation(getGraphics(), new TranslScalRot3x3(0, 5, 1, 1, 0));
        } else if (tecla == KeyEvent.VK_DOWN || tecla == KeyEvent.VK_S) {
            printer.applyTransformation(getGraphics(), new TranslScalRot3x3(0, -5, 1, 1, 0));
        } else if (tecla == KeyEvent.VK_RIGHT || tecla == KeyEvent.VK_D) {
            printer.applyTransformation(getGraphics(), new TranslScalRot3x3(5, 0, 1, 1, 0));
        } else if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_A) {
            printer.applyTransformation(getGraphics(), new TranslScalRot3x3(-5, 0, 1, 1, 0));
        } else if (tecla == KeyEvent.VK_Q) {

            Point3 center = CalcTransforms.calculateObjectCenter();
            CalcTransforms.bringPointsToCenter(center);
            TranslScalRot3x3 scaleMatrix = new TranslScalRot3x3(0, 0, 1.1, 1.1, 0);
            printer.applyTransformation(getGraphics(), scaleMatrix);
            CalcTransforms.returnPointsToOriginalPosition(center);

        } else if (tecla == KeyEvent.VK_E) {

            Point3 center = CalcTransforms.calculateObjectCenter();
            CalcTransforms.bringPointsToCenter(center);
            TranslScalRot3x3 scaleMatrix = new TranslScalRot3x3(0, 0, 0.9, 0.9, 0);
            printer.applyTransformation(getGraphics(), scaleMatrix);
            CalcTransforms.returnPointsToOriginalPosition(center);

        } else if (tecla == KeyEvent.VK_F) {
            Point3 center = CalcTransforms.calculateObjectCenter();
            CalcTransforms.bringPointsToCenter(center);
            TranslScalRot3x3 rotateMatrix = new TranslScalRot3x3(0, 0, 1, 1, 0.1);
            printer.applyTransformation(getGraphics(), rotateMatrix);
            CalcTransforms.returnPointsToOriginalPosition(center);
        } else if (tecla == KeyEvent.VK_R) {
            Point3 center = CalcTransforms.calculateObjectCenter();
            CalcTransforms.bringPointsToCenter(center);
            TranslScalRot3x3 rotateMatrix = new TranslScalRot3x3(0, 0, 1, 1, -0.1);
            printer.applyTransformation(getGraphics(), rotateMatrix);
            CalcTransforms.returnPointsToOriginalPosition(center);
        } else if (tecla == KeyEvent.VK_O){
            printer.restart();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
