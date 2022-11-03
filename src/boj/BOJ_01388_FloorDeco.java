package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01388_FloorDeco {

	static char[][] map;
	static boolean[][] visited;
	static int[] d = { -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '|' && !visited[i][j]) {
					ans++;
					dfs_vertical(i, j);

				}

				if (map[i][j] == '-' && !visited[i][j]) {
					ans++;
					dfs_horizontal(i, j);

				}
			}
		}

		System.out.println(ans);

	}

	private static void dfs_vertical(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 2; i++) {
			int nx = x + d[i];
			int ny = y;

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (!visited[nx][ny] && map[nx][ny] == '|') {
				dfs_vertical(nx, ny);
			}
		}
	}

	private static void dfs_horizontal(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 2; i++) {
			int nx = x;
			int ny = y + d[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (!visited[nx][ny] && map[nx][ny] == '-') {
				dfs_horizontal(nx, ny);
			}
		}
	}

}
