package co.edu.eafit.dis.core;

public class Edge
{
    private Point aPoint;
    private Point bPoint;

    public Edge(Point aPoint, Point bPoint) {
        this.aPoint = aPoint;
        this.bPoint = bPoint;
    }

    public Point getAPoint() {
        return aPoint;
    }

    public Point getBPoint() {
        return bPoint;
    }
}
