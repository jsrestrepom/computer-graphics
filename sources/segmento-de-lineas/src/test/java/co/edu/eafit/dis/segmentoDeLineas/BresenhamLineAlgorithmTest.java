package co.edu.eafit.dis.segmentoDeLineas;

import static org.junit.Assert.*;

import co.edu.eafit.dis.computherGraphicsAlgorithms.Line;
import co.edu.eafit.dis.computherGraphicsAlgorithms.Point;
import org.junit.Test;

import java.util.List;

public final class BresenhamLineAlgorithmTest
{

    @Test public void simple_draw()
    {
        // Arrange
        Point anInitialPoint = new Point(0, 0);
        Point aFinalPoint = new Point(2, 2);
        Line aLine = new Line();
        // Act
        aLine.generateWithBresenhamLineAlgorithm(anInitialPoint, aFinalPoint);
        // Assert
        List<Point> aLinePoints = aLine.getPoints();
        Point expectedPoint = new Point(1, 1);
        Point actualPoint = aLinePoints.get(1);
        assertEquals(expectedPoint.getX(), actualPoint.getX());
        assertEquals(expectedPoint.getY(), actualPoint.getY());
    }

    @Test public void drawing_a_line_with_one_point()
    {
        // Arrange
        Point anInitialPoint = new Point(10, 10);
        Point aFinalPoint = new Point(10, 10);
        Line aLine = new Line();
        // Act
        aLine.generateWithBresenhamLineAlgorithm(anInitialPoint, aFinalPoint);
        // Assert
        List<Point> aLinePoints = aLine.getPoints();
        int expectedSize = 1;
        assertEquals(expectedSize, aLinePoints.size());
    }

    @Test public void switch_a_point_to_a_octant_twice_its_the_same_point()
    {
        // Arrange
        Point somePoint = new Point(-10, -10);
        Line aLine = new Line();
        // Act
        Point switchedPoint = aLine.switchToOctantZeroFrom(4, somePoint);
        switchedPoint = aLine.switchToOctantZeroFrom(4, switchedPoint);
        // Assert
        assertEquals(somePoint.getX(), switchedPoint.getX());
        assertEquals(somePoint.getY(), switchedPoint.getY());
    }

}
