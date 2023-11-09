package algorithm;

public class MatrixExponentiation {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 1 }, { 1, 0 } }; // 피보나치 수열을 계산하기 위한 기본 행렬
        int n = 5; // 거듭제곱할 횟수

        int[][] result = matrixPower(matrix, n);
        printMatrix(result);
    }

    // 행렬 거듭제곱을 수행하는 함수
    public static int[][] matrixPower(int[][] matrix, int n) {
        int[][] result = { { 1, 0 }, { 0, 1 } }; // 단위 행렬로 초기화

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiplyMatrices(result, matrix);
            }
            matrix = multiplyMatrices(matrix, matrix);
            n /= 2;
        }

        return result;
    }

    // 두 행렬을 곱하는 함수
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    // 행렬을 출력하는 함수
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
