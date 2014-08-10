package co.edu.eafit.dis.core;

public class TransformationService
{
    private TransformationFunction transformationFunction;

    public void setTransformationFunction(TransformationFunction transformationFunction) {
        this.transformationFunction = transformationFunction;
    }

    public TransformationFunction getTransformationFunction() {
        return transformationFunction;
    }

    public Point applyTransformation(Point aPoint) {
        return transformationFunction.apply(aPoint);
    }

    public Edge applyTransformation(Edge anEdge) {
        Point newInitialPoint = transformationFunction.apply(anEdge.getInitialPoint());
        Point newFinalPoint = transformationFunction.apply(anEdge.getFinalPoint());
        return new Edge(newInitialPoint, newFinalPoint);
    }
}
