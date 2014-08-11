package co.edu.eafit.dis.core;

public class Edge
{
    private Point initialPoint;
    private Point finalPoint;
    private boolean insideClippingArea;

    public Edge(Point initialPoint, Point finalPoint) {
        this.initialPoint = initialPoint;
        this.finalPoint = finalPoint;
        this.insideClippingArea = true;
    }

    public Point getInitialPoint() {
        return initialPoint;
    }

    public Point getFinalPoint() {
        return finalPoint;
    }

    public boolean isInsideClippingArea() {
        return insideClippingArea;
    }

    public void setInsideClippingArea(boolean insideClippingArea) {
        this.insideClippingArea = insideClippingArea;
    }
}
