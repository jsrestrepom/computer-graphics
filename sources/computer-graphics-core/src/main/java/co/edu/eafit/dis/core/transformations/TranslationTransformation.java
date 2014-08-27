package co.edu.eafit.dis.core.transformations;

import co.edu.eafit.dis.core.Point;
import co.edu.eafit.dis.core.TransformationFunction;

public class TranslationTransformation implements TransformationFunction
{
    private int translationOnX;
    private int translationOnY;

    public TranslationTransformation() {
        translationOnX = 0;
        translationOnY = 0;
    }

    public void setTranslationOnX(int translationOnX) {
        this.translationOnX = translationOnX;
    }

    public int getTranslationOnX() {
        return translationOnX;
    }

    public void setTranslationOnY(int translationOnY) {
        this.translationOnY = translationOnY;
    }

    public int getTranslationOnY() {
        return translationOnY;
    }

    public Point apply(Point aPoint) {
        int x = aPoint.getX() + translationOnX;
        int y = aPoint.getY() + translationOnY;
        return new Point(x, y);
    }
}
