package co.edu.eafit.dis.segmentoDeLineas;

import co.edu.eafit.dis.computherGraphicsAlgorithms.DrawService;
import co.edu.eafit.dis.computherGraphicsAlgorithms.Line;
import co.edu.eafit.dis.computherGraphicsAlgorithms.Point;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main extends JPanel {

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

        pintarSegmentosDeLineas(g2d, w, h);
    }

    private void pintarSegmentosDeLineas(Graphics2D g2d, int with, int height)
    {
        Line aLine = new Line();
        DrawGraphics2DAdapter aDrawGraphics2DAdapter = new DrawGraphics2DAdapter(g2d);
        DrawService aDrawService = new DrawService();
        aDrawService.setDrawAdapter(aDrawGraphics2DAdapter);
        final int MARGEN = 5;

        g2d.setColor(Color.BLACK);
        for (int i = with / 2; i < with; i += MARGEN)
        {
            Point someInitialPoint = new Point(i, 0);
            Point someFinalPoint = new Point(with, i);
            aLine.generateWithBresenhamLineAlgorithm(someInitialPoint, someFinalPoint);
            aDrawService.drawLine(aLine);
            g2d.setColor(Color.RED);
        }

        /**
         * TODO: define the apropiate transformation in order to be enable to draw the line in all the octants
         */
        g2d.setColor(Color.BLACK);
        aLine.setOctant(3);
        for (int i = with / 2; i < with ; i += MARGEN)
        {
            Point someInitialPoint = new Point(i, height);
            Point someFinalPoint = new Point(with, height - i);
            aLine.generateWithBresenhamLineAlgorithm(someInitialPoint, someFinalPoint);
            aDrawService.drawLine(aLine);
            g2d.setColor(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        // Crear un nuevo Frame
        JFrame frame = new JFrame("Reto 1 - Segmento de líneas");
        // Al cerrar el frame, termina la ejecución de este programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Agregar un JPanel que se llama Main (esta clase)
        frame.add(new Main());
        // Asignarle tamaño
        frame.setSize(450, 400);
        // Poner el frame en el centro de la pantalla
        frame.setLocationRelativeTo(null);
        // Mostrar el frame
        frame.setVisible(true);
    }

}
