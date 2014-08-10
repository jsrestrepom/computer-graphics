package co.edu.eafit.dis.recorteDeLineas;

import co.edu.eafit.dis.core.ComputerGraphicsRepository;
import co.edu.eafit.dis.core.Point;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public final class InputReaderForVertexTest
{
    final String fullPath = "E:\\_code\\repo-git\\computer-graphics\\sources\\recorte-de-lineas\\src\\test\\resources\\";

    @Test
    public void cuando_el_archivo_indica_que_hay_1_vertice_el_conjunto_de_vertices_debe_contener_1_elemento() {
        // Arrange
        final int expectedVertexSetSize = 1;
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\caso-con-un-vertice.txt";
        List<Point> vertex = ComputerGraphicsRepository.getVertexFromFile(inputPath);
        // Assert
        assertEquals(expectedVertexSetSize, vertex.size());
    }

    @Test
    public void cuando_el_archivo_indica_que_hay_0_vertices_el_conjunto_de_vertices_debe_estar_vacio() {
        // Arrange
        final int expectedVertexSetSize = 0;
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\caso-sin-vertices.txt";
        List<Point> vertex = ComputerGraphicsRepository.getVertexFromFile(inputPath);
        // Assert
        assertEquals(expectedVertexSetSize, vertex.size());
    }

    @Test
    public void cuando_el_archivo_indica_que_hay_5_vertices_el_conjunto_de_vertices_debe_contener_5_elementos() {
        // Arrange
        final int expectedVertexSetSize = 5;
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\caso-con-mas-de-un-vertice.txt";
        List<Point> vertex = ComputerGraphicsRepository.getVertexFromFile(inputPath);
        // Assert
        assertEquals(expectedVertexSetSize, vertex.size());
    }

    @Test
    public void cuando_el_archivo_no_esta_bien_formado_el_conjunto_de_vertices_es_vacio() {
        // Arrange
        final int expectedVertexSetSize = 0;
        // Act
        String inputPath = fullPath + "co\\edu\\eafit\\dis\\recorteDeLineas\\ugly-input.txt";
        List<Point> vertex = ComputerGraphicsRepository.getVertexFromFile(inputPath);
        // Assert
        assertEquals(expectedVertexSetSize, vertex.size());
    }

    @Test
    public void cuando_no_encuentra_un_archivo_el_conjunto_de_vertices_es_vacio() {
        // Arrange
        final int expectedVertexSetSize = 0;
        // Act
        List<Point> vertex = ComputerGraphicsRepository.getVertexFromFile("co\\edu\\eafit\\dis\\recorteDeLineas\\achivo_que_no_existe.txt");
        // Assert
        assertEquals(expectedVertexSetSize, vertex.size());
    }

}
