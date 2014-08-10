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
    private DrawService aDrawService;
    private TransformationService aTransformationService;
    private ReflectionTransformation aReflectionOverOrigin;
    private TranslationTransformation aTranslationOverOrigin;
    private List<Point> aVertexList;
    private List<Edge> aEdgeList;
    private int w;
    private int h;

    public void init(Graphics2D g2d, int w, int h) {
        aDrawService = new DrawService();
        aDrawService.setDrawAdapter(new DrawGraphics2DAdapter(g2d));

        aTransformationService = new TransformationService();
        aReflectionOverOrigin = new ReflectionTransformation();
        aReflectionOverOrigin.setReflectionOnX(true);
        aTranslationOverOrigin = new TranslationTransformation();
        aTranslationOverOrigin.setTranslationOnX(w / 2);
        aTranslationOverOrigin.setTranslationOnY(h / 2);
    }

    public void leerEspecificaciones() {
        /**
         * TODO: read files without absolute paths
         * */
        String fullPath = "E:\\_code\\repo-git\\computer-graphics\\sources\\recorte-de-lineas\\src\\main\\resources\\co\\edu\\eafit\\dis\\recorteDeLineas\\";
        String aFilePath = fullPath + "sample-one.txt";
        aVertexList = ComputerGraphicsRepository.getVertexFromFile(aFilePath);
        System.out.println(aVertexList.size());
        aEdgeList = ComputerGraphicsRepository.getEdgesFromFile(aFilePath, aVertexList);
        System.out.println(aEdgeList.size());
    }

    public void make() {
        Edge tempEdge;
        for (Edge anEdge : aEdgeList)
        {
            /**
             * TODO: implement Cohen-Sutherland
             * */
            aTransformationService.setTransformationFunction(aReflectionOverOrigin);
            tempEdge = aTransformationService.applyTransformation(anEdge);
            aTransformationService.setTransformationFunction(aTranslationOverOrigin);
            tempEdge = aTransformationService.applyTransformation(tempEdge);
            aDrawService.drawEdge(tempEdge);
        }
    }

}
