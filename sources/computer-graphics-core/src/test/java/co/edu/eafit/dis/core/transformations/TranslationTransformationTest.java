package co.edu.eafit.dis.core.transformations;

import co.edu.eafit.dis.core.Point;
import co.edu.eafit.dis.core.TransformationService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class TranslationTransformationTest
{
    private TransformationService aTransformationService;
    private TranslationTransformation aTranslationTransformation;

    @Before
    public void setup() {
        aTranslationTransformation = new TranslationTransformation();
        aTransformationService = new TransformationService();
        aTransformationService.setTransformationFunction(aTranslationTransformation);
    }

    @Test
    public void simple_translation_to_the_right() {
        // Arrange
        Point expectedPoint = new Point(85, 10);
        aTranslationTransformation.setTranslationOnX(60);
        aTranslationTransformation.setTranslationOnY(0);
        // Act
        Point somePoint = new Point(25, 10);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test
    public void simple_translation_to_the_left() {
        // Arrange
        Point expectedPoint = new Point(25, 10);
        // Act
        Point somePoint = new Point(85, 10);
        aTranslationTransformation.setTranslationOnX(-60);
        aTranslationTransformation.setTranslationOnY(0);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test
    public void simple_translation_to_the_top() {
        // Arrange
        Point expectedPoint = new Point(50, 10);
        aTranslationTransformation.setTranslationOnX(0);
        aTranslationTransformation.setTranslationOnY(420);
        // Act
        Point somePoint = new Point(50, -410);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test
    public void simple_translation_to_the_bottom() {
        // Arrange
        Point expectedPoint = new Point(1200, -430);
        aTranslationTransformation.setTranslationOnX(0);
        aTranslationTransformation.setTranslationOnY(-20);
        // Act
        Point somePoint = new Point(1200, -410);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

}
