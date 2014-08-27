package co.edu.eafit.dis.core.transformations;

import co.edu.eafit.dis.core.Point;
import co.edu.eafit.dis.core.TransformationFunction;

public class ReflectionTransformation implements TransformationFunction
{
    private boolean reflectionOnX;
    private boolean reflectionOnY;

    public ReflectionTransformation() {
        reflectionOnX = false;
        reflectionOnY = false;
    }

    public void setReflectionOnX(boolean reflectionOnX) {
        this.reflectionOnX = reflectionOnX;
    }

    public boolean isReflectionOnX() {
        return reflectionOnX;
    }

    public void setReflectionOnY(boolean reflectionOnY) {
        this.reflectionOnY = reflectionOnY;
    }

    public boolean isReflectionOnY() {
        return reflectionOnY;
    }

    public Point apply(Point aPoint) {
        int x = aPoint.getX();
        int y = aPoint.getY();
        if (reflectionOnY)
        {
            x = -x;
        }
        if (reflectionOnX)
        {
            y = -y;
        }
        return new Point(x, y);
    }
}
