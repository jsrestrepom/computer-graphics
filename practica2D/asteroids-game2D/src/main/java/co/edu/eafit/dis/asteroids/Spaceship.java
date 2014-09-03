package co.edu.eafit.dis.asteroids;

import co.edu.eafit.dis.computherGraphicsAlgorithms.DrawGraphics2DAdapter;
import co.edu.eafit.dis.core.*;
import co.edu.eafit.dis.core.Point;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Spaceship extends Entity
{
    private Point position;
    private List<Edge> edges;
    private Color color;
    private TransformationRepository aTransformationRepository;
    private int moveSpeed = 2;

    public Spaceship() {
        edges = new LinkedList<Edge>();
    }

    public List<Edge> getFigure() {
        return edges;
    }

    public Color getColor() {
        return color;
    }

    public void create(TransformationRepository aTransformationRepository) {
        this.aTransformationRepository = aTransformationRepository;
        int x = 0;
        int y = -250;
        position = new Point(x, y);
        color = Color.RED;
        refresh();
    }

    public void refresh() {
        Point pointA = new Point(position.getX(), position.getY());
        Point pointB = new Point(position.getX() + 5, position.getY() - 5);
        Point pointC = new Point(position.getX() - 5, position.getY() - 5);
        Point pointD = new Point(position.getX() + 5, position.getY() + 5);
        Point pointE = new Point(position.getX() - 5, position.getY() + 5);
        Point pointF = new Point(position.getX() + 2, position.getY() + 8);
        Point pointG = new Point(position.getX() - 2, position.getY() + 8);

        edges.clear();
        Edge sampleEdge = new Edge(position, position);
        edges.add(sampleEdge);
        Edge frontalEdge = new Edge(pointF, pointG);
        edges.add(frontalEdge);
        Edge frontalRightEdge = new Edge(pointD, pointF);
        edges.add(frontalRightEdge);
        Edge rightEdge = new Edge(pointB, pointD);
        edges.add(rightEdge);
        Edge backRightEdge = new Edge(pointA, pointB);
        edges.add(backRightEdge);
        Edge frontalLeftEdge = new Edge(pointE, pointG);
        edges.add(frontalLeftEdge);
        Edge leftEdge = new Edge(pointC, pointE);
        edges.add(leftEdge);
        Edge backLeftEdge = new Edge(pointA, pointC);
        edges.add(backLeftEdge);
    }

    public void move(long delta) {
        super.move(delta);
    }

    public void draw(Graphics2D g2d) {
        Color backupColor = g2d.getColor();
        g2d.setColor(color);
        DrawService aDrawService = new DrawService();
        aDrawService.setDrawAdapter(new DrawGraphics2DAdapter(g2d));
        TransformationService aTransformationService = new TransformationService();
        Edge tempEdge;
        for (Edge anEdge : edges)
        {
            tempEdge = anEdge;
            aTransformationService.setTransformationFunction(aTransformationRepository.getReflectionTransformation());
            tempEdge = aTransformationService.applyTransformation(tempEdge);
            aTransformationService.setTransformationFunction(aTransformationRepository.getTranslationTransformation());
            tempEdge = aTransformationService.applyTransformation(tempEdge);
            aDrawService.drawEdge(tempEdge);
        }
        g2d.setColor(backupColor);
    }

    public void moveTo(Control control) {
        int direction;
        switch (control)
        {
            case LEFT:
                direction = -1;
                break;
            case RIGHT:
                direction = 1;
                break;
            default:
                direction = 0;
        }
        position.setX(position.getX() + (moveSpeed * direction));
        refresh();
    }
}
