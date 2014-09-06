package co.edu.eafit.dis.escenaEn3D;

import co.edu.eafit.dis.computherGraphicsAlgorithms.DrawGraphics2DAdapter;
import co.edu.eafit.dis.core.*;
import co.edu.eafit.dis.core.Point;
import co.edu.eafit.dis.core.transformations.ReflectionTransformation;
import co.edu.eafit.dis.core.transformations.TranslationTransformation;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Leer la descripción de un objeto 3D desde un archivo texto (mirar el ejemplo de la casita, que se anexa).
 * Poner el observador en el origen, mirando en la dirección -Z. El plano de proyección está en Z = -100.
 * Dibujar la proyección del objeto 3D sobre el plano de proyección.
 */
public class EscenaEn3D
{
    private Graphics2D g2d;
    private LineClippingService aLineClippingService;
    private TransformationService aTransformationService;
    private ReflectionTransformation aReflectionOverOrigin;
    private TranslationTransformation aTranslationOverOrigin;
    private DrawService aDrawService;
    private List<Point> aVertexList;
    private List<Edge> aEdgeList;
    private int projectionPlaneDistance;

    public void init(Graphics2D g2d, int w, int h) {
        this.g2d = g2d;
        this.projectionPlaneDistance = -100;

        aTransformationService = new TransformationService();
        aReflectionOverOrigin = new ReflectionTransformation();
        aReflectionOverOrigin.setReflectionOnX(true);
        aTranslationOverOrigin = new TranslationTransformation();
        aTranslationOverOrigin.setTranslationOnX(w / 2);
        aTranslationOverOrigin.setTranslationOnY(h / 2);

        aDrawService = new DrawService();
        aDrawService.setDrawAdapter(new DrawGraphics2DAdapter(g2d));

        ClippingArea aClippingArea = new ClippingArea(-250, 250, -250, 250);
        aLineClippingService = new LineClippingService(aClippingArea);
        pintarClippingArea();
    }

    public void leerEspecificaciones() {
        /**
         * TODO: read files without absolute paths
         * */
        String fullPath = "E:\\_code\\repo-git\\computer-graphics\\sources\\escena-en-3D\\src\\main\\resources\\co\\edu\\eafit\\dis\\escenaEn3D\\";
        String aFilePath = fullPath + "sample-one.txt";
        aVertexList = ComputerGraphicsRepository.get3DVertexFromFile(aFilePath);
        aEdgeList = ComputerGraphicsRepository.get3DEdgesFromFile(aFilePath, aVertexList);
    }

    public void make() {
        System.out.println("Vertex:");
        for (Point vertex : aVertexList)
        {
            System.out.println(vertex.getX() + "," + vertex.getY() + "," + vertex.getZ());
        }
        System.out.println(aEdgeList.size());

        PerspectiveService aPerspectiveService = new PerspectiveService();
        List<Edge> aProjectedEdgeList = new LinkedList<Edge>();
        for (Edge anEdge : aEdgeList)
        {
            Point newInitialPoint = aPerspectiveService.projectPointOverPlane(anEdge.getInitialPoint(), projectionPlaneDistance);
            Point newFinalPoint = aPerspectiveService.projectPointOverPlane(anEdge.getFinalPoint(), projectionPlaneDistance);
            Edge projectedEdge = new Edge(newInitialPoint, newFinalPoint);
            aProjectedEdgeList.add(projectedEdge);
        }

        g2d.setColor(Color.BLUE);
        Edge tempEdge;
        for (Edge anEdge : aProjectedEdgeList)
        {
            tempEdge = aLineClippingService.computeLine(anEdge);
            aTransformationService.setTransformationFunction(aReflectionOverOrigin);
            tempEdge = aTransformationService.applyTransformation(tempEdge);
            aTransformationService.setTransformationFunction(aTranslationOverOrigin);
            tempEdge = aTransformationService.applyTransformation(tempEdge);
            aDrawService.drawEdge(tempEdge);
        }
    }

    private void pintarClippingArea() {
        g2d.setColor(Color.BLACK);

        Edge aClippingEdge = new Edge(new Point(-250, 250), new Point(-250, -250));
        aTransformationService.setTransformationFunction(aReflectionOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aTransformationService.setTransformationFunction(aTranslationOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aDrawService.drawEdge(aClippingEdge);

        aClippingEdge = new Edge(new Point(250, 250), new Point(250, -250));
        aTransformationService.setTransformationFunction(aReflectionOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aTransformationService.setTransformationFunction(aTranslationOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aDrawService.drawEdge(aClippingEdge);

        aClippingEdge = new Edge(new Point(-250, 250), new Point(250, 250));
        aTransformationService.setTransformationFunction(aReflectionOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aTransformationService.setTransformationFunction(aTranslationOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aDrawService.drawEdge(aClippingEdge);

        aClippingEdge = new Edge(new Point(250, -250), new Point(-250, -250));
        aTransformationService.setTransformationFunction(aReflectionOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aTransformationService.setTransformationFunction(aTranslationOverOrigin);
        aClippingEdge = aTransformationService.applyTransformation(aClippingEdge);
        aDrawService.drawEdge(aClippingEdge);
    }

}
