package CodingMasters_2;

import java.util.Scanner;

public class Solving_7947_ChristmasPresent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }

        scanner.close();

        long result = calculateMaxSweetness(N, A, B);
        System.out.println(result);
    }

    public static long sweetness(int A, int B, int days) {
        return (long) A + (long) days * B;
    }

    public static long calculateMaxSweetness(int N, int[] A, int[] B) {
        long[][] dp = new long[N][N];

        for (int len = 0; len < N; len++) {
            for (int i = 0; i < N; i++) { // 초콜릿의 시작 위치
                int j = (i + len) % N; // 초콜릿의 끝 위치
                if (len == 0) {
                    dp[i][j] = sweetness(A[i], B[i], len);
                } else {
                    int next_i = (i + 1) % N;
                    int prev_j = (j - 1 + N) % N;
                    dp[i][j] = Math.max(
                            sweetness(A[i], B[i], len) + dp[next_i][j],
                            sweetness(A[j], B[j], len) + dp[i][prev_j]);
                }
            }
        }

        // 최대 달콤함을 찾음
        long maxSweetness = 0;
        for (int i = 0; i < N; i++) {
            maxSweetness = Math.max(maxSweetness, dp[i][(i + N - 1) % N]);
        }

        return maxSweetness;
    }

}