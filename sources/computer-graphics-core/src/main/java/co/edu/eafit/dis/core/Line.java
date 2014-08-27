package co.edu.eafit.dis.core;

import java.util.LinkedList;
import java.util.List;

public class Line
{
    private List<Point> aPointsList;
    private int octant;

    public Line()
    {
        this.octant = 0;
    }

    public void setOctant(int octant)
    {
        this.octant = octant;
    }

    public void setPoints(List<Point> aPointsList)
    {
        this.aPointsList = aPointsList;
    }

    public List<Point> getPoints()
    {
        return aPointsList;
    }

    public void generateWithBresenhamLineAlgorithm(Point anInitialPoint, Point aFinalPoint)
    {
        aPointsList = new LinkedList<Point>();
        anInitialPoint = switchToOctantZeroFrom(octant, anInitialPoint);
        aFinalPoint = switchToOctantZeroFrom(octant, aFinalPoint);

        int dx = Math.abs(aFinalPoint.getX() - anInitialPoint.getX());
        int dy = Math.abs(aFinalPoint.getY() - anInitialPoint.getY());

        int incE = 2 * dy;
        int incNE = 2 * dy - 2 * dx;
        int d = 2 * dy - dx;
        int y = anInitialPoint.getY();
        for (int x = anInitialPoint.getX(); x <= aFinalPoint.getX(); x++)
        {
            aPointsList.add(new Point(x, y));
            if (d <= 0)
            {
                d += incE;
            }
            else
            {
                d += incNE;
                y += 1;
            }
        }
    }

    public Point switchToOctantZeroFrom(int octant, Point aPoint)
    {
        Point newPoint;
        switch(octant) {
            case 0:
                newPoint = new Point(aPoint.getX(),aPoint.getY());
                break;
            case 1:
                newPoint = new Point (aPoint.getY(),aPoint.getX());
                break;
            case 2:
                newPoint = new Point(aPoint.getY(),-aPoint.getX());
                break;
            case 3:
                newPoint = new Point(-aPoint.getX(),aPoint.getY());
                break;
            case 4:
                newPoint = new Point(-aPoint.getX(),-aPoint.getY());
                break;
            case 5:
                newPoint = new Point(-aPoint.getY(),-aPoint.getX());
                break;
            case 6:
                newPoint = new Point(-aPoint.getY(),aPoint.getX());
                break;
            case 7:
                newPoint = new Point(aPoint.getX(),- aPoint.getY());
                break;
            default:
                newPoint = aPoint;
        }
        return newPoint;
    }
}
