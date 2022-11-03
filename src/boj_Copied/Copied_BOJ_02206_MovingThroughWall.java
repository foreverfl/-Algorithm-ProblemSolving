package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copied_BOJ_02206_MovingThroughWall {

	static class Coordinate {
		int x;
		int y;
		int cnt;
		boolean destroyed;

		public Coordinate(int x, int y, int cnt, boolean destroyed) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroyed = destroyed;
		}
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		Queue<Coordinate> queue = new LinkedList<>();
		queue.add(new Coordinate(0, 0, 1, false));

		// 0 -> There is not a wall.
		// 1 -> There is a wall.
		boolean[][][] visited = new boolean[N][M][2];

		while (!queue.isEmpty()) {
			Coordinate now = queue.poll();

			if (now.x == N - 1 && now.y == M - 1) {
				System.out.println(now.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				int next_cnt = now.cnt + 1;

				if (map[nx][ny] == '0') { // If there is no wall.
					if (!now.destroyed && !visited[nx][ny][0]) {
						queue.add(new Coordinate(nx, ny, next_cnt, false));
						visited[nx][ny][0] = true;
					} else if (now.destroyed && !visited[nx][ny][1]) {
						queue.add(new Coordinate(nx, ny, next_cnt, true));
						visited[nx][ny][1] = true;
					}

				} else if (map[nx][ny] == '1') { // If there is a wall.

					if (!now.destroyed) {
						queue.add(new Coordinate(nx, ny, next_cnt, true));
						visited[nx][ny][1] = true;
					}
				}
			}

		}

		System.out.println(-1);
	}
}

// reference: https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-2206-%EB%B2%BD-%EB%B6%80%EC%88%98%EA%B3%A0-%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0-JAVA%EC%9E%90%EB%B0%94
