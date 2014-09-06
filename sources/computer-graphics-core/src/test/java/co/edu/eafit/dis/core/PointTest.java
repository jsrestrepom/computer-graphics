package co.edu.eafit.dis.core;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class PointTest
{

    @Test
    public void a_String_its_not_a_point()
    {
        // Arrange
        final String aStringPoint = "I am not a point !";
        // Act
        Point aPoint = new Point(-1, 0, -25);
        // Assert
        assertFalse(aPoint.equals(aStringPoint));
    }

    @Test
    public void a_null_value_its_not_a_point()
    {
        // Arrange
        // Act
        Point aPoint = new Point(-1, 0, -25);
        // Assert
        assertFalse(aPoint.equals(null));
    }

    @Test
    public void a_2D_point_is_equals_to_another_2D_point_if_their_component_X_and_Y_are_equals()
    {
        // Arrange
        // Act
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 0);
        // Assert
        assertTrue(pointA.equals(pointB));
    }

    @Test
    public void a_3D_point_is_equals_to_another_3D_point_if_their_component_X_Y_and_Z_are_equals()
    {
        // Arrange
        // Act
        Point pointA = new Point(0, 0, 25);
        Point pointB = new Point(0, 0, 25);
        // Assert
        assertTrue(pointA.equals(pointB));
    }

    @Test
    public void two_points_are_not_equals_when_their_component_X_are_different()
    {
        // Arrange
        // Act
        Point pointA = new Point(-1, 0, 25);
        Point pointB = new Point(0, 0, 25);
        // Assert
        assertFalse(pointA.equals(pointB));
    }

    @Test
    public void two_points_are_not_equals_when_their_component_Y_are_different()
    {
        // Arrange
        // Act
        Point pointA = new Point(0, 0, 25);
        Point pointB = new Point(0, -1, 25);
        // Assert
        assertFalse(pointA.equals(pointB));
    }

    @Test
    public void two_points_are_not_equals_when_their_component_Z_are_different()
    {
        // Arrange
        // Act
        Point pointA = new Point(-1, 0, 25);
        Point pointB = new Point(-1, 0, -25);
        // Assert
        assertFalse(pointA.equals(pointB));
    }

}
