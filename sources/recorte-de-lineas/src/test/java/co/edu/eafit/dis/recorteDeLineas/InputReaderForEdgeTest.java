package co.edu.eafit.dis.recorteDeLineas;

import co.edu.eafit.dis.core.ComputerGraphicsRepository;
import co.edu.eafit.dis.core.Edge;
import co.edu.eafit.dis.core.Point;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class InputReaderForEdgeTest
{
    final String fullPath = "E:\\_code\\repo-git\\computer-graphics\\sources\\recorte-de-lineas\\src\\test\\resources\\";

    @Test
    public void cuando_el_archivo_indica_que_hay_1_arista_el_conjunto_de_aristas_debe_contener_1_elemento() {
        // Arrange
        final int expectedEdgesSetSize = 1;
        List<Point> vertex = new LinkedList<Point>();
        vertex.add(new Point(0, 0));
        vertex.add(new Point(-1, -1));
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\caso-con-una-arista.txt";
        List<Edge> edges = ComputerGraphicsRepository.getEdgesFromFile(inputPath, vertex);
        // Assert
        assertEquals(expectedEdgesSetSize, edges.size());
    }

    @Test
    public void cuando_el_archivo_indica_que_hay_0_aristas_el_conjunto_de_aristas_debe_estar_vacio() {
        // Arrange
        final int expectedEdgesSetSize = 0;
        List<Point> vertex = null;
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\caso-sin-aristas.txt";
        List<Edge> edges = ComputerGraphicsRepository.getEdgesFromFile(inputPath, vertex);
        // Assert
        assertEquals(expectedEdgesSetSize, edges.size());
    }

    @Test
    public void cuando_el_archivo_indica_que_hay_5_aristas_el_conjunto_de_aristas_debe_contener_5_elementos() {
        // Arrange
        final int expectedEdgesSetSize = 5;
        List<Point> vertex = new LinkedList<Point>();
        vertex.add(new Point(-87, 14));
        vertex.add(new Point(987, -50));
        vertex.add(new Point(120, 0));
        vertex.add(new Point(20, 20));
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\caso-con-mas-de-una-arista.txt";
        List<Edge> edges = ComputerGraphicsRepository.getEdgesFromFile(inputPath, vertex);
        // Assert
        assertEquals(expectedEdgesSetSize, edges.size());
    }

    @Test
    public void cuando_el_archivo_no_esta_bien_formado_el_conjunto_de_aristas_es_vacio() {
        // Arrange
        final int expectedEdgesSetSize = 0;
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\ugly-input.txt";
        List<Edge> edges = ComputerGraphicsRepository.getEdgesFromFile(inputPath, null);
        // Assert
        assertEquals(expectedEdgesSetSize, edges.size());
    }

    @Test
    public void cuando_no_encuentra_un_archivo_el_conjunto_de_aristas_es_vacio() {
        // Arrange
        final int expectedEdgeSetSize = 0;
        // Act
        List<Edge> edges = ComputerGraphicsRepository.getEdgesFromFile("co\\edu\\eafit\\dis\\recorteDeLineas\\achivo_que_no_existe.txt", null);
        // Assert
        assertEquals(expectedEdgeSetSize, edges.size());
    }

}
