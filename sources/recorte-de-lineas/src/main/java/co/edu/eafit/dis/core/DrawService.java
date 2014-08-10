package co.edu.eafit.dis.core;

public class DrawService
{
    DrawServiceAdapter aDrawServiceAdapter;

    public void setDrawAdapter(DrawServiceAdapter aDrawServiceAdapter)
    {
        this.aDrawServiceAdapter = aDrawServiceAdapter;
    }

    public void drawLine(Line aLine)
    {
        aDrawServiceAdapter.draw(aLine.getPoints());
    }

}
