package co.edu.eafit.dis.computherGraphicsAlgorithms;

import co.edu.eafit.dis.core.DrawServiceAdapter;
import co.edu.eafit.dis.core.Point;

import java.awt.*;
import java.util.List;

public class DrawGraphics2DAdapter implements DrawServiceAdapter
{
    private final Graphics2D g2d;

    public DrawGraphics2DAdapter(Graphics2D g2d)
    {
        this.g2d = g2d;
    }

    public void draw(List<Point> points)
    {
        for (Point aPoint: points)
        {
            g2d.drawLine(aPoint.getX(), aPoint.getY(), aPoint.getX(), aPoint.getY());
        }
    }

}
