package co.edu.eafit.dis.recorteDeLineas;

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
        g2d.setColor(Color.BLUE);

        // size es el tamaño de la ventana.
        Dimension size = getSize();
        // Insets son los bordes y los títulos de la ventana.
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        RecorteDeLineas rdl = new RecorteDeLineas();
        rdl.init(g2d, w, h);
        rdl.leerEspecificaciones();
        rdl.make();
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Reto 2 - Recorte de líneas");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Main (esta clase)
        frame.add(new Main());
        // Asignarle tamaño
        frame.setSize(500, 500);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }

}
