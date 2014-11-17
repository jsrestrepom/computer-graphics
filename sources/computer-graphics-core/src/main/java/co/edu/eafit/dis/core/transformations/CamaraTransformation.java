package co.edu.eafit.dis.core.transformations;

import co.edu.eafit.dis.core.MathOperationService;
import co.edu.eafit.dis.core.Point;
import co.edu.eafit.dis.core.TransformationFunction;
import co.edu.eafit.dis.core.Vector;

public class CamaraTransformation implements TransformationFunction
{
    private float[][] matrix;

    public CamaraTransformation(Point lookAt, Vector camara, Vector upVector) {
        Vector nVector = MathOperationService.productoCruz(new Vector(lookAt.getX(), lookAt.getY(), lookAt.getZ()), camara);
//        Vector nVector = MathOperationService.productoCruz(camara, lookAt);
        Vector nVectorNormalize = MathOperationService.normalizar(nVector);

        Vector uVector = MathOperationService.productoCruz(upVector, nVectorNormalize);
        Vector uVectorNormalize = MathOperationService.normalizar(uVector);

        Vector vVector = MathOperationService.productoCruz(nVectorNormalize, uVectorNormalize);
        Vector vVectorNormalize = MathOperationService.normalizar(vVector);

        matrix = new float[4][4];
        matrix[3][3] = 1;
        matrix[0][0] = uVectorNormalize.getX();
        matrix[0][1] = uVectorNormalize.getZ();
        matrix[0][2] = uVectorNormalize.getZ();
        matrix[0][3] = -MathOperationService.productoPunto(uVectorNormalize, camara);
        matrix[1][0] = vVectorNormalize.getX();
        matrix[1][1] = vVectorNormalize.getY();
        matrix[1][2] = vVectorNormalize.getZ();
        matrix[1][3] = -MathOperationService.productoPunto(vVectorNormalize, camara);
        matrix[2][0] = nVectorNormalize.getX();
        matrix[2][1] = nVectorNormalize.getY();
        matrix[2][2] = nVectorNormalize.getZ();
        matrix[2][3] = -MathOperationService.productoPunto(nVectorNormalize, camara);

        System.out.println("En uvn: matriz es: " + matrix.toString());
        String s = new String();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                s += " " + matrix[i][j] + " ";
            }
            s += "\n";
        }
        System.out.println(s);
    }

    public Point apply(Point aPoint) {
        float[][] matrixB = new float[4][4];
        matrixB[0][0] = aPoint.getX();
        matrixB[1][0] = aPoint.getY();
        matrixB[2][0] = aPoint.getZ();
        matrixB[3][0] = 1;
        Float[][] matrixC = MathOperationService.multiplicarMatrices(matrix, matrixB);
        return new Point(matrixC[0][0].intValue(), matrixC[1][0].intValue(), matrixC[2][0].intValue());
    }

}
