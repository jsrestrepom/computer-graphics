package co.edu.eafit.dis.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public final class LineClippingServiceTest
{
    private LineClippingService aLineClippingService;

    @Before
    public void setup() {
        ClippingArea aClippingArea = new ClippingArea(-250, 250, -250, 250);
        aLineClippingService = new LineClippingService(aClippingArea);
    }

    @Test
    public void a_line_inside_the_clipping_area_remains_without_modifications() {
        // Arrange
        final Point expectedInitialPointOfTheEdge = new Point(0, 0);
        final Point expectedFinalPointOfTheEdge = new Point(-200, 180);
        Point someInitialPoint = new Point(0, 0);
        Point someFinalPoint = new Point(-200, 180);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        Point actualInitialPointOfTheEdge = actualEdge.getInitialPoint();
        Point actualFinalPointOfTheEdge = actualEdge.getFinalPoint();
        assertEquals(expectedInitialPointOfTheEdge.getX(), actualInitialPointOfTheEdge.getX());
        assertEquals(expectedInitialPointOfTheEdge.getY(), actualInitialPointOfTheEdge.getY());
        assertEquals(expectedFinalPointOfTheEdge.getX(), actualFinalPointOfTheEdge.getX());
        assertEquals(expectedFinalPointOfTheEdge.getY(), actualFinalPointOfTheEdge.getY());
    }

    @Test
    public void a_line_complete_outside_the_clipping_area_remains_without_modifications() {
        // Arrange
        Point someInitialPoint = new Point(1024, 1024);
        Point someFinalPoint = new Point(2048, 2048);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        assertFalse(actualEdge.isInsideClippingArea());
    }

    @Test
    public void a_redefined_line_by_the_right_always_will_be_inside_the_clipping_area() {
        // Arrange
        Point someInitialPoint = new Point(150, 0);
        Point someFinalPoint = new Point(300, 0);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        assertTrue(actualEdge.isInsideClippingArea());
    }

    @Test
    public void a_line_partially_outside_by_the_right_is_redefined() {
        // Arrange
        final Point expectedInitialPointOfTheEdge = new Point(150, 0);
        final Point expectedFinalPointOfTheEdge = new Point(250, 0);
        Point someInitialPoint = new Point(150, 0);
        Point someFinalPoint = new Point(300, 0);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        Point actualInitialPointOfTheEdge = actualEdge.getInitialPoint();
        Point actualFinalPointOfTheEdge = actualEdge.getFinalPoint();
        assertEquals(expectedInitialPointOfTheEdge.getX(), actualInitialPointOfTheEdge.getX());
        assertEquals(expectedFinalPointOfTheEdge.getX(), actualFinalPointOfTheEdge.getX());
    }

    @Test
    public void a_redefined_line_by_the_left_always_will_be_inside_the_clipping_area() {
        // Arrange
        Point someInitialPoint = new Point(-150, 0);
        Point someFinalPoint = new Point(-300, 0);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        assertTrue(actualEdge.isInsideClippingArea());
    }

    @Test
    public void a_line_partially_outside_by_the_left_is_redefined() {
        // Arrange
        final Point expectedInitialPointOfTheEdge = new Point(-250, 0);
        final Point expectedFinalPointOfTheEdge = new Point(-150, 0);
        Point someInitialPoint = new Point(-300, 0);
        Point someFinalPoint = new Point(-150, 0);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        Point actualInitialPointOfTheEdge = actualEdge.getInitialPoint();
        Point actualFinalPointOfTheEdge = actualEdge.getFinalPoint();
        assertEquals(expectedInitialPointOfTheEdge.getX(), actualInitialPointOfTheEdge.getX());
        assertEquals(expectedFinalPointOfTheEdge.getX(), actualFinalPointOfTheEdge.getX());
    }

    @Test
    public void a_redefined_line_by_the_top_always_will_be_inside_the_clipping_area() {
        // Arrange
        Point someInitialPoint = new Point(5, 180);
        Point someFinalPoint = new Point(5, 1800);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        assertTrue(actualEdge.isInsideClippingArea());
    }

    @Test
    public void a_line_partially_outside_by_the_top_is_redefined() {
        // Arrange
        final Point expectedInitialPointOfTheEdge = new Point(5, 180);
        final Point expectedFinalPointOfTheEdge = new Point(5, 250);
        Point someInitialPoint = new Point(5, 180);
        Point someFinalPoint = new Point(5, 1800);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        Point actualInitialPointOfTheEdge = actualEdge.getInitialPoint();
        Point actualFinalPointOfTheEdge = actualEdge.getFinalPoint();
        assertEquals(expectedInitialPointOfTheEdge.getY(), actualInitialPointOfTheEdge.getY());
        assertEquals(expectedFinalPointOfTheEdge.getY(), actualFinalPointOfTheEdge.getY());
    }

    @Test
    public void a_redefined_line_by_the_bottom_always_will_be_inside_the_clipping_area() {
        // Arrange
        Point someInitialPoint = new Point(-50, -220);
        Point someFinalPoint = new Point(-50, -500);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        assertTrue(actualEdge.isInsideClippingArea());
    }

    @Test
    public void a_line_partially_outside_by_the_bottom_is_redefined() {
        // Arrange
        final Point expectedInitialPointOfTheEdge = new Point(-50, -220);
        final Point expectedFinalPointOfTheEdge = new Point(-50, -250);
        Point someInitialPoint = new Point(-50, -220);
        Point someFinalPoint = new Point(-50, -500);
        // Act
        Edge someEdge = new Edge(someInitialPoint, someFinalPoint);
        Edge actualEdge = aLineClippingService.computeLine(someEdge);
        //Assert
        Point actualInitialPointOfTheEdge = actualEdge.getInitialPoint();
        Point actualFinalPointOfTheEdge = actualEdge.getFinalPoint();
        assertEquals(expectedInitialPointOfTheEdge.getY(), actualInitialPointOfTheEdge.getY());
        assertEquals(expectedFinalPointOfTheEdge.getY(), actualFinalPointOfTheEdge.getY());
    }

}
