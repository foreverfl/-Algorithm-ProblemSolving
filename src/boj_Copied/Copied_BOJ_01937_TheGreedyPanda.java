package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01937_TheGreedyPanda {

	static int[][] map;
	static int[][] dp;
	static int[] range_x = { 0, 0, -1, 1 };
	static int[] range_y = { -1, 1, 0, 0 };
	static int n, cnt, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}

		System.out.println(max);
	}

	private static int dfs(int x, int y) {
		if (dp[x][y] != 0) {
			return dp[x][y];
		}

		dp[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int dx = x + range_x[i];
			int dy = y + range_y[i];

			if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
				if (map[x][y] < map[dx][dy]) {

					dp[x][y] = Math.max(dp[x][y], dfs(dx, dy) + 1);
					dfs(dx, dy);

				}
			}
		}
		return dp[x][y];
	}
}

// reference: https://steady-coding.tistory.com/39
