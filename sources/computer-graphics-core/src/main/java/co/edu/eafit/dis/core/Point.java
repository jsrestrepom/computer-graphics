package co.edu.eafit.dis.core;

public class Point
{
    private int x;
    private int y;
    private int z;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof Point))
        {
            return false;
        }
        if (o == this)
        {
            return true;
        }
        Point castPoint = (Point) o;
        return (this.x == castPoint.getX() && this.y == castPoint.getY() && this.z == castPoint.getZ());
    }

}
