package cameraMovement.display;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cameraMovement.geometry.PolygonObject;
import cameraMovement.geometry.ObjectTransformation;

import java.awt.Color;
import java.awt.Graphics;

public class GuiMain extends JPanel
    implements KeyListener {

  static final int WIDTH = 800;
  static final int HEIGHT = 600;
  public double u = 0, v = 0, n = 0;
  public double cameraY = 0, cameraX = 0;

  Graphics g;

  PolygonObject po;


  public GuiMain() {
    setFocusable(true);
    requestFocusInWindow();
    addKeyListener(this);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    this.g = g;
    g.setColor(Color.RED);
    drawOneLine(-100, 0, 100, 0);

    g.setColor(Color.GREEN);
    drawOneLine(0, -100, 0, 100);


    g.setColor(Color.BLACK);
    setCamera(po);
    po.transformObject();
    po.projectObject();
    po.draw();

  }

  public void setCamera(PolygonObject obj) {
    obj.ot.u = u;
    obj.ot.v = v;
    obj.ot.n = n;
    obj.ot.cameraX = cameraX;
    obj.ot.cameraY = cameraY;
  }
  public void drawOneLine(int x1, int y1, int x2, int y2) {
    x1 = x1 + WIDTH / 2;
    y1 = HEIGHT / 2 - y1;
    x2 = x2 + WIDTH / 2;
    y2 = HEIGHT / 2 - y2;
    g.drawLine(x1, y1, x2, y2);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    switch (key) {
      case KeyEvent.VK_D:
        po.ot.dx += ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_A:
        po.ot.dx -= ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_W:
        po.ot.dy += ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_S:
        po.ot.dy -= ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_X:
        po.ot.dz += ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_C:
        po.ot.dz -= ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_Q:
        po.ot.sx += ObjectTransformation.DELTA_SCAL;
        po.ot.sy += ObjectTransformation.DELTA_SCAL;
        po.ot.sz += ObjectTransformation.DELTA_SCAL;
        break;
      case KeyEvent.VK_E:
        po.ot.sx -= ObjectTransformation.DELTA_SCAL;
        po.ot.sy -= ObjectTransformation.DELTA_SCAL;
        po.ot.sz -= ObjectTransformation.DELTA_SCAL;
        break;
      case KeyEvent.VK_R:
        po.ot.thetaX += ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_F:
        po.ot.thetaX -= ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_T:
        po.ot.thetaY += ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_G:
        po.ot.thetaY -= ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_Y:
        po.ot.thetaZ += ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_H:
        po.ot.thetaZ -= ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_UP:
        n += ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_DOWN:
        n -= ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_LEFT:
        u += ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_RIGHT:
        u -= ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_CONTROL:
        v += ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_SPACE:
        v -= ObjectTransformation.DELTA_TRANSL;
        break;
      case KeyEvent.VK_1:
        cameraX += ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_2:
        cameraY -= ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_3:
        if (cameraX < 1)
          cameraX += ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_4:
        if (cameraX > -1)
          cameraX-= ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_6:
        cameraY += ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_7:
        cameraY -= ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_8:
        if (cameraX < 1)
          cameraX += ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_9:
        if (cameraX > -1)
          cameraX -= ObjectTransformation.DELTA_ROT;
        break;
      case KeyEvent.VK_Z:
        po.resetVertices();
        u = 0;
        v = 0;
        n = 0;
        cameraX = 0;
        cameraY = 0;
        break;
    }
    repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  public static void main(String[] args) {
    // Crear un nuevo Frame (Ventana)
    JFrame frame = new JFrame("Camara posición arbitraria");
    // Al cerrar el frame, termina la ejecución de este programa
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Agregar un JPanel que se llama Main (esta clase)
    GuiMain main = new GuiMain();

    main.po = new PolygonObject();

    main.po.readObject("casita3D_Free_cam.txt");

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
}
