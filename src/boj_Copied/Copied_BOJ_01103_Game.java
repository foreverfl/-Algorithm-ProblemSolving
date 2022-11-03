package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_01103_Game {

	static int[][] map, dp;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, M;
	static boolean isInfiniteLoop;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'H')
					map[i][j] = 10; // The hole is the '0'.
				else
					map[i][j] = str.charAt(j) - '0';
			}
		}

		dfs(0, 0, 1);

		if (!isInfiniteLoop)
			System.out.println(max);
		else
			System.out.println("-1");
	}

	private static void dfs(int x, int y, int cnt) {

		visited[x][y] = true;
		max = Math.max(max, cnt);
		dp[x][y] = cnt;

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] * map[x][y] + x;
			int ny = dy[i] * map[x][y] + y;

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 10)
				continue;
			if (visited[nx][ny]) {
				isInfiniteLoop = true;
				return;
			}
			if (dp[nx][ny] > cnt)
				continue;

			visited[nx][ny] = true;
			dfs(nx, ny, cnt + 1);
			visited[nx][ny] = false;
		}
	}

}

// reference: https://subbak2.tistory.com/7
