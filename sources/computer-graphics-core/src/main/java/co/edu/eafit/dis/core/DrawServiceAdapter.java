package co.edu.eafit.dis.core;

import java.util.List;

public interface DrawServiceAdapter
{
    public void draw(List<Point> pointList);

    public void draw(Point initialPoint, Point finalPoint);
}
