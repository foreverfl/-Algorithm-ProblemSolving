package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solving_7927_PattyPattyBurger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 패티의 최소 장수
        int K = Integer.parseInt(input[1]); // 버거의 최대 개수
        int M = Integer.parseInt(br.readLine());

        int[][] burgers = new int[M][2];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int patty = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);
            burgers[i] = new int[] { patty, price };

        }

        int Q = Integer.parseInt(br.readLine());
        System.out.println(minCostBurgers(N, K, burgers, Q));

    }

    public static int minCostBurgers(int N, int K, int[][] burgers, int additionalCost) {
        // 초기화
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int[] burger : burgers) {
                    int patty = burger[0];
                    int cost = burger[1];
                    if (j >= patty && dp[i - 1][j - patty] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - patty] + cost);
                    }
                }
                if (j > 0 && dp[i][j - 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + additionalCost);
                }
            }
        }

        return dp[K][N] == Integer.MAX_VALUE ? -1 : dp[K][N];
    }
}
