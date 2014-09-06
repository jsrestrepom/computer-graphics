package co.edu.eafit.dis.core;

public class PerspectiveService
{

    public Point projectPointOverPlane(Point aPoint, int aProjectionPlaneDistance) {
        Double projectionFactor = Double.valueOf(aPoint.getZ()) / Double.valueOf(aProjectionPlaneDistance);
        Double xp = Double.valueOf(aPoint.getX()) / projectionFactor;
        Double yp = Double.valueOf(aPoint.getY()) / projectionFactor;
        int zp = aProjectionPlaneDistance;
        return new Point(xp.intValue(), yp.intValue(), zp);
    }

}
