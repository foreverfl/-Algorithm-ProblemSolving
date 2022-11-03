package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01783_WeakKnight {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				dfs(i, j);
			}
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if (visited[nx][ny] == false) {
					dfs(nx, ny);
				}
			}
		}
	}

}
