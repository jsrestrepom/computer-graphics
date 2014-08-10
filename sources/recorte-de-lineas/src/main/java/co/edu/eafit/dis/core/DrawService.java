package co.edu.eafit.dis.core;

import co.edu.eafit.dis.core.transformations.ReflectionTransformation;
import co.edu.eafit.dis.core.transformations.TranslationTransformation;

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
        aDrawServiceAdapter.draw(anEdge.getInitialPoint(), anEdge.getFinalPoint());
    }

}
