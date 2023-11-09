package CodingMasters_2;

import java.util.Scanner;

public class _7936_mould {

    public static final long MOD = 1000000007L;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long N = sc.nextLong();
            System.out.println(fungusCount(N));
        }

    }

    public static long fungusCount(long n) {
        long[][] matrix = { { 1, 1 }, { 1, 0 } }; // 피보나치 수열의 시작 행렬
        long[][] result = matrixPower(matrix, n);
        return (result[0][1] + result[1][1]) % MOD;
    }

    public static long[][] matrixPower(long[][] matrix, long n) {
        long[][] result = { { 1, 0 }, { 0, 1 } }; // 단위 행렬
        while (n > 0) {
            if (n % 2 == 1) {
                result = matrixMultiply(result, matrix);
            }
            n /= 2;
            matrix = matrixMultiply(matrix, matrix);
        }
        return result;
    }

    public static long[][] matrixMultiply(long[][] m1, long[][] m2) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + m1[i][k] * m2[k][j]) % MOD;
                }
            }
        }
        return result;
    }

}
