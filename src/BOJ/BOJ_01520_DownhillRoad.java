package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01520_DownhillRoad {

	static int[][] map, dp;
	static int[] dX = { 0, 0, -1, 1 };
	static int[] dY = { -1, 1, 0, 0 };
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));

	}

	private static int dfs(int x, int y) {
		if (x == M && y == N)
			return 1;

		if (dp[x][y] != -1)
			return dp[x][y];

		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];

			if (nX < 0 || nY < 0 || nX >= M || nY >= N)
				continue;
			if (map[nX][nY] < map[x][y]) {
				dp[x][y] += dfs(nX, nY);
			}
		}
		return dp[x][y];

	}

}
