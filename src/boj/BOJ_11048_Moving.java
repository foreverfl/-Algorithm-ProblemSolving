package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_Moving {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = maze[0][0];

        for (int i = 1; i < M; i++) {
            dp[0][i] = maze[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = maze[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + maze[i][j];
            }
        }

        System.out.println(dp[N - 1][M - 1]);

        br.close();
    }
}
