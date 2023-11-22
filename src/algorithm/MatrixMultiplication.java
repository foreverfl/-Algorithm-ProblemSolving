package algorithm;

public class MatrixMultiplication {
    public static final long MOD = 1000000007;

    public static void main(String[] args) {
        // 2x2 행렬 곱셈
        long[][] matrix2x2_1 = { { 1, 2 }, { 3, 4 } };
        long[][] matrix2x2_2 = { { 2, 0 }, { 1, 2 } };
        long[][] result2x2 = matrixMultiply(matrix2x2_1, matrix2x2_2, 2);

        System.out.println("2x2 Matrix Result:");
        printMatrix(result2x2);

        // 3x3 행렬 곱셈
        long[][] matrix3x3_1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        long[][] matrix3x3_2 = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        long[][] result3x3 = matrixMultiply(matrix3x3_1, matrix3x3_2, 3);

        System.out.println("3x3 Matrix Result:");
        printMatrix(result3x3);

        // 4x4 행렬 곱셈
        long[][] matrix4x4_1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        long[][] matrix4x4_2 = { { 16, 15, 14, 13 }, { 12, 11, 10, 9 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 } };
        long[][] result4x4 = matrixMultiply(matrix4x4_1, matrix4x4_2, 4);

        System.out.println("4x4 Matrix Result:");
        printMatrix(result4x4);
    }

    public static long[][] matrixMultiply(long[][] m1, long[][] m2, int size) {
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) { // result 행
            for (int j = 0; j < size; j++) { // result 열
                for (int k = 0; k < size; k++) {
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
