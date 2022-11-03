package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Copied_BOJ_02636_Cheese {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cheeseCnt;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];

		int ans;
		for (ans = 0; isCheese(); ans++) {
			for (boolean[] arr : visited) { // initialization
				Arrays.fill(arr, false);
			}
			visited[0][0] = true;
			cheeseCnt = 0;

			DFS(0, 0);
		}

		System.out.println(ans + "\n" + cheeseCnt + "\n");

	}

	public static boolean isCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) { // 2 -> cheese contacting with air
					map[i][j] = 0;
				}
			}
		}

		// checking whether to be cheese
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	public static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				if (map[nx][ny] == 1) {
					map[nx][ny] = 2;
					cheeseCnt++; // the number of cheese to melt
				} else {
					DFS(nx, ny);
				}
			}
		}
	}

}

// reference: https://steady-coding.tistory.com/173