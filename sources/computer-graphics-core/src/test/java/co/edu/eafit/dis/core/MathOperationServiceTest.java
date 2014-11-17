package co.edu.eafit.dis.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class MathOperationServiceTest
{

    @Test
    public void producto_punto() {
        // Arrange
        Vector aVector = new Vector(2, 2, 2);
        Vector bVector = new Vector(2, 2, 2);
        // Act
        Float actualEscalar = MathOperationService.productoPunto(aVector, bVector);
        // Assert
        assertEquals(0, actualEscalar, 1e2);
    }

    @Test
    public void producto_cruz() {
        // Arrange
        Vector aVector = new Vector(0, 0, 3);
        Vector bVector = new Vector(0, 3, -3);
        // Act
        Vector perpendicularVector = MathOperationService.productoCruz(aVector, bVector);
        // Assert
        assertEquals(-9, perpendicularVector.getX(), 1e2);
        assertEquals(0, perpendicularVector.getY(), 1e2);
        assertEquals(0, perpendicularVector.getZ(), 1e2);
    }

    @Test
    public void determinante_original() {
        // Arrange
        double[][] a3x3Matrix = new double[3][3];
        a3x3Matrix[0][0] = 3;
        a3x3Matrix[0][1] = 3;
        a3x3Matrix[0][2] = 3;
        a3x3Matrix[1][0] = -1;
        a3x3Matrix[1][1] = -1;
        a3x3Matrix[1][2] = 2;
        a3x3Matrix[2][0] = -1;
        a3x3Matrix[2][1] = 2;
        a3x3Matrix[2][2] = -1;
        // Act
        double actualDeterminant = MathOperationService.calcularDeterminante(a3x3Matrix);
        // Assert
        assertEquals(-27, actualDeterminant, 1e2);
    }

    @Test
    public void determinante_vector_i_modificado() {
        // Arrange
        double[][] a3x3Matrix = new double[3][3];
        a3x3Matrix[0][0] = 1;
        a3x3Matrix[0][1] = 3;
        a3x3Matrix[0][2] = 3;
        a3x3Matrix[1][0] = 0;
        a3x3Matrix[1][1] = -1;
        a3x3Matrix[1][2] = 2;
        a3x3Matrix[2][0] = 0;
        a3x3Matrix[2][1] = 2;
        a3x3Matrix[2][2] = -1;
        // Act
        double actualDeterminant = MathOperationService.calcularDeterminante(a3x3Matrix);
        // Assert
        assertEquals(-3, actualDeterminant, 1e2);
    }

    @Test
    public void determinante_vector_j_modificado() {
        // Arrange
        double[][] a3x3Matrix = new double[3][3];
        a3x3Matrix[0][0] = 3;
        a3x3Matrix[0][1] = 1;
        a3x3Matrix[0][2] = 3;
        a3x3Matrix[1][0] = -1;
        a3x3Matrix[1][1] = 0;
        a3x3Matrix[1][2] = 2;
        a3x3Matrix[2][0] = -1;
        a3x3Matrix[2][1] = 0;
        a3x3Matrix[2][2] = -1;
        // Act
        double actualDeterminant = MathOperationService.calcularDeterminante(a3x3Matrix);
        // Assert
        assertEquals(-3, actualDeterminant, 1e2);
    }

    @Test
    public void determinante_vector_k_modificado() {
        // Arrange
        double[][] a3x3Matrix = new double[3][3];
        a3x3Matrix[0][0] = 3;
        a3x3Matrix[0][1] = 3;
        a3x3Matrix[0][2] = 1;
        a3x3Matrix[1][0] = -1;
        a3x3Matrix[1][1] = -1;
        a3x3Matrix[1][2] = 0;
        a3x3Matrix[2][0] = -1;
        a3x3Matrix[2][1] = 2;
        a3x3Matrix[2][2] = 0;
        // Act
        double actualDeterminant = MathOperationService.calcularDeterminante(a3x3Matrix);
        // Assert
        assertEquals(1, actualDeterminant, 1e2);
    }

}
