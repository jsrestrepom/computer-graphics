package Math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class SphereTest
{
    private Sphere aSphere;

    @Before
    public void setup() {
        aSphere = new Sphere(new Point3(1d, 0d, 0d), 1d);
    }

    @Test
    public void example_A() {
        // Arrange
        Ray ray1 = new Ray(new Point3(1d, 0d, 10d), new Point3(1d, 0d, 9d));
        // Act
        double[] solutions = aSphere.findIntersections(ray1);
        // Assert
        assertEquals(2, solutions.length);
    }

    @Test
    public void example_B() {
        // Arrange
        Ray ray2 = new Ray(new Point3(2d, 0d, 10d), new Point3(2d, 0d, 9d));
        // Act
        double[] solutions = aSphere.findIntersections(ray2);
        // Assert
        assertEquals(1, solutions.length);
    }

    @Test
    public void example_C() {
        // Arrange
        Ray ray3 = new Ray(new Point3(3d, 0d, 10d), new Point3(3d, 0d, 9d));
        // Act
        double[] solutions = aSphere.findIntersections(ray3);
        // Assert
        assertEquals(0, solutions.length);
    }

}