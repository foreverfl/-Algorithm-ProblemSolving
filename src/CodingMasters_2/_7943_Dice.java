package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _7943_Dice {
    public static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N <= 4) {
            System.out.println((1 << (N - 1)) % MOD);
            return;
        }

        long[][] result = powerMatrix(N - 4);
        long answer = (result[0][0] * 8 + result[0][1] * 4 + result[0][2] * 2 + result[0][3]) % MOD;
        System.out.println(answer);
    }

    public static long[][] powerMatrix(long exponent) {
        long[][] matrix = { { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
        long[][] result = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = multiplyMatrices(result, matrix);
            }
            matrix = multiplyMatrices(matrix, matrix);
            exponent /= 2;
        }

        return result;
    }

    public static long[][] multiplyMatrices(long[][] m1, long[][] m2) {
        long[][] result = new long[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    result[i][j] = (result[i][j] + m1[i][k] * m2[k][j]) % MOD;
                }
            }
        }

        return result;
    }

    public static void dp() {
        int N = Integer.parseInt("10");
        long[] dp = new long[N + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }
    }

}
