package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_09465_Stickers {

	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			arr = new int[2][n + 1];
			dp = new int[2][n + 1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for (int a = 2; a <= n; a++) {
				dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
				dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
			}
			sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
		}

		System.out.println(sb.toString());
	}
}

// reference: https://youngest-programming.tistory.com/442