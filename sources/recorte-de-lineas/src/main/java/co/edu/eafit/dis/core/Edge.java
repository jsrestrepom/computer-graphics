package co.edu.eafit.dis.core;

public class Edge
{
    private Point initialPoint;
    private Point finalPoint;

    public Edge(Point initialPoint, Point finalPoint) {
        this.initialPoint = initialPoint;
        this.finalPoint = finalPoint;
    }

    public Point getInitialPoint() {
        return initialPoint;
    }

    public Point getFinalPoint() {
        return finalPoint;
    }

}
