package co.edu.eafit.dis.core;

public class DrawService
{
    private DrawServiceAdapter aDrawServiceAdapter;

    public void setDrawAdapter(DrawServiceAdapter aDrawServiceAdapter) {
        this.aDrawServiceAdapter = aDrawServiceAdapter;
    }

    public void drawLine(Line aLine) {
        aDrawServiceAdapter.draw(aLine.getPoints());
    }

    public void drawEdge(Edge anEdge) {
        if (anEdge.isInsideClippingArea())
        {
            aDrawServiceAdapter.draw(anEdge.getInitialPoint(), anEdge.getFinalPoint());
        }
    }

}
