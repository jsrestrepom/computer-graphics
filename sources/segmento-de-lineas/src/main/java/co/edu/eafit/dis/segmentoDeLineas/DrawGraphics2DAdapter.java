package co.edu.eafit.dis.segmentoDeLineas;

import co.edu.eafit.dis.computherGraphicsAlgorithms.*;

import java.awt.*;
import java.util.List;

public class DrawGraphics2DAdapter implements DrawAdapter
{
    private final Graphics2D g2d;

    public DrawGraphics2DAdapter(Graphics2D g2d)
    {
        this.g2d = g2d;
    }

    public void draw(List<co.edu.eafit.dis.computherGraphicsAlgorithms.Point> points)
    {
        for (co.edu.eafit.dis.computherGraphicsAlgorithms.Point aPoint: points)
        {
            g2d.drawLine(aPoint.getX(), aPoint.getY(), aPoint.getX(), aPoint.getY());
        }
    }

}
