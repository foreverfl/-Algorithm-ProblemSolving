package BOJ_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Copied_BOJ_02667_NumberingComplex_DFS {

	private static int dx[] = { 0, 0, 1, -1 };
	private static int dy[] = { 1, -1, 0, 0 };
	private static int[] aparts = new int[25 * 25];
	private static int N;
	private static int apartNum = 0;
	private static boolean[][] visited = new boolean[25][25];
	private static int[][] map = new int[25][25];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		// input
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					dfs(i, j);
				}
			}
		}

		Arrays.sort(aparts);
		System.out.println(apartNum);

		for (int i = 0; i < aparts.length; i++) {
			if (aparts[i] == 0) {
			} else {
				System.out.println(aparts[i]);
			}
		}

	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		aparts[apartNum]++; // A starting value is '1'.

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
	}
}
