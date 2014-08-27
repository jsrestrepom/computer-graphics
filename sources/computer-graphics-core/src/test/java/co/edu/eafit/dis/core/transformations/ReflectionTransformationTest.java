package co.edu.eafit.dis.core.transformations;

import co.edu.eafit.dis.core.Point;
import co.edu.eafit.dis.core.TransformationService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class ReflectionTransformationTest
{
    private TransformationService aTransformationService;
    private ReflectionTransformation aReflectionTransformation;

    @Before
    public void setup() {
        aReflectionTransformation = new ReflectionTransformation();
        aTransformationService = new TransformationService();
        aTransformationService.setTransformationFunction(aReflectionTransformation);
    }

    @Test
    public void trivial_reflection() {
        // Arrange
        Point expectedPoint = new Point(-205, 20);
        aReflectionTransformation.setReflectionOnX(false);
        aReflectionTransformation.setReflectionOnY(false);
        // Act
        Point somePoint = new Point(-205, 20);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test
    public void simple_reflection_over_x() {
        // Arrange
        Point expectedPoint = new Point(25, 201);
        aReflectionTransformation.setReflectionOnX(true);
        aReflectionTransformation.setReflectionOnY(false);
        // Act
        Point somePoint = new Point(25, -201);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test
    public void simple_reflection_over_y() {
        // Arrange
        Point expectedPoint = new Point(-25, -201);
        aReflectionTransformation.setReflectionOnX(false);
        aReflectionTransformation.setReflectionOnY(true);
        // Act
        Point somePoint = new Point(25, -201);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test
    public void full_reflection() {
        // Arrange
        Point expectedPoint = new Point(-205, 20);
        aReflectionTransformation.setReflectionOnX(true);
        aReflectionTransformation.setReflectionOnY(true);
        // Act
        Point somePoint = new Point(205, -20);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test
    public void a_point_reflected_twice_is_the_same_point() {
        // Arrange
        Point expectedPoint = new Point(205, -20);
        aReflectionTransformation.setReflectionOnX(true);
        aReflectionTransformation.setReflectionOnY(true);
        // Act
        Point somePoint = new Point(205, -20);
        Point actualPoint = aTransformationService.applyTransformation(somePoint);
        actualPoint = aTransformationService.applyTransformation(actualPoint);
        // Assert
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

}
