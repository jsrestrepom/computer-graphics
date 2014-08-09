package co.edu.eafit.dis.computherGraphicsAlgorithms;

public class DrawService
{
    DrawAdapter aDrawAdapter;

    public void setDrawAdapter(DrawAdapter aDrawAdapter)
    {
        this.aDrawAdapter = aDrawAdapter;
    }

    public void drawLine(Line aLine)
    {
        aDrawAdapter.draw(aLine.getPoints());
    }

}
