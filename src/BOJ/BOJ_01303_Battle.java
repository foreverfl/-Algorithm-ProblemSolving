package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01303_Battle {

	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int M, N;
	static int cnt_W, cnt_B, ans_W, ans_B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // horizontal
		M = Integer.parseInt(st.nextToken()); // vertical

		map = new char[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'W' && !visited[i][j]) {
					dfs_W(i, j);
					ans_W += Math.pow(cnt_W, 2);
					cnt_W = 0;
				}

				if (map[i][j] == 'B' && !visited[i][j]) {
					dfs_B(i, j);
					ans_B += Math.pow(cnt_B, 2);
					cnt_B = 0;
				}
			}
		}

		System.out.println(ans_W + " " + ans_B);
	}

	private static void dfs_W(int x, int y) {
		visited[x][y] = true;
		cnt_W++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (!visited[nx][ny] && map[nx][ny] == 'W')
					dfs_W(nx, ny);

			}
		}
	}

	private static void dfs_B(int x, int y) {
		visited[x][y] = true;
		cnt_B++;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (!visited[nx][ny] && map[nx][ny] == 'B')
					dfs_B(nx, ny);

			}
		}
	}

}
