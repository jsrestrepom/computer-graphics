package co.edu.eafit.dis.recorteDeLineas;

import co.edu.eafit.dis.computherGraphicsAlgorithms.DrawGraphics2DAdapter;
import co.edu.eafit.dis.core.*;
import co.edu.eafit.dis.core.Point;
import co.edu.eafit.dis.core.transformations.ReflectionTransformation;
import co.edu.eafit.dis.core.transformations.TranslationTransformation;

import java.awt.*;
import java.util.List;

public class RecorteDeLineas
{
    private Graphics2D g2d;
    private LineClippingService aLineClippingService;
    private TransformationService aTransformationService;
    private ReflectionTransformation aReflectionOverOrigin;
    private TranslationTransformation aTranslationOverOrigin;
    private DrawService aDrawService;
    private List<Point> aVertexList;
    private List<Edge> aEdgeList;
    private int w;
    private int h;

    public void init(Graphics2D g2d, int w, int h) {
        this.g2d = g2d;

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
        String fullPath = "E:\\_code\\repo-git\\computer-graphics\\sources\\recorte-de-lineas\\src\\main\\resources\\co\\edu\\eafit\\dis\\recorteDeLineas\\";
//        String aFilePath = fullPath + "sample-one.txt";
        String aFilePath = fullPath + "sample-two.txt";
//        String aFilePath = fullPath + "sample-three.txt";
        aVertexList = ComputerGraphicsRepository.getVertexFromFile(aFilePath);
        aEdgeList = ComputerGraphicsRepository.getEdgesFromFile(aFilePath, aVertexList);
    }

    public void make() {
        g2d.setColor(Color.BLUE);
        Edge tempEdge;
        for (Edge anEdge : aEdgeList)
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
