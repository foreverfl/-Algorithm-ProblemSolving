package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Copied_BOJ_16929_TwoDots {

	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N, M;
	static int x_start, y_start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				x_start = i;
				y_start = j;
				if (dfs(i, j, 1)) {
					System.out.println("Yes");
					return;
				}
			}
		}

		System.out.println("No");

	}

	public static boolean dfs(int x, int y, int cnt) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {

			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (map[x][y] != map[nx][ny])
				continue;

			if (!visited[nx][ny]) {
				if (dfs(nx, ny, cnt + 1))
					return true;
			} else {
				if (cnt >= 4 && x_start == nx && y_start == ny)
					return true;
			}
		}
		return false;
	}

}

// reference: https://moonsbeen.tistory.com/186
