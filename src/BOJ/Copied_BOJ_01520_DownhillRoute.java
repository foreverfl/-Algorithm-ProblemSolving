package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01520_DownhillRoute {

	private static int[][] map;
	private static int[][] dp;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int M, N;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(reader.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M + 1][N + 1];
		dp = new int[M + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(1, 1));

	}

	private static int dfs(int x, int y) {

		if (x == M && y == N) { // When arrived.

			return 1;

		}

		if (dp[x][y] != -1) { // This case is already visited.

			return dp[x][y];

		} else {

			dp[x][y] = 0; // visited case is changed to '0'.

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || ny < 1 || nx > M || ny > N) {
					continue;
				}

				if (map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
			}

		}

		return dp[x][y];
	}
}

// reference: https://hidelookit.tistory.com/171