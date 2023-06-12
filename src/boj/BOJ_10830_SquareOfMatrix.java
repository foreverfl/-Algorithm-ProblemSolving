package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10830_SquareOfMatrix {
    public static final int MOD = 1000;
    public static int[][] matrix;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        Long B = Long.parseLong(tmp[1]);

        matrix = new int[N][N];
        for(int i = 0; i < N; i++) {
            tmp = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int[][] result = power(matrix, B);

        // 결과 행렬 출력
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
     

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + matrix1[i][k] * matrix2[k][j]) % MOD;;
                }
            }
        }

        return result;
    }

    public static int[][] power(int[][] matrix, long exponent) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        if (exponent == 0) { // 항등 행렬 반환
            for (int i = 0; i < n; i++) {
                result[i][i] = 1;
            }
            return result;
        }

        if (exponent == 1) { // 원래 행렬 반환
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] %= MOD;
                }
            }   
            return matrix;
        }

       if (exponent % 2 == 0) { // 지수가 짝수인 경우 절반으로 분할하여 제곱
            int[][] halfPower = power(matrix, exponent / 2);
            result = multiplyMatrices(halfPower, halfPower);
        }
       
        else { // 지수가 홀수인 경우 한 번 뺀 뒤 절반으로 분할하여 제곱
            int[][] halfPower = power(matrix, (exponent - 1) / 2);
            result = multiplyMatrices(matrix, multiplyMatrices(halfPower, halfPower));
        }

        return result;
    }
}
