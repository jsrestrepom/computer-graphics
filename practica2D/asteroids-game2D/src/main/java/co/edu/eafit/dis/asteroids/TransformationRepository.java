package co.edu.eafit.dis.asteroids;

import co.edu.eafit.dis.core.transformations.ReflectionTransformation;
import co.edu.eafit.dis.core.transformations.TranslationTransformation;

public class TransformationRepository
{
    private ReflectionTransformation reflectionOverOrigin;
    private TranslationTransformation translationOverOrigin;

    public TransformationRepository(int width, int height) {
        reflectionOverOrigin = new ReflectionTransformation();
        reflectionOverOrigin.setReflectionOnX(true);
        translationOverOrigin = new TranslationTransformation();
        translationOverOrigin.setTranslationOnX(width / 2);
        translationOverOrigin.setTranslationOnY(height / 2);
    }

    public ReflectionTransformation getReflectionTransformation() {
        return reflectionOverOrigin;
    }

    public TranslationTransformation getTranslationTransformation() {
        return translationOverOrigin;
    }

}
