package house;

import javax.swing.JFrame;

import house.*;

public class Main {
    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("House");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Points (esta clase)
        frame.add(new House());
        // Asignarle tamaño
        frame.setSize(House.WIDTH, House.HEIGHT);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }
}
