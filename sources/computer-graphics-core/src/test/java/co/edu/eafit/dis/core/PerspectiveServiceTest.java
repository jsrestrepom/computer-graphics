package co.edu.eafit.dis.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class PerspectiveServiceTest
{
    @Test
    public void perspective_of_a_point_over_a_positive_plane()
    {
        // Arrange
        final int projectionPlaneDistance = -100;
        Point expectedPoint = new Point(0, 40, -100);
        // Act
        Point somePoint = new Point(0, 100, -250);
        PerspectiveService aPerspectiveService = new PerspectiveService();
        Point actualPoint = aPerspectiveService.projectPointOverPlane(somePoint, projectionPlaneDistance);
        // Assert
        assertEquals(expectedPoint, actualPoint);
    }

    @Test
    public void perspective_of_a_point_over_a_positive_projection_plane()
    {
        // Arrange
        final int projectionPlaneDistance = 10;
        Point expectedPoint = new Point(10, 10, 10);
        // Act
        Point somePoint = new Point(1, 1, 1);
        PerspectiveService aPerspectiveService = new PerspectiveService();
        Point actualPoint = aPerspectiveService.projectPointOverPlane(somePoint, projectionPlaneDistance);
        // Assert
        assertEquals(expectedPoint, actualPoint);
    }

    @Test
    public void perspective_of_a_point_over_a_negative_projection_plan()
    {
        // Arrange
        final int projectionPlaneDistance = -10;
        Point expectedPoint = new Point(-10, -10, -10);
        // Act
        Point somePoint = new Point(1, 1, 1);
        PerspectiveService aPerspectiveService = new PerspectiveService();
        Point actualPoint = aPerspectiveService.projectPointOverPlane(somePoint, projectionPlaneDistance);
        // Assert
        assertEquals(expectedPoint, actualPoint);
    }

    @Test
    public void the_perspective_of_a_point_in_the_projection_plane_is_the_same_point()
    {
        // Arrange
        final int projectionPlaneDistance = -250;
        Point expectedPoint = new Point(0, 100, -250);
        // Act
        Point somePoint = new Point(0, 100, -250);
        PerspectiveService aPerspectiveService = new PerspectiveService();
        Point actualPoint = aPerspectiveService.projectPointOverPlane(somePoint, projectionPlaneDistance);
        // Assert
        assertEquals(expectedPoint, actualPoint);
    }

}
