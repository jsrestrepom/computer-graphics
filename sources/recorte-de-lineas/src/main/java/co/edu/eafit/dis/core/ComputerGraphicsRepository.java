package co.edu.eafit.dis.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ComputerGraphicsRepository
{

    public static List<Point> getVertexFromFile(String aFilePath) {
        Scanner aScanner;
        try
        {
            aScanner = new Scanner(new File(aFilePath));
        } catch (FileNotFoundException e)
        {
            return new LinkedList<Point>();
        }
        jumpToNextSection(aScanner);
        List<Point> vertex = new LinkedList<Point>();
        int x, y;
        try
        {
            int nVertex = aScanner.nextInt();
            for (int i = 0; i < nVertex; i++)
            {
                x = aScanner.nextInt();
                y = aScanner.nextInt();
                vertex.add(new Point(x, y));
            }
        } catch (InputMismatchException e)
        {
            vertex = new LinkedList<Point>();
        }
        return vertex;
    }

    public static List<Edge> getEdgesFromFile(String aFilePath, List<Point> aVertexList) {
        Scanner aScanner;
        try
        {
            aScanner = new Scanner(new File(aFilePath));
        } catch (FileNotFoundException e)
        {
            return new LinkedList<Edge>();
        }
        jumpToNextSection(aScanner);
        jumpToNextSection(aScanner);
        List<Edge> edges = new LinkedList<Edge>();
        Point aPoint, bPoint;
        try
        {
            int nEdges = aScanner.nextInt();
            for (int i = 0; i < nEdges; i++)
            {
                aPoint = aVertexList.get(aScanner.nextInt());
                bPoint = aVertexList.get(aScanner.nextInt());
                edges.add(new Edge(aPoint, bPoint));
            }
        } catch (InputMismatchException e)
        {
            edges = new LinkedList<Edge>();
        }
        return edges;
    }

    private static void jumpToNextSection(Scanner sc) {
        while (!sc.nextLine().contains("----------")) ;
    }
}
