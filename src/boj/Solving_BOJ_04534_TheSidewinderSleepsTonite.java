package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solving_BOJ_04534_TheSidewinderSleepsTonite {

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	private static int H, W;
	private static char[][] map;
	private static int[][] visited;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[2 * H + 1][2 * W + 1];
			visited = new int[2 * H + 1][2 * W + 1];

			for (int i = 0; i < 2 * H + 1; i++) {
				String str = br.readLine();
				for (int j = 0; j < 2 * W + 1; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			boolean isValid = true;
			loop: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					int cnt = 0;
					if (map[i][j] >= '1' && map[i][j] <= '3') {
						cnt = count(i, j);

						if (cnt != map[i][j] - '0') {
							isValid = false;
							break loop;
						}
					}
				}
			}

			boolean isLoop = false;
			loop: for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] == '-' || map[i][j] == '|') {
						if (checkLoop(i, j)) {
							isLoop = true;
							break loop;
						}
					}
				}
			}

			if (isValid && isLoop) {
				sb.append("VALID").append('\n');
			} else {
				sb.append("INVALID").append('\n');
			}
		}

		System.out.println(sb.toString());
	}

	private static int count(int x, int y) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isPossible(nx, ny))
				continue;

			if (map[nx][ny] == '-' || map[nx][ny] == '|')
				cnt++;
		}

		return cnt;
	}

	// bfs
	private static boolean checkLoop(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		visited[x][y] = 1;
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (!isPossible(nx, ny))
					continue;

				if (visited[nx][ny] != 0)
					continue;

				if (map[nx][ny] == '#' || map[nx][ny] == '-' || map[nx][ny] == '|') {
					visited[nx][ny] += 1;
					print();
					queue.offer(new Point(nx, ny));
				}

			}
		}

		return true;
	}

	private static boolean isPossible(int x, int y) {
		if (x >= 0 && x < map.length && y >= 0 && y < map[0].length) {
			return true;
		}

		return false;

	}

	private static void print() {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==================================");
	}

}
