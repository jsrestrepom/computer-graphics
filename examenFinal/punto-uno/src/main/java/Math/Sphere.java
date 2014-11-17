/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import co.edu.eafit.dis.core.MathOperationService;
import co.edu.eafit.dis.core.Vector;
import co.edu.eafit.dis.core.VectorOfDoubles;

/**
 * @author htrefftz
 */
public class Sphere implements Intersectable
{
    /**
     * Center point of the sphere
     */
    protected Point3 center;
    /**
     * Radius of the sphere
     */
    protected double radius;

    public static final boolean DEBUG = false;

    /**
     * Constructor
     *
     * @param center Center point of the sphere
     * @param radius Radius of the sphere
     */
    public Sphere(Point3 center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Computes the normal at a point on the surface of the sphere
     *
     * @param point point to compute the normal at
     * @return a normalized vector from the center of the sphere to the point
     * on the surface
     */
    public Vector3 computeNormal(Point3 point) {
        Vector3 normal = new Vector3(center, point);
        normal.normalize();
        return normal;
    }

    /**
     * Finds the intersection(s) of this sphere with the ray provided as
     * parameter
     *
     * @param ray Ray to check intersection with this sphere.
     * @return An Array with the value(s) of the parameter in the ray that
     * determines the intersection(s) of the ray and the sphere.
     * If there are no intersections, array ret has 0 positions.
     * If there is only one intersection, array ret has 1 position.
     * If there are two intersections, array ret has 2 positions.
     */
    @Override
    public double[] findIntersections(Ray ray) {
        VectorOfDoubles rayDirection = new VectorOfDoubles(ray.p1.x - ray.p0.x, ray.p1.y - ray.p0.y, ray.p1.z - ray.p0.z);
        VectorOfDoubles ocVector = new VectorOfDoubles(ray.p0.x - center.x, ray.p0.y - center.y, ray.p0.z - center.z);

        double componentA = MathOperationService.productoPunto(rayDirection, rayDirection);
        double componentB = 2 * MathOperationService.productoPunto(ocVector, rayDirection);
        double componentC = MathOperationService.productoPunto(ocVector, ocVector) - Math.pow(radius, 2);
        double[] intersections = MathOperationService.solveQuadraticEquation(componentA, componentB, componentC);
        if (intersections.length == 2) {
            double nearestIntersection = Math.min(intersections[0], intersections[1]);
            double farthestIntersection = Math.max(intersections[0], intersections[1]);
            intersections[0] = nearestIntersection;
            intersections[1] = farthestIntersection;
        }
        return intersections;
    }

}
