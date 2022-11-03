package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16174_JumpKingJelly_Large {

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static boolean success = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		if (success)
			System.out.println("HaruHaru");
		else
			System.out.println("Hing");
	}

	public static void dfs(int x, int y) {
		if (map[x][y] == -1) {
			success = true;
		}

		visited[x][y] = true;
		int dis = map[x][y];

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				int nx = x;
				int ny = y + dis;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (visited[nx][ny])
					continue;

				dfs(nx, ny);

			} else {

				int nx = x + dis;
				int ny = y;

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (visited[nx][ny])
					continue;

				dfs(nx, ny);
			}
		}

	}

}
