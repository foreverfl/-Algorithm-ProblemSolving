package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_14502_Laboratory {

	static class virus {
		int x, y;

		virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;

	static int[][] map;
	static int[][] copy_map;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy_map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		copy_map = map;

		DFS(0);

		System.out.println(result);
	}

	private static void DFS(int depth) {
		// spreading virus
		if (depth == 3) {
			BFS();
			return;
		}

		// building walls
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {

					map[i][j] = 1;
					DFS(depth + 1);

					map[i][j] = 0; // initialization
				}
			}
		}
	}

	private static void BFS() {

		int[][] virus_map = new int[N][M];
		Queue<virus> que = new LinkedList<virus>();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				virus_map[i][j] = map[i][j];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (virus_map[i][j] == 2)
					que.add(new virus(i, j));

		while (!que.isEmpty()) {
			virus v = que.remove();

			for (int d = 0; d < 4; d++) {
				int nx = v.x + dx[d];
				int ny = v.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (virus_map[nx][ny] == 0) {
						virus_map[nx][ny] = 2;
						que.add(new virus(nx, ny));
					}
				}
			}
		}
		safeArea(virus_map);
	}

	private static void safeArea(int[][] virus_map) {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virus_map[i][j] == 0)
					count++;
			}
		}

		result = Math.max(count, result);
	}
}

// reference: https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14502%EB%B2%88-%EC%97%B0%EA%B5%AC%EC%86%8C-%EC%9E%90%EB%B0%94Java
