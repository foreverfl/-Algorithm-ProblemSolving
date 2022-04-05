package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_01486_Hiking {

	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;
	static int[][] time_spent;
	static int[][] height;
	static int N, M, T, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // tall_possible
		D = Integer.parseInt(st.nextToken()); // dinner

		map = new char[N][M];
		visited = new boolean[N][M];
		time_spent = new int[N][M];
		height = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				time_spent[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// to height
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				height[i][j] = charToInt(map[i][j]);
			}
		}

		// spent time
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(0, 0, i, j, 0);
				visited = new boolean[N][M];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%2d ", height[i][j]);
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%3d ", time_spent[i][j]);
			}
			System.out.println();
		}
	}

	private static void dfs(int x, int y, int target_x, int target_y, int time) {
		if (x == target_x && y == target_y) {

			time_spent[target_x][target_y] = Math.min(time_spent[target_x][target_y], time);
			return;
		}

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {

				int gap = Math.abs(height[nx][ny] - height[x][y]);
				int time_needed = (int) Math.pow(gap, 2);

				if (!visited[nx][ny] && height[nx][ny] > height[x][y]) {

					dfs(nx, ny, target_x, target_y, time + time_needed);

				} else if (!visited[nx][ny] && height[nx][ny] <= height[x][y]) {

					dfs(nx, ny, target_x, target_y, time + 1);

				} else if (!visited[nx][ny] & gap > T) {

					continue;
				}
			}
		}
	}

	private static int charToInt(char input) {
		int result = 0;
		if (input >= 'A' && input <= 'Z') {
			result = input - 'A';
		} else if (input >= 'a' && input <= 'z') {
			result = input - 'a' + 26;
		}
		return result;
	}

}

// reference: https://dev-gorany.tistory.com/142
