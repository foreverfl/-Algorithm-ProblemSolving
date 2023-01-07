package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16395_PascalsTriangle {

	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dp = new int[n + 1][n + 1];

		int lastIdx = 1;
		for (int i = 1; i <= n; i++) {
			dp[i][1] = 1;
			dp[i][lastIdx++] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		System.out.println(dp[n][k]);

	}

}
