package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_OrdinaryBag {

    private static int[] weights;
    private static int[] values;

    public static void main(String[] agrs) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        weights = new int[N];
        values = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            weights[i] = W;
            values[i] = V;
        }
        System.out.println(knapsack(K));

    }

    private static int knapsack(int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int weight = weights[i - 1];
            int value = values[i - 1];

            for (int j = 1; j <= capacity; j++) { // 무게 제한까지 반복
                if (weight <= j) { // i번째 물건을 포함할 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value); // i번째 물건을 포함시킬 때와 포함시키지 않을 때 중 더 큰 가치를 선택하여 dp[i][j]에 저장
                } else { // i번째 물건을 포함할 수 없는 경우
                    dp[i][j] = dp[i - 1][j]; // 이전 상태를 그대로 가져옴
                }
            }

            // System.out.println("DP 배열 내부 (i = " + i + "):");
            // for (int k = 1; k <= n; k++) {
            //     for (int l = 1; l <= capacity; l++) {
            //         System.out.print(dp[k][l] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }

        return dp[n][capacity];
    }

    
}