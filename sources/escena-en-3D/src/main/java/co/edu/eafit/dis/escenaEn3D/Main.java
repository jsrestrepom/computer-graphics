package co.edu.eafit.dis.escenaEn3D;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel
{

    /*
         * En esta función se dibuja.
         * La función es llamada por Java2D.
         * Se recibe una variable Graphics, que contiene la información del contexto
         * gráfico.
         * Es necesario hacerle un cast a Graphics2D para trabajar en Java2D.
         */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // size es el tamaño de la ventana.
        Dimension size = getSize();
        // Insets son los bordes y los títulos de la ventana.
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        EscenaEn3D escena = new EscenaEn3D();
        escena.init(g2d, w, h);
        escena.leerEspecificaciones();
        escena.make();
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Reto 3 - Escena en 3D");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Main (esta clase)
        frame.add(new Main());
        // Asignarle tamaño
        frame.setSize(600, 600);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }

}
