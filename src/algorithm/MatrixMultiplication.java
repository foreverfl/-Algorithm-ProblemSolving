package algorithm;

public class MatrixMultiplication {
    public static final long MOD = 1000000007;

    public static void main(String[] args) {
        long[][] m1 = { { 1, 2 }, { 3, 4 } };
        long[][] m2 = { { 2, 0 }, { 1, 2 } };

        long[][] result = matrixMultiply(m1, m2);

        System.out.println("Result:");
        printMatrix(result);
    }

    public static long[][] matrixMultiply(long[][] m1, long[][] m2) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) { // result 행
            for (int j = 0; j < 2; j++) { // result 열
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    long multiplication = m1[i][k] * m2[k][j];
                    result[i][j] = (result[i][j] + multiplication) % MOD;
                }
            }
        }
        return result;
    }

    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
