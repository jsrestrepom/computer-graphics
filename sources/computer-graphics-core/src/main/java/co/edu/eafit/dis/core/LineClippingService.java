package co.edu.eafit.dis.core;

public class LineClippingService
{
    private final ClippingArea aClippingArea;

    public static final int INSIDE = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int BOTTOM = 4;
    public static final int TOP = 8;

    public LineClippingService(ClippingArea aClippingArea) {
        this.aClippingArea = aClippingArea;
    }

    public Edge computeLine(Edge aEdge) {
        Point computeInitialPoint = new Point(aEdge.getInitialPoint().getX(), aEdge.getInitialPoint().getY());
        Point computeFinalPoint = new Point(aEdge.getFinalPoint().getX(), aEdge.getFinalPoint().getY());
        Edge computeEdge = new Edge(computeInitialPoint, computeFinalPoint);
        int codeOfInitialPoint = computeCode(computeInitialPoint);
        int codeOfFinalPoint = computeCode(computeFinalPoint);
        while (true)
        {
            if ((codeOfInitialPoint | codeOfFinalPoint) == 0)
            {
                computeEdge.setInsideClippingArea(true);
                break;
            }
            else if ((codeOfInitialPoint & codeOfFinalPoint) != 0)
            {
                computeEdge.setInsideClippingArea(false);
                break;
            }
            else
            {
                int x = 0, y = 0;
                int x0 = computeInitialPoint.getX();
                int y0 = computeInitialPoint.getY();
                int x1 = computeFinalPoint.getX();
                int y1 = computeFinalPoint.getY();
                int codeOut = (codeOfInitialPoint != 0) ? codeOfInitialPoint : codeOfFinalPoint;
                if ((codeOut & TOP) != 0)
                {
                    x = x0 + (x1 - x0) * (aClippingArea.getYMax() - y0) / (y1 - y0);
                    y = aClippingArea.getYMax();
                }
                else if ((codeOut & BOTTOM) != 0)
                {
                    x = x0 + (x1 - x0) * (aClippingArea.getYMin() - y0) / (y1 - y0);
                    y = aClippingArea.getYMin();
                }
                else if ((codeOut & RIGHT) != 0)
                {
                    y = y0 + (y1 - y0) * (aClippingArea.getXMax() - x0) / (x1 - x0);
                    x = aClippingArea.getXMax();
                }
                else if ((codeOut & LEFT) != 0)
                {
                    y = y0 + (y1 - y0) * (aClippingArea.getXMin() - x0) / (x1 - x0);
                    x = aClippingArea.getXMin();
                }
                if (codeOut == codeOfInitialPoint)
                {
                    computeInitialPoint.setX(x);
                    computeInitialPoint.setY(y);
                    codeOfInitialPoint = computeCode(computeInitialPoint);

                }
                else
                {
                    computeFinalPoint.setX(x);
                    computeFinalPoint.setY(y);
                    codeOfFinalPoint = computeCode(computeFinalPoint);
                }
                computeEdge = new Edge(computeInitialPoint, computeFinalPoint);
            }
        }
        return computeEdge;
    }

    public int computeCode(Point aPoint) {
        final int x = aPoint.getX();
        final int y = aPoint.getY();
        int code = INSIDE;
        if (x < aClippingArea.getXMin())
        {
            code |= LEFT;
        }
        else if (x > aClippingArea.getXMax())
        {
            code |= RIGHT;
        }
        if (y < aClippingArea.getYMin())
        {
            code |= BOTTOM;
        }
        else if (y > aClippingArea.getYMax())
        {
            code |= TOP;
        }
        return code;
    }
}
