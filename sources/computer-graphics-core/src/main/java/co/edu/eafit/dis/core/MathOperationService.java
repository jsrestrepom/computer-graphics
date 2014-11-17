package co.edu.eafit.dis.core;

public class MathOperationService
{

    public static Vector normalizar(Vector aVector) {
        float factor = 1f / calcularMagnitud(aVector);
        Vector aNormalizeVector = multiplicarVectorPorEscalar(aVector, factor);
        return aNormalizeVector;
    }

    public static Float calcularMagnitud(Vector aVector) {
        float magnitud = (float) Math.sqrt(aVector.getX() * aVector.getX() + aVector.getY() * aVector.getY() + aVector.getZ() * aVector.getZ());
        return magnitud;
    }

    public static Vector multiplicarVectorPorEscalar(Vector aVector, float scalar) {
        float compX = aVector.getX() * scalar;
        float compY = aVector.getY() * scalar;
        float compZ = aVector.getZ() * scalar;
        return new Vector(compX, compY, compZ);
    }

    public static Float productoPunto(Vector aVector, Vector bVector) {
        return aVector.getX() * bVector.getX() + aVector.getY() * bVector.getY() + aVector.getZ() * bVector.getZ();
    }

    public static Double productoPunto(VectorOfDoubles aVector, VectorOfDoubles bVector) {
        return aVector.getX() * bVector.getX() + aVector.getY() * bVector.getY() + aVector.getZ() * bVector.getZ();
    }

    public static Vector productoCruz(Vector aVector, Vector bVector) {
        float xComp = aVector.getY() * bVector.getZ() - aVector.getZ() * bVector.getY();
        float yComp = -(aVector.getX() * bVector.getZ() - aVector.getZ() * bVector.getX());
        float zComp = aVector.getX() * bVector.getY() - aVector.getY() * bVector.getX();
        return new Vector(xComp, yComp, zComp);
    }

    public static Float[][] multiplicarMatrices(float[][] matrizA, float[][] matrizB) {
        Float[][] matrizC = new Float[4][4];
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                float acum = 0;
                for (int k = 0; k < 4; k++)
                {
                    acum += matrizA[i][k] * matrizB[k][j];
                }
                matrizC[i][j] = acum;
            }
        }
        return matrizC;
    }

    public static double calcularDeterminante(double[][] a3x3Matrix) {
        double acum = 0d;
        acum += a3x3Matrix[0][0] * (a3x3Matrix[1][1] * a3x3Matrix[2][2] - a3x3Matrix[1][2] * a3x3Matrix[2][1]);
        acum -= a3x3Matrix[0][1] * (a3x3Matrix[1][0] * a3x3Matrix[2][2] - a3x3Matrix[1][2] * a3x3Matrix[2][0]);
        acum += a3x3Matrix[0][2] * (a3x3Matrix[1][0] * a3x3Matrix[2][1] - a3x3Matrix[1][1] * a3x3Matrix[2][0]);
        return acum;
    }

    public static double[] solveQuadraticEquation(double a, double b, double c) {
        double[] solution;
        double discriminant = Math.pow(b, 2) - (4 * a * c);
        if (discriminant > 0)
        {
            solution = new double[2];
            double rootOne = (-b + Math.sqrt(discriminant)) / (2 * a);
            double rootTwo = (-b - Math.sqrt(discriminant)) / (2 * a);
            solution[0] = rootOne;
            solution[1] = rootTwo;
        }
        else if (discriminant == 0)
        {
            solution = new double[1];
            double root = -b / (2 * a);
            solution[0] = root;
        }
        else
        {
            solution = new double[0];
        }
        return solution;
    }

}
