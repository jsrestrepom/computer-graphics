package co.edu.eafit.dis.core;

public class ClippingArea
{
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    public ClippingArea(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public int getXMin() {
        return xMin;
    }

    public int getXMax() {
        return xMax;
    }

    public int getYMin() {
        return yMin;
    }

    public int getYMax() {
        return yMax;
    }
}
