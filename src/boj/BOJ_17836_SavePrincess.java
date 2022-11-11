package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836_SavePrincess {
	/*
	 * 1. 그람을 거친 후 공주님한테 가는 루트를 계산
	 * 2. 바로 공주님한테 가는 루트를 계산
	 * 3. 1과 2중 작은 값을 출력
	 * 4. 1과 2가 둘 다 제한 시간을 넘으면 Fail 출력
	 */

	private static class Warrior {
		int x;
		int y;
		int time;

		public Warrior(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Warrior [x=" + x + ", y=" + y + ", time=" + time + "]";
		}

	}

	private static int N, M, T;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static int res = Integer.MAX_VALUE, resWithSword = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N + 1][M + 1];
		bfs(1, 1);
		visited = new boolean[N + 1][M + 1];
		bfsWithSword(1, 1);

		if (res > T && resWithSword > T) {
			System.out.println("Fail");
		} else {
			System.out.println((resWithSword > res) ? res : resWithSword);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Warrior> queue = new LinkedList<>();
		queue.offer(new Warrior(x, y, 0));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Warrior now = queue.poll();
			// 공주를 찾은 경우
			if (now.x == N && now.y == M) {
				res = Math.min(res, now.time);
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 1 || nx > N || ny < 1 || ny > M)
					continue;

				// 길인 경우
				if (!visited[nx][ny] && map[nx][ny] == 0) {
					// 공주를 찾은 경우
					visited[nx][ny] = true;
					queue.add(new Warrior(nx, ny, now.time + 1));
				}

				// 벽인 경우
				else if (!visited[nx][ny] && map[nx][ny] == 1) {
					continue;
				}

				// 검을 발견한 경우
				else if (!visited[nx][ny] && map[nx][ny] == 2) {
					continue;
				}

			}

		}

	}

	private static void bfsWithSword(int x, int y) {
		Queue<Warrior> queue = new LinkedList<>();
		queue.offer(new Warrior(x, y, 0));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Warrior now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 1 || nx > N || ny < 1 || ny > M)
					continue;

				// 길인 경우
				if (!visited[nx][ny] && map[nx][ny] == 0) {
					// 공주를 찾은 경우
					visited[nx][ny] = true;
					queue.add(new Warrior(nx, ny, now.time + 1));
				}

				// 벽인 경우
				else if (!visited[nx][ny] && map[nx][ny] == 1) {
					continue;
				}

				// 검을 발견한 경우 -> 최단거리로 직행
				else if (!visited[nx][ny] && map[nx][ny] == 2) {
					int xAfter = N - nx;
					int yAfter = M - ny;
					resWithSword = now.time + 1 + xAfter + yAfter;
					return;
				}

			}

		}

	}
}
